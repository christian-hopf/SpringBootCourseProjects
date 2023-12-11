package com.example.validationdemo.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String courseCode;

    @Override
    public void initialize(CourseCode code) {
        courseCode = code.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        if (code != null) {
            return code.startsWith(courseCode);
        }
        return true;
    }
}
