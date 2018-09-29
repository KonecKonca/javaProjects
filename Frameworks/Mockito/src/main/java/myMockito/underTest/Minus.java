package myMockito.underTest;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Minus {
    private String name;
    private String age;

    public void doSofa(){
        System.out.println("It is Sofa");
    }
}
