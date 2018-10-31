import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
//@ComponentScan("java")
public class MainClass {
    public static void main(String[] args) {
//        SpringApplication.run(MainClass.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);
        Entity entity = (Entity)context.getBean("entity");
        System.out.println("@@@@");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n---------------------------\n");
        System.out.println(entity);
        System.out.println("\n---------------------------\n");
    }
}
