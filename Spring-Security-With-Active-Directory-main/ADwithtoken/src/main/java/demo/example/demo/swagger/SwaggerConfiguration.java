package demo.example.demo.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    // Configure and customize Swagger documentation
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI() 
            // Configure security schemes (Bearer Authentication)
            .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
            // Add security requirement at method level (Bearer Authentication)
            .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
            // Configure general information about the API
            .info(new Info().title("Active Directory")
                    .description("Authenticate all users with same domain by using Active Directory")
                    .contact(new Contact().name("Vijay").email("vijay@gmail.com").url("vijay@gmail.com"))
            );
    }

    // Configure Bearer Authentication scheme
    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
