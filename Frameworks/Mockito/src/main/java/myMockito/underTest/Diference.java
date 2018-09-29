package myMockito.underTest;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Diference {
    private double a;
    private double b;

    public void doTable(){
        System.out.println("It is table");
    }

    public double diference(){
        return 43.0;
    }
}
