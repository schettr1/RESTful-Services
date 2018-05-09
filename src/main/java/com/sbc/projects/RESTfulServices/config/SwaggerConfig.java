package com.sbc.projects.RESTfulServices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@ComponentScan
@EnableSwagger2
public class SwaggerConfig {

/**
 * This class is used to Generate API documents for the clients
 * It gives detail description of all the services, parameters, constraints, response status etc
 * @Visit 'http://localhost:8080/v2/api-docs' to view report in plain format
 * @Visit 'http://localhost:8080/swagger-ui.html' to view report with UI features
 **/ 
	
	
	@Bean
	public Docket produceAPI(){
		
		return new Docket(DocumentationType.SWAGGER_2);		
	}
}

/*
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.sbc.projects.RESTfulServices.controller"))
				.paths(regex("/rest.*"))
				.build();	
*/