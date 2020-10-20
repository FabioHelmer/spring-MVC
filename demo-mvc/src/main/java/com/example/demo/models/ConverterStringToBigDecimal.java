package com.example.demo.models;

import java.math.BigDecimal;

import javax.persistence.AttributeConverter;

public class ConverterStringToBigDecimal implements AttributeConverter<String, BigDecimal> {

	@Override
	public BigDecimal convertToDatabaseColumn(String attribute) {
		return new BigDecimal(attribute);
	}

	@Override
	public String convertToEntityAttribute(BigDecimal dbData) {
		return dbData.toString();
	}

}
