package com.kozitski.pufar.validation.util;

import com.kozitski.pufar.validation.validator.StringValidator;
import com.kozitski.pufar.validation.validator.Validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class ValidatorRegister {
    private static final String VALIDATORS_PATH = "validation/input/validator.properties";


    public static ArrayList<Validator> initValidators() {
        ArrayList<Validator> validators = new ArrayList<>();

        File file = new File(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource(VALIDATORS_PATH)).getFile());

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String validatorName = (String) properties.get("stringValidator");

//        System.out.println(validatorName);

        // FACTORY, каторая по имени возвращает класс

        validators.add(new StringValidator());

        return validators;
    }

}
