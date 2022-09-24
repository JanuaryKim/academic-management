package com.practice.example.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Collection;

@Component
public class BeanUtils <T> {

    public T copyNotNullProperties(T source, T destination) {

        if (source == null || destination == null) {
            return null;
        }

        BeanWrapper srcWrapper = new BeanWrapperImpl(source);
        BeanWrapper destWrapper = new BeanWrapperImpl(destination);

        for (Field field : source.getClass().getDeclaredFields()) { //필드 데이터

            String fieldName = field.getName(); //필드명
            Object fieldValue = srcWrapper.getPropertyValue(fieldName); //필드값

            if(fieldValue != null)
            {
                destWrapper.setPropertyValue(fieldName, fieldValue);
            }
//            if (sourceProperty != null && !(sourceProperty instanceof Collection<?>)) {
//                dest.setPropertyValue(property.getName(), sourceProperty);
//            }
        }

        return destination;
    }
}
