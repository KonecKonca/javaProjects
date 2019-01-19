package check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class House {
    private ArmChear armChear;
    private Sofa sofa;

    @Autowired
    public void setArmChear(ArmChear armChear) {
        this.armChear = armChear;
    }

    @Autowired
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
