package com.esctb.restapiserver.domain.model;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public class EnumValueConverter <E extends Enum<E> &EnumMapperType> implements AttributeConverter<E,String> {

    private  Class<E> clz;

    EnumValueConverter(Class<E> enumClass){this.clz=enumClass;}

    @Override
    public String convertToDatabaseColumn(E attribute){return attribute.getCode();}

    @Override
    public E convertToEntityAttribute(String dbData){
        return EnumSet.allOf(clz).stream()
                .filter(e->e.getCode().equals(dbData))
                .findAny()
                .orElseThrow(()->new NoSuchElementException());
    }
}
