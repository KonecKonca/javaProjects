package com.kozitski.task3.util;

import com.kozitski.task3.entity.LogisticBase;
import com.kozitski.task3.entity.Product;
import com.kozitski.task3.entity.Wagon;
import com.kozitski.task3.util.parameter.DataForBaseInitialization;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.Callable;
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
        PriorityQueue<TestElement> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new TestElement(2));
        priorityQueue.offer(new TestElement(22));
        priorityQueue.offer(new TestElement(92));
        priorityQueue.offer(new TestElement(1));
        priorityQueue.offer(new TestElement(0));

//        priorityQueue.addAll()

        while (true){
            TestElement testElement = priorityQueue.poll();
            if(testElement != null){
                System.out.println(testElement);
            }
            else {
                break;
            }
        }


    }


}

class TestElement implements Comparable<TestElement>{
    Integer value;
    public TestElement(Integer value) {
        this.value = value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public int compareTo(TestElement o) {
        return value - ((TestElement) o).value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestElement that = (TestElement) o;
        return Objects.equals(value, that.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TestElement{" +
                "value=" + value +
                '}';
    }

}
