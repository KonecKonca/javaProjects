package com.kozitski.task3.service;

import com.kozitski.task3.entity.Wagon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

    public static void main(String[] args) {

        List<Wagon> wagons = new ArrayList<>(Arrays.asList(new Wagon(), new Wagon(), new Wagon(), new Wagon(), new Wagon(), new Wagon(), new Wagon(), new Wagon(), new Wagon()));
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(Wagon wagon : wagons){
            executorService.submit(wagon);
        }

    }

}
