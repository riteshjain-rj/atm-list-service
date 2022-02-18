package com.atm.list.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HTTPClientConfig {
    @Bean(name = "restTemplate")
    public RestTemplate atmRestTemplate(){
        return new RestTemplate();
    }
}
