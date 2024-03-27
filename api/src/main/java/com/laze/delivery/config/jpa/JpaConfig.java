package com.laze.delivery.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.laze.delivery.db")
@EnableJpaRepositories(basePackages = "com.laze.delivery.db")
public class JpaConfig {
}
