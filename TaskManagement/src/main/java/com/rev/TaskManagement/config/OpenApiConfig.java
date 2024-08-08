package com.rev.TaskManagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenAPI customOpenApi(){
        return new OpenAPI().info(
                new Info().title("Rev task management")
                        .version("0.1")
                        .description("API's for task and project management")
        );
    }
}
