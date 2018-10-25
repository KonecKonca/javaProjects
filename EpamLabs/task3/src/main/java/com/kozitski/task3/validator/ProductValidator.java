package com.kozitski.task3.validator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.kozitski.task3.util.parameter.ProductParameter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class ProductValidator {
    private static final Logger LOGGER = LogManager.getLogger(ProductValidator.class);
    private static final String PRODUCT_VALIDATION_PATH = "src/main/resources/data/validation/product.yml";

    public boolean validate(String name, BigDecimal price){
        if(name == null || price == null){
            return false;
        }

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        ProductParameter productParameter;
        try {

            productParameter = mapper.readValue(new File(PRODUCT_VALIDATION_PATH), ProductParameter.class);

        } catch (IOException e) {
            LOGGER.error("Property file for product validation is not exist", e);
            return false;
        }

        int nameMinSize = productParameter.getNameMinSize();
        int nameMaxSize = productParameter.getNameMaxSize();

        double minPrice = productParameter.getMinPrice();
        double maxPrice = productParameter.getMaxPrice();

        name = name.trim();

        return name.length() >= nameMinSize && name.length() <= nameMaxSize && !name.isEmpty() &&
                price.doubleValue() >= minPrice && price.doubleValue() <= maxPrice;

    }

}
