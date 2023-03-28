package com.example.propertyconverterdemo;

import static com.example.propertyconverterdemo.PropertyConverterDemoApplication.ADDITION;
import static com.example.propertyconverterdemo.PropertyConverterDemoApplication.COMPLEX_VALUE;
import static com.example.propertyconverterdemo.PropertyConverterDemoApplication.SIMPLE_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.core.convert.support.GenericConversionService;

import com.example.propertyconverterdemo.configuration.ConfigurationClass;
import com.example.propertyconverterdemo.converters.SimpleStringWrapperConverter;
import com.example.propertyconverterdemo.properties.StringWrapperProperties;
import com.example.propertyconverterdemo.propertywrappers.SimpleStringWrapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PropertyConverterDemoApplicationTest {
	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner().withUserConfiguration(PropertyConverterDemoApplication.class);

	@Autowired
	private StringWrapperProperties stringWrapperProperties;

	List<Executable> buildAssertions(StringWrapperProperties props) {
		return List.of(
				() -> assertEquals(COMPLEX_VALUE + ADDITION, props.getComplexStringWrapper().value()),
				() -> assertEquals(SIMPLE_VALUE + ADDITION, props.getSimpleStringWrapper().value(), "This should pass if the converter was registered correctly.")
		);
	}

	@Test
	@DisplayName("Using @SpringBootTest. Demonstrate that for the 'simple' case the converter does take effect.")
	void testFullAppSimple_doesNotWork() {
		assertAll(
				buildAssertions(stringWrapperProperties)
		);

	}

	@Test
	@DisplayName("Using ApplicationContextRunner. Demonstrates that the issue is only reproducible using @SpringBootTest.")
	void testBindingSimple_worksAsExpected() {
		contextRunner.withConfiguration(UserConfigurations.of(ConfigurationClass.class))
				.withPropertyValues(
						"demo.complexStringWrapper=complex-value",
						"demo.simpleStringWrapper=simple-value"
				)
				.run(ctx -> {
					assertThat(ctx).hasNotFailed();
					final StringWrapperProperties props = ctx.getBean(StringWrapperProperties.class);
					assertAll(
							buildAssertions(props)
					);
				});
	}

	@Test
	@DisplayName("Confirms that the converter works (that it adds the value of ADDITION to the property string).")
	void convertToStringWrapper_worksAsExpected() {
		final GenericConversionService conversionService = new GenericConversionService();
		conversionService.addConverter(new SimpleStringWrapperConverter());
		assertTrue(conversionService.canConvert(String.class, SimpleStringWrapper.class));
		final SimpleStringWrapper stringWrapper = conversionService.convert("test", SimpleStringWrapper.class);
		assertEquals(new SimpleStringWrapper("test" + ADDITION), stringWrapper);
	}
}