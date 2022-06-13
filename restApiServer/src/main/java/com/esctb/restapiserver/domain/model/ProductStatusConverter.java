package com.esctb.restapiserver.domain.model;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProductStatusConverter extends EnumValueConverter<ProductStatus>{
    ProductStatusConverter(){super(ProductStatus.class);}
}
