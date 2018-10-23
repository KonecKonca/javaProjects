package com.kozitski.task3.util.validation;

import com.kozitski.task3.util.constants.PropertyPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

public class ProductValidator {
    private static final Logger LOGGER = LogManager.getLogger(ProductValidator.class);

    public boolean validate(String name, BigDecimal price){
        if(name == null || price == null){
            return false;
        }

        Properties properties = new Properties();

        try(FileInputStream inputStream = new FileInputStream(PropertyPath.PRODUCT_VALIDATION_PATH)){
            properties.load(inputStream);
        }
        catch (IOException e){
            LOGGER.error("Property file for product validation is not exist", e);
            return false;
        }

        int nameMinSize = Integer.parseInt(properties.getProperty("nameMinSize"));
        int nameMaxSize = Integer.parseInt(properties.getProperty("nameMaxSize"));

        double minPrice = Double.parseDouble(properties.getProperty("minPrice"));
        double maxPrice = Double.parseDouble(properties.getProperty("maxPrice"));

        name = name.trim();

        return name.length() >= nameMinSize && name.length() <= nameMaxSize && !name.isEmpty() &&
                price.doubleValue() >= minPrice && price.doubleValue() <= maxPrice;

    }

}
