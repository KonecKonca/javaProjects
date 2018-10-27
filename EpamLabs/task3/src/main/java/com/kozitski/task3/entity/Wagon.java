package com.kozitski.task3.entity;

import com.kozitski.task3.exception.LogisticBaseException;
import com.kozitski.task3.service.LogisticBaseActivity;
import com.kozitski.task3.util.generator.WagonIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class Wagon implements Callable<Integer>, Comparable<Wagon>{
    private static final Logger LOGGER = LogManager.getLogger(Wagon.class);
    private long wagonId = WagonIdGenerator.generateId();
    private List<Product> products;
    private LogisticBaseActivity activity;
    private LogisticBase base;

    private ReentrantLock lock = new ReentrantLock();

    private final int NUMBER_OF_TRIPS = 3;
    private int numberOfDoneTrips;
    private int numberOfTransportedProduct;

    public Wagon() {
        try {
            base = LogisticBase.getInstance();
        } catch (LogisticBaseException e) {
            LOGGER.fatal("Base creating error", e);
            throw new RuntimeException("Base creating error", e);
        }
    }

    @Override
    public Integer call() throws Exception {

        while (numberOfDoneTrips < NUMBER_OF_TRIPS){
            numberOfTransportedProduct += activity.activity(this);
            changeActivity();
        }

        return numberOfTransportedProduct;
    }



    public void doActivity() throws LogisticBaseException {
        activity.activity(this);
    }
    private void changeActivity(){

    }

    public void notifyLock(){
        lock.notify();
    }

    @Override
    public int compareTo(Wagon o) {
        int counterOfPerishable1 = 0;
        int counterOfPerishable2 = 0;

        for(Product product : products){
            if(product.getType().getRate() == 1){
                counterOfPerishable1++;
            }
        }

        for(Product product : ((Wagon) o).products){
            if(product.getType().getRate() == 1){
                counterOfPerishable2++;
            }
        }

        return counterOfPerishable2 - counterOfPerishable1;
    }
    public void setActivity(LogisticBaseActivity activity) {
        this.activity = activity;
    }

    public boolean add(Product product) {
        return this.products.add(product);
    }
    public Product getProduct(int index) {
        return products.get(index);
    }
    public boolean remove(Product o) {
        return products.remove(o);
    }
    public boolean removeAll(Collection<? extends Product> c) {
        return products.removeAll(c);
    }
    public void setBase(LogisticBase base) {
        this.base = base;
    }
    public LogisticBase getBase() {
        return base;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Wagon : id-");
        stringBuilder.append(wagonId);
        stringBuilder.append(", ");
        stringBuilder.append(products);
        stringBuilder.append(", Activity- ");
        stringBuilder.append(activity);

        return stringBuilder.toString();
    }

}
