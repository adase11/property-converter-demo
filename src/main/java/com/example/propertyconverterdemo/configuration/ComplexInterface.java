package com.example.propertyconverterdemo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.example.propertyconverterdemo.converters.ComplexStringWrapperConverter;
import com.example.propertyconverterdemo.properties.ComplexStringWrapperProperties;

public interface ComplexInterface extends BaseInterface {

	@Bean
	default ComplexStringWrapperConverter complexStringWrapperConverter() {
		return new ComplexStringWrapperConverter();
	}

	@Bean
	@ConfigurationProperties(prefix = "complex", ignoreUnknownFields = false)
	default ComplexStringWrapperProperties complexStringWrapperClass() {
		return new ComplexStringWrapperProperties();
	}
}
