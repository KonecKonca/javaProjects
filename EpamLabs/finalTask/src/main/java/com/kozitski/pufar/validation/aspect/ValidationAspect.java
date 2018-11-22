package com.kozitski.pufar.validation.aspect;

import com.kozitski.pufar.exception.PufarValidationException;
import com.kozitski.pufar.validation.annotation.StringValid;
import com.kozitski.pufar.validation.util.ValidatorRegister;
import com.kozitski.pufar.validation.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;


@Aspect
public class ValidationAspect {
    private static Logger LOGGER = LogManager.getLogger();

//    @Before("execution(@Entity * com.kozitski.pufar..*WithValid*(..))")
    @Before("@annotation(com.kozitski.pufar.validation.annotation.AspectValid)")
    public void validateString(JoinPoint joinPoint) throws PufarValidationException {

        LOGGER.info("advice is executing");

        validate(joinPoint);

        LOGGER.info("validation complete successfully");
    }


    private void validate(JoinPoint joinPoint) throws PufarValidationException{

//        Class.forName("com.kozitski.pufar.validation.validator.StringValidator").newInstance();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Annotation[][] annotations = methodSignature.getMethod().getParameterAnnotations();
        Object[] args = joinPoint.getArgs();

        ArrayList<Validator> validators = ValidatorRegister.initValidators();

        for (int i = 0; i < args.length; i++) {
            for(Validator validator : validators){
                validator.validate(annotations[i], args[i]);
            }
        }

    }


}
