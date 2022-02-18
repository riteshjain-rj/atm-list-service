package com.atm.list.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OpenApi {
    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.description}") String appDesciption, @Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                .title("sample application API")
                .version(appVersion)
                .description(appDesciption)
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
