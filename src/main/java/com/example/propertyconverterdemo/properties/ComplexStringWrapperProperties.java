package com.fundrise.gto.core.config.secrets.properties;

import com.fundrise.gto.core.config.secrets.propertywrappers.ComplexStringWrapper;

public class ComplexStringWrapperProperties implements PropertiesInterface {
	private String value;
	private ComplexStringWrapper complexStringWrapper;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setComplexStringWrapper(ComplexStringWrapper complexStringWrapper) {
		this.complexStringWrapper = complexStringWrapper;
	}

	public String complexStringWrapper() {
		return complexStringWrapper.value();
	}

	@Override
	public String toString() {
		return "ComplexStringWrapperProperties{" +
				"value='" + value + '\'' +
				", complexStringWrapper=" + complexStringWrapper +
				'}';
	}
}
