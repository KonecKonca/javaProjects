package com.kozitski.task3.entity;

import com.kozitski.task3.exception.LogisticBaseException;
import com.kozitski.task3.service.wagonactivity.LogisticBaseActivity;
import com.kozitski.task3.util.generator.WagonIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Wagon implements Callable<Integer>, Comparable<Wagon>{
    private static final Logger LOGGER = LogManager.getLogger(Wagon.class);
    private long wagonId = WagonIdGenerator.generateId();
    private List<Product> products;
    private LogisticBaseActivity activity;
    private LogisticBase base;


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

        Thread.sleep(new Random().nextInt(1000));

        System.out.println("    " + wagonId + "    " + Thread.currentThread().getName());
        return 1;

    }

    @Override
    public int compareTo(Wagon o) {
        return o.products.get(0).getType().rate - products.get(0).getType().getRate();
    }

    public void doActivity(LogisticBase logisticBase){
        activity.activity(logisticBase);
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
    public boolean remove(Object o) {
        return products.remove(o);
    }
    public boolean removeAll(Collection<?> c) {
        return products.removeAll(c);
    }
    public void setBase(LogisticBase base) {
        this.base = base;
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
