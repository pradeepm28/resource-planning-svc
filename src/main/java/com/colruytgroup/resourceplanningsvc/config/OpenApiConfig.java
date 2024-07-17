package com.colruytgroup.resourceplanningsvc.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI resourcePlanningApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Resource Planning API")
                        .description("Resource planning api to create/update planning for the coworker")
                        .version("v1.0.0"));
    }
}
