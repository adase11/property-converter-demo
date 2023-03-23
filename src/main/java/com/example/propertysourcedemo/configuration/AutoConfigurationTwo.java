package com.example.propertysourcedemo.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.example.propertysourcedemo.property.SampleConfigurationProperty;
import com.example.propertysourcedemo.property.SampleConfigurationPropertyTwo;

@AutoConfiguration
@ConditionalOnProperty(name = "autoconfiguration.file", havingValue = "two")
public class AutoConfigurationTwo implements PropertySourceInterface {

	@Override
	@Bean
	@ConfigurationProperties(prefix = "prop.two", ignoreUnknownFields = false)
	public SampleConfigurationProperty sampleConfigurationProperty() {
		return new SampleConfigurationPropertyTwo();
	}
}
