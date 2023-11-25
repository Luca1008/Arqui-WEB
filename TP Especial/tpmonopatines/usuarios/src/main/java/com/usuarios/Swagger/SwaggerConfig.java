package com.usuarios.Swagger;

// import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;



// @OpenAPIDefinition
// @Configuration
// public class SwaggerConfig {


//     @Bean
//     public OpenAPI api(){
//         return new OpenAPI().info(new Info().title("MONOPATINES")
//                 .version("1.0-SNAPSHOT").description("APP DE MONOPATINES"));
                
//     }

// }
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Documentación de la API")
                .version("1.0")
                .description("Descripción de la API"));
    }
}