package com.esctb.restapiserver.domain.model;

public enum Gender implements EnumMapperType{

    M("M","수컷"),
    W("W","암컷");

    private final String code;
    private final String des;

    Gender(String code,String des){
        this.code=code;
        this.des=des;
    }

    @Override
    public String getCode(){return code;}

    @Override
    public String getDes(){return des;}
}
