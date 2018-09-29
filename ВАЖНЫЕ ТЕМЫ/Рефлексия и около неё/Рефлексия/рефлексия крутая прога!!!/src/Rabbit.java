import javafx.fxml.FXML;
import jdk.nashorn.internal.objects.annotations.Function;
import jdk.nashorn.internal.objects.annotations.Property;

public class Rabbit extends Object{

    @Deprecated
    private final String NAME = "Rabbit";

    @RabbitAnnotation
    @Deprecated
    private int age = 12;

    @RabbitAnnotation
    @SuppressWarnings(value = "ЭТА АННОТАЦИЯ РАБОТАЕТ ОНЛИ ВО ВРЕМЯ КОМПИЛЯЦИИ")  // не выведет, ибо рефлекшин онли в рантайме
    protected double weight = 4.54;

    public String getName() {
        return NAME;
    }
    public int getAge() {
        return age;
    }
    public double getWeight() {
        return weight;
    }

    public void anyMethod(){
        System.out.println("It is a Rabbit");
    }
}
