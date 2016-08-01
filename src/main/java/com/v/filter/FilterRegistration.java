package com.v.filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by zhlingyu on 2016/7/29.
 */
@Component
public class FilterRegistration {
    @Bean
    public FilterRegistrationBean test1() {
        final FilterRegistrationBean reg = new FilterRegistrationBean(new TestFilter());
        reg.setName("test1");
        reg.addUrlPatterns("/*");
        reg.setEnabled(true);
        reg.setOrder(2);
        return reg;
    }

    @Bean
    public FilterRegistrationBean test2() {
        final FilterRegistrationBean reg = new FilterRegistrationBean(new TestFilter2());
        reg.setName("test2");
        reg.addUrlPatterns("/user");
        reg.setEnabled(true);
        reg.setOrder(1);
        return reg;
    }
}
