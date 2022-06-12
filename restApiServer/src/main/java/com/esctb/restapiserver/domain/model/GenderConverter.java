package com.esctb.restapiserver.domain.model;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter extends EnumValueConverter<Gender>{
    GenderConverter(){super(Gender.class);}
}
