package entity.annotation.config;

import entity.aop.TimeTestClass;
import entity.annotation.autoscan.Man;
import entity.annotation.entity.ArmChear;
import entity.annotation.entity.House;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import entity.annotation.entity.Sofa;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

    @Bean
    public ArmChear armChear(){
        System.out.println("armchear is create");
        ArmChear armChear = new ArmChear();
        armChear.setAge(35);
        armChear.setType("Xyiovi");

        return armChear;
    }
    @Bean
    public Sofa sofa(){
        System.out.println("sofa is create");
        Sofa sofa = new Sofa();
        sofa.setColor("Red");
        sofa.setModel("xXxXxX");

        return sofa;
    }
    @Bean
    public House house(){  // ИМЕНА БИНО БЕРУТСЯ СТРОГО ИЗ НАЗВАНИЙ МЕТОДОВ В КЛАССЕ КОНФИГА
        System.out.println("house is creating");   // либо так @Bean("...")  НО ТОЖЕ В КЛАССЕ КОНФИГА

        return new House();
    }

    // for autoScan
    @Bean(initMethod = "intitMethod")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Man man(){
        System.out.println("Man is creating");

        Man man = new Man();
        man.setAge(32);
        man.setName("Andrei");
        man.setSourName("Kozitski");

        return man;
    }


}
