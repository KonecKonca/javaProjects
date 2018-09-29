package myMockito;

import myMockito.config.HouseConfig;
import myMockito.underTest.Calculiator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HouseConfig.class);

        Calculiator house = (Calculiator) context.getBean("house");
        house.doHouse();
    }
}
