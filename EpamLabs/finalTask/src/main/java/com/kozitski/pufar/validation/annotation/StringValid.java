package com.kozitski.pufar.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface StringValid {

    int minLength() default  DefaultValidationParameter.MIN_LENGTH;
    int maxLength() default  DefaultValidationParameter.MAX_LENGTH;
    String validateRegExp() default  DefaultValidationParameter.LOGIN_VALIDATE_PATTERN;
    String forbiddenValue() default  DefaultValidationParameter.FORBIDDEN_VALUE;

}
