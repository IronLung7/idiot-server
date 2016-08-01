//package com.v.intercept;
//
//import com.v.filter.TestFilter;
//import com.v.filter.TestFilter2;
//import org.springframework.boot.context.embedded.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//
///**
// * Created by zhlingyu on 2016/7/29.
// */
//@Component
//public class InterceptionRegistration {
//    @Bean
//    public InterceptorRegistry interceptorTest() {
//        System.out.println("interceptor  creating...");
//        final InterceptorRegistry reg = new InterceptorRegistry();
//        reg.addInterceptor(new TestInterceptor()).addPathPatterns("/*");
//        return reg;
//    }
//}
