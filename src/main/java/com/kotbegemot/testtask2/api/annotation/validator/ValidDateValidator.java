package com.kotbegemot.testtask2.api.annotation.validator;

import com.kotbegemot.testtask2.api.annotation.ValidDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ValidDateValidator implements ConstraintValidator<ValidDate, String> {
    @Override
    public void initialize(ValidDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try{
            LocalDate.parse(s);
        }catch (DateTimeParseException e)
        {
            return false;
        }
        return true;
    }
}
