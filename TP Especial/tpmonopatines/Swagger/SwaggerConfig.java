import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info().title("NOMBRE DE MI PROYECTO")
                .version("1.0-SNAPSHOT").description("Api what order of manage functions of type Book")
                .contact(new Contact().url("https://twitter.com/Imug3tsu2").email("pabloguzman.dev@gmail.com").name("Pablo"))
                .license(new License().name("Spring").url("url de license")).termsOfService("terms Of Service"));
    }

}
