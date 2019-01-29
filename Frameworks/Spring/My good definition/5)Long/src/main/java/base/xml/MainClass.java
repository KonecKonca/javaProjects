package base.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass{
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        CarFactory carFactory = applicationContext.getBean("carFactory", CarFactory.class);
        Car car1 = (Car) carFactory.createCar();
        Car car2 = applicationContext.getBean("car2", Car.class);

        car1.carMethod();
        System.out.println(car1);
        System.out.println(car2);

    }
}
