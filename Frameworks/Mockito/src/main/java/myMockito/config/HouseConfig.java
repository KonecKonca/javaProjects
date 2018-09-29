package myMockito.config;

import myMockito.underTest.Plus;
import myMockito.underTest.Calculiator;
import myMockito.underTest.Minus;
import myMockito.underTest.Diference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HouseConfig {

    @Bean
    public Plus armChear(){
        Plus armChear = new Plus();
        armChear.setAge("66");
        armChear.setName("Styl");
        return armChear;
    }

    @Bean
    public Diference table(){
        Diference table = new Diference();
        table.setAge("1");
        table.setName("Stol");
        return table;
    }

    @Bean
    public Minus sofa(){
        Minus sofa = new Minus();
        sofa.setAge("33");
        sofa.setName("Divan");
        return sofa;
    }

    @Bean
    public Calculiator house(){
        return new Calculiator();
    }
}
