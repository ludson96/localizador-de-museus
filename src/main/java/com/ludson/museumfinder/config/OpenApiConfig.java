package com.ludson.museumfinder.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI and Swagger configuration.
 */
@Configuration
public class OpenApiConfig {

  /**
   * Custom OpenAPI documentation setup.
   */
  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
        .info(new Info()
            .title("Museum Finder API 🏛️")
            .version("1.0.0")
            .description("API REST para busca e localização geoespacial de museus brasileiros "
                + "baseada em coordenadas de latitude e longitude, além de estatísticas "
                + "por tipo de acervo cultural.")
            .contact(new Contact()
                .name("Ludson")
                .url("https://github.com/ludson96"))
            .license(new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT")));
  }
}
