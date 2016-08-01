package com.v.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhlingyu on 2016/7/29.
 */
@Controller
public class Route {

    @RequestMapping({
            "/bikes",
            "/milages",
            "/gallery",
            "/tracks",
            "/tracks/{id:\\w+}",
            "/location",
            "/about"
    })
    public String index() {
        return "forward:/localhost.html";
    }
}