package com.example.propertyconverterdemo.converters;

import static com.example.propertyconverterdemo.PropertyConverterDemoApplication.ADDITION;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;

import com.example.propertyconverterdemo.propertywrappers.ComplexStringWrapper;

@ConfigurationPropertiesBinding
public class ComplexStringWrapperConverter implements Converter<String, ComplexStringWrapper> {

	@Override
	public ComplexStringWrapper convert(String source) {
		return new ComplexStringWrapper(source + ADDITION, source);
	}
}