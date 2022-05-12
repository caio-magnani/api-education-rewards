package com.lab3.universitycoins.model.user;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AccoontBankConverter implements
        AttributeConverter<AccontBank, Float> {

    @Override
    public Float convertToDatabaseColumn(AccontBank attribute) {
        // TODO Auto-generated method stub
        return attribute.getCoins();
    }

    @Override
    public AccontBank convertToEntityAttribute(Float dbData) {
        // TODO Auto-generated method stub
        return new AccontBank(dbData);
    }

}
