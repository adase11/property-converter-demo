package com.example.propertyconverterdemo.converters;


import static com.example.propertyconverterdemo.PropertyConverterDemoApplication.ADDITION;

import java.util.function.Function;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;

import com.example.propertyconverterdemo.propertywrappers.StringWrapper;


@ConfigurationPropertiesBinding
public class StringWrapperConverter implements Converter<String, StringWrapper> {

	private final Function<String, StringWrapper> function = s -> new StringWrapper(s + ADDITION);

	@Override
	public StringWrapper convert(String source) {
		return function.apply(source);
	}
}
