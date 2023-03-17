package com.fundrise.gto.core.config.secrets.converters;

import java.math.BigDecimal;
import java.util.function.Function;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;

import com.fundrise.gto.core.config.secrets.propertywrappers.ComplexStringWrapper;

@ConfigurationPropertiesBinding
public class ComplexStringWrapperConverter implements Converter<String, ComplexStringWrapper> {

	private final Function<String, ComplexStringWrapper> function = s -> new ComplexStringWrapper(s + "-additional-2", BigDecimal.ONE);

	@Override
	public ComplexStringWrapper convert(@NotNull String source) {
		return function.apply(source);
	}
}
