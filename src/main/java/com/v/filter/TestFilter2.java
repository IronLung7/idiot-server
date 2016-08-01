package com.v.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhlingyu on 2016/7/29.
 */
//@WebFilter(urlPatterns = {"/user/*"}, description = "test Filter")
public class TestFilter2 implements Filter {
    private FilterConfig config = null;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        System.out.println("init filter2222");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain)
            throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        //
        // Check to see if user's session attribute contains an attribute
        // named AUTHENTICATED. If the attribute is not exists redirect
        // user to the login page.
        //
        System.out.println("do filter2222 :"+((HttpServletRequest) req).getRequestURI());
        chain.doFilter(req, res);
    }

    public void destroy() {
        config.getServletContext().log("Destroying SessionCheckerFilter");
    }
}