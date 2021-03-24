package io.springboot2.x.validater;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import io.springboot2.x.annotations.CommPreference;

public class CommPreferenceValidator implements ConstraintValidator<CommPreference, String> {
	 
    private final List<String> commPreferences  = Arrays.asList("email", "mobilePhone");
     
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return commPreferences.contains(value);
    }
 
}
