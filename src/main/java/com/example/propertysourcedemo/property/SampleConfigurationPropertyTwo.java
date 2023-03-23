package com.example.propertysourcedemo.property;

import org.springframework.util.StringUtils;

public class SampleConfigurationPropertyTwo implements SampleConfigurationProperty{
	private String propertyOne;
	private String propertyTwo;

	public String getPropertyOne() {
		return propertyOne;
	}

	public void setPropertyOne(String propertyOne) {
		this.propertyOne = propertyOne;
	}

	public String getPropertyTwo() {
		return propertyTwo;
	}

	public void setPropertyTwo(String propertyTwo) {
		this.propertyTwo = propertyTwo;
	}

	@Override
	public boolean isValid() {
		return StringUtils.hasText(propertyOne) && StringUtils.hasText(propertyTwo);
	}

	@Override
	public String toString() {
		return "SampleConfigurationPropertyTwo{" +
				"propertyOne='" + propertyOne + '\'' +
				", propertyTwo='" + propertyTwo + '\'' +
				'}';
	}
}
