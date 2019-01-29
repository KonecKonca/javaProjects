package base.annotation.entity;

import base.annotation.autoscan.Man;
import base.annotation.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        System.out.println(applicationContext.getBean("house"));

        System.out.println("\n-------------------------------\n");

        Man man = applicationContext.getBean("man", Man.class);
        System.out.println(man);

    }

}
