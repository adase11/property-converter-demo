package com.example.propertyconverterdemo;

import jakarta.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import com.example.propertyconverterdemo.configuration.ComplexImpl;
import com.example.propertyconverterdemo.configuration.SimpleImpl;
import com.example.propertyconverterdemo.properties.ComplexStringWrapperProperties;
import com.example.propertyconverterdemo.properties.StringWrapperProperties;
import com.example.propertyconverterdemo.properties.file.PropertiesAutoConfiguration;

@SpringBootApplication
@ImportAutoConfiguration(classes = {SimpleImpl.class, ComplexImpl.class, PropertiesAutoConfiguration.class})
@ConfigurationPropertiesScan
public class PropertyConverterDemoApplication {

	public static final String FIRST_VALUE = "first-value";
	public static final String SECOND_VALUE = "second-value";
	public static final String ADDITION = "-addition";

	private static final Logger log = LoggerFactory.getLogger(PropertyConverterDemoApplication.class);

	@Autowired
	private StringWrapperProperties stringWrapperProperties;

	@Autowired
	private ComplexStringWrapperProperties complexStringWrapperProperties;

	@PostConstruct
	void postConstruct() {
		log.info("Simple: {}", stringWrapperProperties);
		log.info("Complex: {}", complexStringWrapperProperties);
	}

	public static void main(String[] args) {
		SpringApplication.run(PropertyConverterDemoApplication.class, args);
	}

}
