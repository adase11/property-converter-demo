package com.example.propertyconverterdemo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.example.propertyconverterdemo.converters.StringWrapperConverter;
import com.example.propertyconverterdemo.properties.StringWrapperProperties;

public interface SimpleInterface extends BaseInterface {

	@Bean
	default StringWrapperConverter stringWrapperConverter() {
		return new StringWrapperConverter();
	}

	@Bean
	@ConfigurationProperties(prefix = "simple", ignoreUnknownFields = false)
	default StringWrapperProperties stringWrapperClass() {
		return new StringWrapperProperties();
	}
}
