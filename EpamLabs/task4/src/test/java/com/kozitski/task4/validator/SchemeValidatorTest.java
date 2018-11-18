package com.kozitski.task4.validator;

import org.testng.annotations.Test;


import java.io.File;
import java.util.Objects;

import static com.kozitski.task4.validator.SchemeValidator.XML_PATH;
import static com.kozitski.task4.validator.SchemeValidator.XSD_PATH;
import static org.testng.Assert.*;

public class SchemeValidatorTest {
    private static final String INCORRECT_XML_PATH = "data/incorrect.xml";
    private static final String CORRECT_XML_PATH = "data/correct.xml";
    private static final String DATA_FOR_FILE_NOT_FOUND = "data/incorrect.xml!!!";

    @Test
    public void testValidateTrue() {

        boolean actual = true;
        boolean expected = SchemeValidator.validate(CORRECT_XML_PATH, XSD_PATH);
        assertEquals(actual, expected);
    }

    @Test
    public void testValidateFalse() {
        boolean actual = true;
        boolean expected = SchemeValidator.validate(INCORRECT_XML_PATH, XSD_PATH);

        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testValidateFileNotFound() {
        SchemeValidator.validate(DATA_FOR_FILE_NOT_FOUND , XSD_PATH);
    }

}