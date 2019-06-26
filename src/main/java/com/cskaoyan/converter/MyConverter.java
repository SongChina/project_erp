package com.cskaoyan.converter;




import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class MyConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        return null;
    }
}
