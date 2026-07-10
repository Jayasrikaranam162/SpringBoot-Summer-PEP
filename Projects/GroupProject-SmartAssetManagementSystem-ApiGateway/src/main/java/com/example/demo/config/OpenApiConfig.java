package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {

		return new OpenAPI()

				.info(

						new Info()

								.title(

										"Smart Asset Management API"

								)

								.version("1.0")

								.description(

										"Enterprise Asset Management System"

								)

								.contact(

										new Contact()

												.name(

														"Md Parvez"

												)

												.email(

														"parvez@example.com"

												)

								)

				);

	}

}