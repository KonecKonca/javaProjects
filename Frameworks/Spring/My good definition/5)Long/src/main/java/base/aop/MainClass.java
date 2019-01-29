package base.aop;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TimeTestClass timeTestClass = context.getBean("testClass", TimeTestClass.class);

        timeTestClass.underAopAround();

    }

}
