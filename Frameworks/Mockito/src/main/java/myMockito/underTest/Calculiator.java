package myMockito.underTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculiator {
    private Plus plus;
    private Minus minus;
    private Diference diference;

    @Autowired
    public void setArmChear(Plus plus) {
        this.plus = plus;
    }
    @Autowired
    public void setSofa(Minus minus) {
        this.minus = minus;
    }
    @Autowired
    public void setTable(Diference diference) {
        this.diference = diference;
    }

    public void doHouse(){
        System.out.println("I am HOUSE and I include: \n\t" + plus + "\n\t" + minus + "\n\t" + diference);
    }

    public double diference(){

    }

}
