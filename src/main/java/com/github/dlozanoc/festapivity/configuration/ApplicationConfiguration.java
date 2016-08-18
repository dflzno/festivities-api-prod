package com.github.dlozanoc.festapivity.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.github.dlozanoc.festapivity.application")
@ComponentScan(basePackages = "com.github.dlozanoc.festapivity")
public class ApplicationConfiguration {

}