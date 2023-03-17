package com.fundrise.gto.core.config.secrets.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.fundrise.gto.core.config.secrets.configuration.BaseInterface;
import com.fundrise.gto.core.config.secrets.converters.ComplexStringWrapperConverter;
import com.fundrise.gto.core.config.secrets.properties.ComplexStringWrapperProperties;

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
