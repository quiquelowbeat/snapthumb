package com.snapthumb.thumbnailgenerator.config.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SnapThumb API")
                        .version("1.0")
                        .description("API for generating and managing YouTube thumbnails"));
    }
}
