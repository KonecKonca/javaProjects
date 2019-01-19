package config;

import aspects.AspectClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.entities.Common;
import test.entities.Plumber;
import test.entities.Xyiamber;

@Configuration
public class Config {

    @Bean
    public Plumber plumber() {
        Plumber plumber = new Plumber();
        plumber.setName("Andrei");
        return plumber;
    }

    @Bean
    public Xyiamber xyiamber() {
        return new Xyiamber();
    }

    @Bean
    public Common common() {
        return new Common();
    }

    @Bean(name = "advices")
    public AspectClass aspectClass() {
        return new AspectClass();
    }

}
