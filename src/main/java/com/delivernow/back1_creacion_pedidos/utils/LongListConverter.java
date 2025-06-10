package com.delivernow.back1_creacion_pedidos.utils;

import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LongListConverter implements AttributeConverter<List<Long>, Long[]> {

    @Override
    public Long[] convertToDatabaseColumn(List<Long> attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.toArray(new Long[0]);
    }

    @Override
    public List<Long> convertToEntityAttribute(Long[] dbData) {
        if (dbData == null) {
            return null;
        }
        return Arrays.asList(dbData);
    }
}