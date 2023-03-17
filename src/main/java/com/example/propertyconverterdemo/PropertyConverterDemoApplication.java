package com.example.propertyconverterdemo;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import com.example.propertyconverterdemo.configuration.ComplexImpl;
import com.example.propertyconverterdemo.configuration.SimpleImpl;

@SpringBootApplication
@ImportAutoConfiguration(classes = {SimpleImpl.class, ComplexImpl.class, Properties.class})
@ConfigurationPropertiesScan
public class PropertyConverterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyConverterDemoApplication.class, args);
	}

}
