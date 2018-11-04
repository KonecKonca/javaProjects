package com.kozitski.task3.util;

import com.kozitski.task3.entity.LogisticBase;
import com.kozitski.task3.entity.Product;
import com.kozitski.task3.entity.Wagon;
import com.kozitski.task3.util.parameter.DataForBaseInitialization;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class fef {

    @Test
    public void test() throws Exception {

        LogisticBase base = LogisticBase.getInstance();
        System.out.println(base);

    }

    @Test
    public void t() throws ExecutionException, InterruptedException {


        ExecutorService service = Executors.newFixedThreadPool(7);
        Future<Integer> result1 = service.submit(new Wagon());
        Future<Integer> result2 = service.submit(new Wagon());
        Future<Integer> result3 = service.submit(new Wagon());
        Future<Integer> result4 = service.submit(new Wagon());
        Future<Integer> result5 = service.submit(new Wagon());
        Future<Integer> result6 = service.submit(new Wagon());
        Future<Integer> result7 = service.submit(new Wagon());



        TimeUnit.SECONDS.sleep(40);

        System.out.println("Were exploied  " + result1.get());
        System.out.println("Were exploied  " + result2.get());
        System.out.println("Were exploied  " + result3.get());
        System.out.println("Were exploied  " + result4.get());
        System.out.println("Were exploied  " + result5.get());
        System.out.println("Were exploied  " + result6.get());
        System.out.println("Were exploied  " + result7.get());

    }


}
