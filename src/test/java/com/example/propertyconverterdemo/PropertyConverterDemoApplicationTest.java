package com.example.propertyconverterdemo;

import static com.example.propertyconverterdemo.PropertyConverterDemoApplication.ADDITION;
import static com.example.propertyconverterdemo.PropertyConverterDemoApplication.FIRST_VALUE;
import static com.example.propertyconverterdemo.PropertyConverterDemoApplication.SECOND_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.core.convert.support.GenericConversionService;

import com.example.propertyconverterdemo.configuration.ComplexImpl;
import com.example.propertyconverterdemo.configuration.SimpleImpl;
import com.example.propertyconverterdemo.converters.ComplexStringWrapperConverter;
import com.example.propertyconverterdemo.converters.StringWrapperConverter;
import com.example.propertyconverterdemo.properties.ComplexStringWrapperProperties;
import com.example.propertyconverterdemo.properties.StringWrapperProperties;
import com.example.propertyconverterdemo.properties.file.PropertiesAutoConfiguration;
import com.example.propertyconverterdemo.propertywrappers.ComplexStringWrapper;
import com.example.propertyconverterdemo.propertywrappers.StringWrapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PropertyConverterDemoApplicationTest {
	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
			.withUserConfiguration(PropertyConverterDemoApplication.class).withConfiguration(AutoConfigurations.of(PropertiesAutoConfiguration.class));

	@Autowired
	private StringWrapperProperties stringWrapperProperties;

	@Autowired
	private ComplexStringWrapperProperties complexStringWrapperProperties;

	@Test
	void testFullAppSimple_doesNotWork() {
		assertEquals(FIRST_VALUE, stringWrapperProperties.getValue());
		assertEquals(SECOND_VALUE + ADDITION, stringWrapperProperties.stringWrapper());
	}

	@Test
	void testFullAppComplex_worksAsExpected() {
		assertEquals(FIRST_VALUE, complexStringWrapperProperties.getValue());
		assertEquals(SECOND_VALUE + ADDITION, complexStringWrapperProperties.complexStringWrapper());
	}

	@Test
	void testBindingSimple_worksAsExpected() {
		contextRunner.withConfiguration(AutoConfigurations.of(SimpleImpl.class)).run(ctx -> {
			assertThat(ctx).hasNotFailed();
			final StringWrapperProperties stringWrapperProperties = ctx.getBean(StringWrapperProperties.class);
			assertEquals(FIRST_VALUE, stringWrapperProperties.getValue());
			assertEquals(SECOND_VALUE + ADDITION, stringWrapperProperties.stringWrapper());
		});
	}


	@Test
	void testBindingComplex_worksAsExpected() {
		contextRunner.withConfiguration(AutoConfigurations.of(ComplexImpl.class)).run(ctx -> {
			assertThat(ctx).hasNotFailed();
			final ComplexStringWrapperProperties complexStringWrapperProperties = ctx.getBean(ComplexStringWrapperProperties.class);
			assertEquals("first-value", complexStringWrapperProperties.getValue());
			assertEquals(SECOND_VALUE + ADDITION, complexStringWrapperProperties.complexStringWrapper());
		});
	}

	@Test
	void convertToStringWrapper_worksAsExpected() {
		final GenericConversionService conversionService = new GenericConversionService();
		conversionService.addConverter(new StringWrapperConverter());
		assertTrue(conversionService.canConvert(String.class, StringWrapper.class));
		final StringWrapper stringWrapper = conversionService.convert("test", StringWrapper.class);
		assertEquals(new StringWrapper("test" + ADDITION), stringWrapper);
	}

	@Test
	void convertToComplexStringWrapper_worksAsExpected() {
		final GenericConversionService conversionService = new GenericConversionService();
		conversionService.addConverter(new ComplexStringWrapperConverter());
		assertTrue(conversionService.canConvert(String.class, ComplexStringWrapper.class));
		final ComplexStringWrapper stringWrapper = conversionService.convert("test", ComplexStringWrapper.class);
		assertEquals(new ComplexStringWrapper("test" + ADDITION, BigDecimal.ONE), stringWrapper);
	}
}