package config;

import check.ArmChear;
import check.House;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import check.Sofa;

@Configuration
public class ApplicationConfig {

    @Bean
    public ArmChear getArmChear(){
        System.out.println("armchear is create");
        ArmChear armChear = new ArmChear();
        armChear.setAge(35);
        armChear.setType("Xyiovi");
        return armChear;
    }
    @Bean
    public Sofa getSofa(){
        System.out.println("sofa is create");
        Sofa sofa = new Sofa();
        sofa.setColor("Red");
        sofa.setModel("xXxXxX");
        return sofa;
    }
    @Bean
    public House house(){  // ИМЕНА БИНО БЕРУТСЯ СТРОГО ИЗ НАЗВАНИЙ МЕТОДОВ В КЛАССЕ КОНФИГА
        System.out.println("house is create");   // либо так @Bean("...")  НО ТОЖЕ В КЛАССЕ КОНФИГА
        return new House();
    }
}
