package com.m.s.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    // Load file: validation.properties
    messageSource.base

}
