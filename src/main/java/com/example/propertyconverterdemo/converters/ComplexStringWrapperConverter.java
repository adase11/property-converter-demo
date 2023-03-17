package com.example.propertyconverterdemo.converters;

import static com.example.propertyconverterdemo.PropertyConverterDemoApplication.ADDITION;

import java.math.BigDecimal;
import java.util.function.Function;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;

import com.example.propertyconverterdemo.propertywrappers.ComplexStringWrapper;


@ConfigurationPropertiesBinding
public class ComplexStringWrapperConverter implements Converter<String, ComplexStringWrapper> {

	private final Function<String, ComplexStringWrapper> function = s -> new ComplexStringWrapper(s + ADDITION, BigDecimal.ONE);

	@Override
	public ComplexStringWrapper convert(String source) {
		return function.apply(source);
	}
}
