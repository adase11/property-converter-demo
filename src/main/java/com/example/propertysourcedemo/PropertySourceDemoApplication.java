package com.example.propertysourcedemo;

import jakarta.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.util.Assert;

import com.example.propertysourcedemo.configuration.AutoConfigurationOne;
import com.example.propertysourcedemo.configuration.AutoConfigurationTwo;
import com.example.propertysourcedemo.property.SampleConfigurationProperty;

@SpringBootApplication
@ImportAutoConfiguration(classes = {AutoConfigurationOne.class, AutoConfigurationTwo.class})
@ConfigurationPropertiesScan
public class PropertySourceDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(PropertySourceDemoApplication.class);

	@Autowired
	private SampleConfigurationProperty sampleConfigurationProperty;

	@PostConstruct
	void postConstruct() {
		Assert.isTrue(sampleConfigurationProperty.isValid(), "Invalid " + sampleConfigurationProperty);
		log.info("Successful properties binding {}", sampleConfigurationProperty);
	}


	public static void main(String[] args) {
		SpringApplication.run(PropertySourceDemoApplication.class, args);
	}
}
