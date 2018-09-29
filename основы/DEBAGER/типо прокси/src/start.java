import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class start{
    private static final Logger log = Logger.getGlobal();

    public static void main(String[] args){

        // типо как прокси (можно добавить свой код)
        Random random = new Random(){
            @Override
            public double nextDouble() {
                Double d = super.nextDouble();
                System.out.println(d);
                return d;
            }
        };
        random.nextDouble();
    }

}
