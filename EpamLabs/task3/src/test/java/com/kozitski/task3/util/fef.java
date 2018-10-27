package com.kozitski.task3.util;

import com.kozitski.task3.entity.LogisticBase;
import com.kozitski.task3.entity.Product;
import com.kozitski.task3.entity.Wagon;
import com.kozitski.task3.util.parameter.DataForBaseInitialization;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

public class fef {

    @Test
    public void test() throws Exception {
//        for(int i = 0; i < 10; i++){
//            Callable<Integer> callable = new Wagon();
//            FutureTask<Integer> futureTask = new FutureTask<>(callable);
//
//
//            new Thread(futureTask).start();
//            futureTask.get();
//
//        }


        LogisticBase base = LogisticBase.getInstance();
        System.out.println(base);


    }

    @Test
    public void t(){


    }


}
