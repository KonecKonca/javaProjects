package com.kozitski.task3.service;

import com.kozitski.task3.exception.LogisticBaseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class WagonActivity {
    private static final Logger LOGGER = LogManager.getLogger(WagonActivity.class);
    private static final int DURING_OF_TRIP_TIME = 10;
    private static final int NUMBER_OF_GET_GIVE_PRODUCTS = 20;

private static final LogisticBaseActivity DURING_TRIP = wagon -> {
    try {

        TimeUnit.SECONDS.sleep(DURING_OF_TRIP_TIME);
        System.out.println(wagon.toString());

    } catch (InterruptedException e) {
        LOGGER.error("Error int period of wagon TRIP", e);
        throw new LogisticBaseException("Error int period of wagon TRIP", e);
    }

    return 0;
};

private static final LogisticBaseActivity GET_PRODUCTS = wagon -> {
//    wagon.add(wagon.getBase());

    return 0;
};

private static final LogisticBaseActivity GIVE_PRODUCTS = wagon -> {

    return 0;
};


}
