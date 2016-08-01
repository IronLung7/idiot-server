package com.v.controller;

import com.v.domain.AppUser;
import com.v.repository.UserRepository;
import com.v.service.UserService;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhlingyu on 2016/7/28.
 */

@RestController
@WebSocket(maxIdleTime = 600000, inputBufferSize = 65536, maxTextMessageSize = 5242880)
public class HelloController {
    private static final int WS_WAIT_TIMEOUT_SECONDS = 10;
    // 600000 ms <=> 10 minutes
    private static final int IDLE_TIMEOUT = 600000;
    // 64 KB <=> 65536
    private static final int INPUT_BUFFER_SIZE = 65536;
    // 5 Megabyte <=> 5242880
    private static final int MAX_MESSAGE_SIZE = 5242880;


    Session mSession;



    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppUser create(@PathVariable String username) {
        return userService.createUser();
    }

    @RequestMapping("/a")
    public String vv() {
        return  userRepository.save(new AppUser("vv")).getUsername();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppUser> findAll() {
        final List<AppUser> resultList = new ArrayList<AppUser>();
        final Iterator<AppUser> all = userRepository.findAll().iterator();
        while (all.hasNext()){
            resultList.add(all.next());
        }
        return resultList;
    }

    @RequestMapping("/test")
    public void test() {
        if (mSession == null) {
            Future<Session> sessionFuture = null;
            try {
                WebSocketClient webSocketClient = new WebSocketClient();
                webSocketClient.getPolicy().setMaxTextMessageSize(MAX_MESSAGE_SIZE);
                webSocketClient.getPolicy().setMaxTextMessageBufferSize(INPUT_BUFFER_SIZE);
                webSocketClient.getPolicy().setMaxBinaryMessageBufferSize(INPUT_BUFFER_SIZE);
                webSocketClient.getPolicy().setInputBufferSize(INPUT_BUFFER_SIZE);
                webSocketClient.getPolicy().setIdleTimeout(IDLE_TIMEOUT);
                webSocketClient.start();
                URI uri = new URI("ws://15.107.7.55:8080/chat/");
                sessionFuture = webSocketClient.connect(this, uri, new ClientUpgradeRequest());
                mSession = sessionFuture.get(WS_WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("exception" + e.getMessage());
                mSession = null;
            }
        }
    }

    @RequestMapping("/send")
    public void send() {
        if (mSession != null) {
            try {
                System.out.println("send string");
                mSession.getRemote().sendString("{\"message\":\"message\",\"author\":\"author\"}");
            } catch (IOException e) {
                System.out.println("IOException e");
                e.printStackTrace();
            }
        }
    }


    @OnWebSocketMessage
    public void doHandle(String message) {
        System.out.println("doHandler:"+message);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.println("doHandler" +statusCode +" "+reason);
    }



    @OnWebSocketError
    public void onError(Throwable ex) {
        System.out.println("onError"+ex.getMessage());
    }

    @OnWebSocketConnect
    public void onSuccess(Session session){
        System.out.println("onSuccess"+session.toString());

    }
}
