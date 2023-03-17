package com.fundrise.gto.core.config.secrets.configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.fundrise.gto.core.config.secrets.properties.PropertiesInterface;

@AutoConfiguration
public class SimpleImpl implements SimpleInterface {
	private static final Logger log = LoggerFactory.getLogger(SimpleImpl.class);

	@Bean
	Object otherBean2(List<PropertiesInterface> props) {
		props.forEach(obj -> log.info("Obj: {}", obj));
		return new Object();
	}
}
