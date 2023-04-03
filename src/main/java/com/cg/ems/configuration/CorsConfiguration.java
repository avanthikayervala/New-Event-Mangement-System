package com.cg.ems.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//Cross-Origin Resource Sharing (CORS) for a Spring application.
@Configuration
public class CorsConfiguration {

	private static final String GET ="GET";
	private static final String POST ="POST";
	private static final String PUT ="PUT";
	private static final String DELETE ="DELETE";
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			//("/**")  method sets the CORS configuration for all endpoints in the application.m
			@Override
			public  void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods(GET,PUT,POST,DELETE).allowedHeaders("*")
				.allowedOriginPatterns("*").allowCredentials(true);
			}
		};
	}
}
