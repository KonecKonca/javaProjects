package com.kozitski.task3.entity;

import com.kozitski.task3.exception.LogisticBaseException;
import com.kozitski.task3.util.parameter.DataForBaseInitialization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LogisticBase{
    private static final Logger LOGGER = LogManager.getLogger(LogisticBase.class);
    private static final int INITIAL_CAPACITY = 1000;
    private static final int BASE_CAPACITY = 5;
    private static AtomicInteger currentCapasity = new AtomicInteger(0);

    private static LogisticBase base;
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean isCreate = new AtomicBoolean(false);
    private Semaphore terminal = new Semaphore(3);

    private Queue<Wagon> wagons;  // offer/poll
    private ArrayDeque<Product> products;  // push/pollLast

    private LogisticBase() throws LogisticBaseException {
        wagons = new PriorityQueue<>();
        products = new ArrayDeque<>();

        init();
    }
    private void init() throws LogisticBaseException {
        try {
            DataForBaseInitialization initialization = DataForBaseInitialization.getInstance();
            for (int i = 0; i < INITIAL_CAPACITY; i++) {
                products.add(initialization.createProduct());
            }

        } catch (IOException e) {
            LOGGER.fatal("Base was not filed by products", e);
            throw new LogisticBaseException("Base was not filed by products", e);
        }
    }
    public static LogisticBase getInstance() throws LogisticBaseException {
        if(!isCreate.get()){
            try {
                lock.lock();
                if(base == null){
                    base = new LogisticBase();
                    isCreate.set(true);
                }
            }
            finally {
                lock.unlock();
            }
        }
        return base;
    }

    public boolean offer(Wagon wagon) {

        try {
            lock.lock();

            if(currentCapasity.get() >= BASE_CAPACITY){
                return false;
            }
            else {
                currentCapasity.incrementAndGet();
                return wagons.offer(wagon);
            }
        }
        finally {
            lock.unlock();
        }

    }

    // change
    public void getProduct(){

        try {
            terminal.acquire();
            Wagon currentWagon = wagons.poll();
            for (int i = 0; i < currentWagon.getProductsSize(); i++) {
                products.push(currentWagon.getProduct(i));
            }

            TimeUnit.SECONDS.sleep(2);

        }
        catch (InterruptedException e) {
            LOGGER.error("Problems with terminal", e);
        } finally {
            terminal.release();
            currentCapasity.decrementAndGet();
        }

    }
    public int giveProduct(){

        try {
            terminal.acquire();
            int number = 0;
            Wagon currentWagon = wagons.poll();
            for (int i = 0; i < Wagon.NUMBER_OF_GET_GIVE_PRODUCTS &&  products.size() > 0; i++) {
                currentWagon.add(products.pollLast());
                number = i;
            }

            TimeUnit.SECONDS.sleep(2);
            return ++number;
        }
        catch (InterruptedException e) {
            LOGGER.error("Problems with terminal", e);
        } finally {
            terminal.release();
            currentCapasity.decrementAndGet();
        }

        return Wagon.NUMBER_OF_GET_GIVE_PRODUCTS;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Base contains next products: ");
        stringBuilder.append("\n");
        for(Product product : products){
            stringBuilder.append(product);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

}
