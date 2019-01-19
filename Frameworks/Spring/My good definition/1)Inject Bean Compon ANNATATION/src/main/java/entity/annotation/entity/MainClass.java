package entity.annotation.entity;

import entity.annotation.autoscan.Man;
import entity.annotation.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;
import java.util.HashMap;

public class MainClass {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        System.out.println(applicationContext.getBean("house"));

        System.out.println("\n-------------------------------\n");

        Man man = applicationContext.getBean("man", Man.class);
        System.out.println(man);

    }

}
