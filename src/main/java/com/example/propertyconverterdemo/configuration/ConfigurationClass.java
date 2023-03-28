package com.example.propertyconverterdemo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.propertyconverterdemo.converters.ComplexStringWrapperConverter;
import com.example.propertyconverterdemo.converters.SimpleStringWrapperConverter;
import com.example.propertyconverterdemo.properties.StringWrapperProperties;

@Configuration
public class ConfigurationClass {

	@Bean
	SimpleStringWrapperConverter stringWrapperConverter() {
		return new SimpleStringWrapperConverter();
	}

	@Bean
	ComplexStringWrapperConverter complexStringWrapperConverter() {
		return new ComplexStringWrapperConverter();
	}

	@Bean
	@ConfigurationProperties(prefix = "demo", ignoreUnknownFields = false)
	StringWrapperProperties stringWrapperClass() {
		return new StringWrapperProperties();
	}
}
