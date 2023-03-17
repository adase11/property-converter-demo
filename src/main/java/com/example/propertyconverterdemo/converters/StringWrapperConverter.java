package com.fundrise.gto.core.config.secrets.converters;

import java.util.function.Function;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;

import com.fundrise.gto.core.config.secrets.propertywrappers.StringWrapper;

@ConfigurationPropertiesBinding
public class StringWrapperConverter implements Converter<String, StringWrapper> {

	private final Function<String, StringWrapper> function = s -> new StringWrapper(s + "-additional-1");

	@Override
	public StringWrapper convert(@NotNull String source) {
		return function.apply(source);
	}
}
