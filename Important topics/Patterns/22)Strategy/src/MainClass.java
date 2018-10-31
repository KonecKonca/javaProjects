import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        double startPrice = 120;
        Context context = new Context(new HalfPrice());

        double price1 = context.getPrice(startPrice);
        context = new Context(new FullPrice());
        double price2 = context.getPrice(startPrice);

        System.out.println(price1 + "\t" + price2);
    }
}

interface Strategy{
    double getPrice(double price);
}
class FullPrice implements Strategy{
    @Override
    public double getPrice(double price) {
        return price;
    }
}
class HalfPrice implements Strategy{
    @Override
    public double getPrice(double price) {
        return price*0.5;
    }
}

class Context{
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(double price){
        return strategy.getPrice(price);
    }
}


