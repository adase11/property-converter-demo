package com.example.propertysourcedemo.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.example.propertysourcedemo.property.SampleConfigurationProperty;
import com.example.propertysourcedemo.property.SampleConfigurationPropertyOne;

@AutoConfiguration
@PropertySource("classpath:/test/some.properties")
@ConditionalOnProperty(name = "autoconfiguration.file", havingValue = "one")
public class AutoConfigurationOne implements PropertySourceInterface {

	@Override
	@Bean
	@ConfigurationProperties(prefix = "prop.one", ignoreUnknownFields = false)
	public SampleConfigurationProperty sampleConfigurationProperty() {
		return new SampleConfigurationPropertyOne();
	}
}
