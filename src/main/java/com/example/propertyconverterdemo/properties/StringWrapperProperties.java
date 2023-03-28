package com.example.propertyconverterdemo.properties;


import com.example.propertyconverterdemo.propertywrappers.ComplexStringWrapper;
import com.example.propertyconverterdemo.propertywrappers.SimpleStringWrapper;

public class StringWrapperProperties {
	private ComplexStringWrapper complexStringWrapper;
	private SimpleStringWrapper simpleStringWrapper;


	public ComplexStringWrapper getComplexStringWrapper() {
		return complexStringWrapper;
	}

	public void setComplexStringWrapper(ComplexStringWrapper complexStringWrapper) {
		this.complexStringWrapper = complexStringWrapper;
	}

	public SimpleStringWrapper getSimpleStringWrapper() {
		return simpleStringWrapper;
	}

	public void setSimpleStringWrapper(SimpleStringWrapper simpleStringWrapper) {
		this.simpleStringWrapper = simpleStringWrapper;
	}

	@Override
	public String toString() {
		return "StringWrapperProperties{" +
				"complexStringWrapper=" + complexStringWrapper +
				", simpleStringWrapper=" + simpleStringWrapper +
				'}';
	}
}
