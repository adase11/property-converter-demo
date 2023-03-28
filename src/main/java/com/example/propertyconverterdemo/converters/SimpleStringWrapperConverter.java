package com.example.propertyconverterdemo.converters;


import static com.example.propertyconverterdemo.PropertyConverterDemoApplication.ADDITION;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;

import com.example.propertyconverterdemo.propertywrappers.SimpleStringWrapper;

@ConfigurationPropertiesBinding
public class SimpleStringWrapperConverter implements Converter<String, SimpleStringWrapper> {

	@Override
	public SimpleStringWrapper convert(String source) {
		return new SimpleStringWrapper(source + ADDITION);
	}
}
