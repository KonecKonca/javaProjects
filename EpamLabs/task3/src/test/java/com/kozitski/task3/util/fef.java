package com.kozitski.task3.util;

import com.kozitski.task3.entity.Product;
import com.kozitski.task3.entity.Wagon;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class fef {

    @Test
    public void test() throws Exception {
        for(int i = 0; i < 10; i++){
            Callable<Integer> callable = new Wagon();
            FutureTask<Integer> futureTask = new FutureTask<>(callable);

            new Thread(futureTask).start();

        }

        Thread.sleep(10000);



    }


//                System.out.println(new Wagon());
//            System.out.println(new Product("erfegfe", new BigDecimal(242)));





}
