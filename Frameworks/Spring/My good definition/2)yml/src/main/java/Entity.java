import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Data
@Getter
@Setter
//@NoArgsConstructor
@Builder
@ConfigurationProperties("entity")
public class Entity {

    private String name;
    private String lastName;
    private String age;

    public Entity(String name, String lastName, String age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
