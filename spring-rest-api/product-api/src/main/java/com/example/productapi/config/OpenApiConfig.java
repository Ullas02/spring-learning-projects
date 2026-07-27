package com.example.productapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Metadata shown at the top of the Swagger UI (/swagger-ui.html).
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productApiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product Management API")
                        .description("Module 4 mini project: a REST API for managing products, "
                                + "built with layered architecture (Controller -> Service -> In-Memory Store), "
                                + "validation, and centralized exception handling.")
                        .version("v1.0.0")
                        .contact(new Contact().name("Module 4 Mini Project")));
    }

}
