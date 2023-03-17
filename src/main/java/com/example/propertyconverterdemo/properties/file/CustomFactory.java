package com.example.propertyconverterdemo.properties.file;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

public class CustomFactory extends DefaultPropertySourceFactory {

	private static final Logger log = LoggerFactory.getLogger(CustomFactory.class);

	@Override
	public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
		log.info("Using {}", this.getClass());
		return super.createPropertySource(name, resource);
	}
}
