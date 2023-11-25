package com.usuarios.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@OpenAPIDefinition
@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info().title("MONOPATINES")
                .version("1.0-SNAPSHOT").description("APP DE MONOPATINES"));
                
    }

}
