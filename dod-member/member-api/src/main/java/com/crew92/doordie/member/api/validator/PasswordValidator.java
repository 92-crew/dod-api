package com.crew92.doordie.member.api.validator;


import static java.util.regex.Pattern.compile;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private static final String UPPERCASE = "[A-Z]";
    private static final String LOWERCASE = "[a-z]";
    private static final String SPECIAL_CHARACTERS = "[!@#$%^&*(),.?\\\":{}|<>]";

    private static final Pattern UPPERCASE_PATTERN = compile(UPPERCASE);
    private static final Pattern LOWERCASE_PATTERN = compile(LOWERCASE);
    private static final Pattern SPECIAL_CHARACTERS_PATTERN = compile(SPECIAL_CHARACTERS);

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        if (!UPPERCASE_PATTERN.matcher(password).find()) {
            context.buildConstraintViolationWithTemplate("비밀번호는 영어 대문자를 포함해야 합니다.").addConstraintViolation();
            return false;
        }

        if (!LOWERCASE_PATTERN.matcher(password).find()) {
            context.buildConstraintViolationWithTemplate("비밀번호는 영어 소문자를 포함해야 합니다.").addConstraintViolation();
            return false;
        }

        if (!SPECIAL_CHARACTERS_PATTERN.matcher(password).find()) {
            context.buildConstraintViolationWithTemplate("비밀번호는 특수문자를 포함해야 합니다.").addConstraintViolation();
            return false;
        }

        return true;
    }
}
