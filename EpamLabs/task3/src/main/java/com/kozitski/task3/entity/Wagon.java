package com.kozitski.task3.entity;

import com.kozitski.task3.service.wagonactivity.LogisticBaseActivity;
import com.kozitski.task3.util.generator.WagonIdGenerator;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;

public class Wagon implements Callable<Integer>{
    private long wagonId = WagonIdGenerator.generateId();
    private List<Product> products;
    private LogisticBaseActivity activity;
    // seconds
    private int timeOfReturn;
    private int numOfFlight;

    public Wagon(int timeOfReturn, int numOfFlight) {
        this.timeOfReturn = timeOfReturn;
        this.numOfFlight = numOfFlight;
    }

    @Override
    public Integer call() throws Exception {

        for(int i = 0; i < numOfFlight; i++){




        }

    }

    public void setActivity(LogisticBaseActivity activity) {
        this.activity = activity;
    }

    public boolean add(Product product) {
        return this.products.add(product);
    }
    public Product get(int index) {
        return products.get(index);
    }
    public boolean remove(Object o) {
        return products.remove(o);
    }
    public boolean removeAll(Collection<?> c) {
        return products.removeAll(c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wagon)) return false;
        Wagon wagon = (Wagon) o;
        return Objects.equals(wagonId, wagon.wagonId);
    }
    @Override
    public int hashCode() {
        return (int) wagonId;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Wagon : ");
        stringBuilder.append(products);
        stringBuilder.append(", Activity: ");
        stringBuilder.append(activity);

        return stringBuilder.toString();
    }

}
