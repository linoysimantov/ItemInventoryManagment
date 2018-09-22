package com.linoy.inventoryWebApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.linoy.inventoryWebApp.controller.ItemController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses= ItemController.class)
@Configuration
public class SwaggerConfig {
	
	private static final String SWAGGER_API_VERSION="1.0";
	private static final String LICENCE_TEXT="Lisence";
	private static final String title="Item Inventory Managment REST API";
	private static final String description="RESTful API for Item Inventory Managment";
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.license(LICENCE_TEXT)
				.version(SWAGGER_API_VERSION)
				.build();
	}
	
	@Bean 
	public Docket itemsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.pathMapping("/")
				.select()
				.paths(PathSelectors.regex("/items.*"))
				.build();
	}
}
