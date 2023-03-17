package com.fundrise.gto.core.config.secrets.properties;

import com.fundrise.gto.core.config.secrets.propertywrappers.StringWrapper;

public class StringWrapperProperties implements PropertiesInterface {
	private String value;
	private StringWrapper stringWrapper;
	private String value2;
	private StringWrapper stringWrapper2;

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String stringWrapper2() {
		return stringWrapper2.value();
	}

	public void setStringWrapper2(StringWrapper stringWrapper2) {
		this.stringWrapper2 = stringWrapper2;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setStringWrapper(StringWrapper stringWrapper) {
		this.stringWrapper = stringWrapper;
	}

	public String stringWrapper() {
		return stringWrapper.value();
	}

	@Override
	public String toString() {
		return "StringWrapperProperties{" +
				"value='" + value + '\'' +
				", stringWrapper=" + stringWrapper +
				", value2='" + value2 + '\'' +
				", stringWrapper2=" + stringWrapper2 +
				'}';
	}
}
