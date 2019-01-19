package test;

import config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.entities.Common;

public class MainClass {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        Common common = applicationContext.getBean("common", Common.class);

        common.run();

    }
}
