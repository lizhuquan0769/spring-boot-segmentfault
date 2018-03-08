package com.segmentfault.springboot.lession12.validation.spring;

import com.segmentfault.springboot.lession12.bean.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by lizhuquan on 2018/3/8.
 */
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = Person.class.cast(target);

        if (person.getName().startsWith("segmentfault-")) {
            errors.reject("person.name.prefix", "人的名字必须以[segmentfault-]开头");
        }
    }
}
