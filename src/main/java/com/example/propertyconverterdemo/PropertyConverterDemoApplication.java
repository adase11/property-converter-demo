package com.example.propertyconverterdemo;

import jakarta.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.propertyconverterdemo.properties.StringWrapperProperties;
import com.example.propertyconverterdemo.propertywrappers.ComplexStringWrapper;
import com.example.propertyconverterdemo.propertywrappers.SimpleStringWrapper;

@SpringBootApplication
@EnableConfigurationProperties
public class PropertyConverterDemoApplication {

	public static final String COMPLEX_VALUE = "complex-value";
	public static final String SIMPLE_VALUE = "simple-value";
	public static final String ADDITION = "-addition";

	private static final Logger log = LoggerFactory.getLogger(PropertyConverterDemoApplication.class);

	@Autowired
	private StringWrapperProperties stringWrapperProperties;

	@PostConstruct
	void postConstruct() {
		final StringWrapperProperties expectedProperties = buildExpectedProperties();
		log.info("Expected : {}", expectedProperties);
		log.info("Actual   : {}", stringWrapperProperties);
		log.info("Expected equals actual?: {}", expectedProperties.equals(stringWrapperProperties));
	}

	private StringWrapperProperties buildExpectedProperties() {
		final StringWrapperProperties expected = new StringWrapperProperties();
		expected.setSimpleStringWrapper(new SimpleStringWrapper(SIMPLE_VALUE + ADDITION));
		expected.setComplexStringWrapper(new ComplexStringWrapper(COMPLEX_VALUE + ADDITION, COMPLEX_VALUE));
		return expected;
	}

	public static void main(String[] args) {
		SpringApplication.run(PropertyConverterDemoApplication.class, args);
	}

}
