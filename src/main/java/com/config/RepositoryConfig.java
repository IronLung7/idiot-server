package com.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by zhlingyu on 2016/7/28.
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.v.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.v.domain"})
public class RepositoryConfig {
}
