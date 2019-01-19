package entity.annotation.autoscan;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("man")
@Data
public class Man {
    private String name;
    private String sourName;
    private int age;

    public void intitMethod() {
        System.out.println("    Man is initialised");
    }

}
