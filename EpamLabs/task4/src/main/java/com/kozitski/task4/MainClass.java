package com.kozitski.task4;

import com.kozitski.task4.validator.SchemeValidator;

public class MainClass {

    public static void main(String[] args) {

        validate();

    }

    public static void validate(){
        SchemeValidator.validate(SchemeValidator.XML_PATH, SchemeValidator.XSD_PATH);
    }

}
