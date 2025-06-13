package org.sav.plainspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableLoadTimeWeaving
@ComponentScan(basePackages = "org.sav.plainspring.controller")
public class WebConfig {

}