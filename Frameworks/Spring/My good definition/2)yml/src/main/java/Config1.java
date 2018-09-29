import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableConfigurationProperties
//@ConfigurationProperties(prefix = "entity")
public class Config1 {

//    @Value("${entity.name}")
    private String name;
//    @Value("${entity.age}")
    private String age;
//    @Value("${entity.lastName}")
    private String lastName;

    @Bean
    public Entity entity(){
        System.out.println("\n---------------------------\n");
        System.out.println(name);
        System.out.println("\n---------------------------\n");
//        return Entity.builder().age(age).lastName(lastName).name(name).build();
        return new Entity(name, lastName, age);
    }

}
