package test.entities;

import aspects.WorkAspects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Common {
    private Plumber plumber;
    private Xyiamber xyiamber;

    @Autowired
    public void setPlumber(Plumber plumber) {
        this.plumber = plumber;
    }
    @Autowired
    public void setXyiamber(Xyiamber xyiamber) {
        this.xyiamber = xyiamber;
    }

    @WorkAspects
    public void run(){
        plumber.work();

        xyiamber.work();
    }
}
