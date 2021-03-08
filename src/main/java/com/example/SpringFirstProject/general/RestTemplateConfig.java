package com.example.SpringFirstProject.general;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
 class RestTemplateConfig {
    @Bean
    RestTemplate buildTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
