package com.romario.bookstore_api.custom.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE,})
@Documented
@Constraint(validatedBy = ValidEnumTypeValidator.class)
public @interface ValidEnumType {

    Class<? extends Enum<?>> enumClass();
    String message() default "invalid type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
