package com.kotbegemot.testtask2.api.annotation;

import com.kotbegemot.testtask2.api.annotation.validator.ValidDateValidator;
import com.kotbegemot.testtask2.api.annotation.validator.ValidLibraryRecordDTOValidator;

import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ValidLibraryRecordDTOValidator.class})
public @interface ValidLibraryRecordDTO {
}
