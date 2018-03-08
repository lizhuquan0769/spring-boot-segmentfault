package com.segmentfault.springboot.lession12.validation.bean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by lizhuquan on 2018/3/8.
 */
public class PersonNamePrefixConstraintValidator implements ConstraintValidator<PersonNamePrefix, String> {

    private String prefix;

    @Override
    public void initialize(PersonNamePrefix constraintAnnotation) {
        this.prefix = constraintAnnotation.prefix();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result = value.startsWith(prefix);
        return result;
    }

}
