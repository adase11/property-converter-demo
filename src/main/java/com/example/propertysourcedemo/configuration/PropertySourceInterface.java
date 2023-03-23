package com.example.propertysourcedemo.configuration;

import org.springframework.context.annotation.PropertySource;

import com.example.propertysourcedemo.property.SampleConfigurationProperty;

@PropertySource("classpath:/test/some.properties")
public interface PropertySourceInterface {

	SampleConfigurationProperty sampleConfigurationProperty();
}
