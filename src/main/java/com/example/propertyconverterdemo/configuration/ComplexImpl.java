package com.example.propertyconverterdemo.configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.propertyconverterdemo.properties.PropertiesInterface;

@AutoConfiguration
public class ComplexImpl implements ComplexInterface {
	private static final Logger log = LoggerFactory.getLogger(ComplexImpl.class);

	@Bean
	Object otherBean3(List<PropertiesInterface> props) {
		props.forEach(obj -> log.info("Obj: {}", obj));
		return new Object();
	}
}
