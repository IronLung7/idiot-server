package com.config;


        import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.v.controller" , "com.v.aspect" , "com.v.listener" , "com.v.filter"})
public class MvcConfig {
}

