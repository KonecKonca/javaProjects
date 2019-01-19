package entity.annotation.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

@Scope("singleton")
@Qualifier("armChair")
@Data
public class ArmChear{
    private String type;
    private int age;

}
