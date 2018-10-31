package test.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
public class Plumber {
    private String name;

    public void work(){
        System.out.println("Я чиню трубу " + name);
    }

    public void troubls(){
        System.out.println("\nЯ не могу починить");
        throw new RuntimeException();
    }
}
