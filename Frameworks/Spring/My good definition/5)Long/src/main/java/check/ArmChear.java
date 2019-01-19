package check;

import lombok.Data;
import org.springframework.context.annotation.Scope;

// ВЫКИНУЛИ В ДРУГОЙ ПАКЕТ ТДЛЯ ПРОВЕРКИ

@Scope("singleton")
@Data
public class ArmChear {
    private String type;
    private int age;

}
