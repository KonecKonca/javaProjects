package myMockito.underTest;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Plus {
    private String name;
    private String age;

    public void doArmChear(){
        System.out.println("It is Arm chear");
    }
}
