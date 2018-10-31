package check;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// ВЫКИНУЛИ В ДРУГОЙ ПАКЕТ ТДЛЯ ПРОВЕРКИ

@Scope("singleton")
@Data
public class ArmChear{
    private String type;
    private int age;

}
