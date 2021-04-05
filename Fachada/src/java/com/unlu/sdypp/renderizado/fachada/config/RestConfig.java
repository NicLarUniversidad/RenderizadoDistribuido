package com.unlu.sdypp.renderizado.fachada.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean
    public RestTemplate buildRestTemplate() {
        return new RestTemplate();
    }
}
