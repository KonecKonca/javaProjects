package my;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Main class is created");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("exam-config.xml");

        System.out.println("\nFirst Object\n");
        TestClass testClass1 = (TestClass) applicationContext.getBean("test");
        testClass1.getInjectingClass().setAge("666");
        testClass1.test();

        System.out.println("\nSecond Object\n");
        TestClass testClass2 = (TestClass) applicationContext.getBean("test");
        testClass2.getInjectingClass().setName("Vasia");
        testClass2.test();

        System.out.println("\nChild Object\n");
        TestChild testChild = (TestChild) applicationContext.getBean("childTest");
        testChild.test();

    }
}
