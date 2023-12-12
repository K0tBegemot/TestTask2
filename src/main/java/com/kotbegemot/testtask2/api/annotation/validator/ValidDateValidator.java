package com.kotbegemot.testtask2.api.annotation.validator;

import com.kotbegemot.testtask2.api.annotation.ValidDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidDateValidator implements ConstraintValidator<ValidDate, String> {
    private static final Logger logger = LoggerFactory.getLogger(ValidDateValidator.class);
    @Override
    public void initialize(ValidDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try{
            LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch (DateTimeParseException e)
        {
            return false;
        }
        return true;
    }
}
