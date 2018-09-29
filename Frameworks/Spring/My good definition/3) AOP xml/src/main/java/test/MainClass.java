package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class MainClass {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aspects.xml");
        Plumber plumber = (Plumber) applicationContext.getBean("plumber");
//
//        plumber.work();
//
//        System.out.println("\n----------------\n");

        plumber.work();
        try {
            plumber.troubls();
        }
        catch (Exception e){}

        Plumber plumber1 = new Plumber();
        System.out.println("\n-----------------\n");
        System.out.println("НЕ SPRING БИН !!!");
        plumber1.work();

    }
}
