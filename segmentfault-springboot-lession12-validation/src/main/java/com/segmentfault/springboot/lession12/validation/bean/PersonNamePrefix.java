package com.segmentfault.springboot.lession12.validation.bean;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by lizhuquan on 2018/3/8.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PersonNamePrefixConstraintValidator.class)
public @interface PersonNamePrefix {

    String message() default "{person.name.prefix.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String prefix();
}
