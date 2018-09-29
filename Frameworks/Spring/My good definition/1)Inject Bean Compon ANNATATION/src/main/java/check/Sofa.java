package check;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Sofa {
    private String color;
    private String model;

}
