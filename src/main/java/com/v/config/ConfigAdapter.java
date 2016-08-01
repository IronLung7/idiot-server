package com.v.config;

import com.v.intercept.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by zhlingyu on 2016/7/29.
 */
@Configuration
public class ConfigAdapter extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addInterceptors(final InterceptorRegistry registry) {
//
//        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/*");
//    }

//    @Bean
//    public ViewResolver getViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/test/");
//        resolver.setSuffix(".html");
//        return resolver;
//    }
//
//    @Override
//    public void configureDefaultServletHandling(
//            DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

}