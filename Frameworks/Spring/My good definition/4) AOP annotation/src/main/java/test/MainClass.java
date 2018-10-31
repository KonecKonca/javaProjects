package test;

import config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import test.entities.Common;
import test.entities.Plumber;
import test.entities.Xyiamber;

public class MainClass {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        Common common = (Common) applicationContext.getBean("common");
        common.run();

    }
}
