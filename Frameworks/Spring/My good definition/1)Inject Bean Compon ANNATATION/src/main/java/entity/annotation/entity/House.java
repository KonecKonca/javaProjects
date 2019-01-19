package entity.annotation.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

@Component
@Qualifier("home")
@Data
public class House {
    private ArmChear armChear;
    private Sofa sofa;

    @Autowired(required = false)  // есди не найдём то и фиг с ним
    @Qualifier("armChair")  // [аннотация для уточнения автосвязывания] указываем явный идентификатор
    public void setArmChear(ArmChear armChear) {
        this.armChear = armChear;
    }

    @Inject
    @Required
    public void setSofa(Sofa sofa) {
        this.sofa = sofa;
    }

    public void whatIsAtHouse() {
        System.out.println("1) " + armChear);
        System.out.println("2) " + sofa.toString());
    }

    @PostConstruct
    public void postConstuct() {
        System.out.println("ALL IS GOOD");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("DESTROY!!!!");
    }

}
