package com.fundrise.gto.core.config.secrets.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.fundrise.gto.core.config.secrets.configuration.BaseInterface;
import com.fundrise.gto.core.config.secrets.converters.StringWrapperConverter;
import com.fundrise.gto.core.config.secrets.properties.StringWrapperProperties;

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
