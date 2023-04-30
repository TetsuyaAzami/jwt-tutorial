package com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.jwttutorial.jwtAuthentication.httpRequestRecieveTutorial.authentication.JWTAuthorizationInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	JWTAuthorizationInterceptor jwtAuthenticationInterceptor() {
		//
		return new JWTAuthorizationInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//
		registry.addInterceptor(jwtAuthenticationInterceptor()).addPathPatterns("/api/v1/**");
	}
}
