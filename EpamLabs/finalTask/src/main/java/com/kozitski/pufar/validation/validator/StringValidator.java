package com.kozitski.pufar.validation.validator;

import com.kozitski.pufar.exception.PufarValidationException;
import com.kozitski.pufar.validation.annotation.DefaultValidationParameter;
import com.kozitski.pufar.validation.annotation.StringValid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.annotation.Annotation;

public class StringValidator implements Validator {
    private static Logger LOGGER = LogManager.getLogger();
    
    @Override
    public void validate(Annotation[] annotations, Object object) throws PufarValidationException {
        for(Annotation annotation : annotations){
            if(annotation instanceof StringValid && object instanceof String){
                stringValidation((StringValid) annotation, (String) object);
            }
        }
    }

    private void stringValidation(StringValid annotation, String string) throws PufarValidationException {

        int minLength = annotation.minLength();
        int maxLength = annotation.maxLength();
        String forbiddenValue = annotation.forbiddenValue();

        String validateRegExp = annotation.validateRegExp();

        if(string.length() < minLength || string.length() > maxLength){
            LOGGER.error(string + " is not valid diu to (length" + minLength + ", " + maxLength + ")");
            throw new PufarValidationException(string + " is not valid diu to (length" + minLength + ", " + maxLength + ")");
        }

        if(string.equalsIgnoreCase(forbiddenValue) || string.isEmpty()){
            LOGGER.error(string + " is not valid diu to forbidden value(" + forbiddenValue + ", Empty");
            throw new PufarValidationException(string + " is not valid diu to forbidden value(" + forbiddenValue + ", Empty)");
        }

        if(!string.matches(validateRegExp)){
            LOGGER.error(string + " is not valid diu to regexp(" + validateRegExp + ")");
            throw new PufarValidationException(string + " is not valid diu to regexp(" + validateRegExp + ")");
        }

    }

}
