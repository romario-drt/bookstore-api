package com.romario.bookstore_api.custom.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidEnumTypeValidator implements ConstraintValidator<ValidEnumType, CharSequence> {

    private List<String> acceptedValues;

    @Override
    public void initialize(ValidEnumType annotation) {

        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        return value == null || acceptedValues.contains(value.toString());
    }
}
