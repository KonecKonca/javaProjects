import java.util.Objects;
import java.util.TreeSet;

public class Help implements Cloneable{  //маркерный интерфейс (без него не сработает)
    public int i;
    public New newNew = new New();

    /*@Override
    protected Help clone() throws CloneNotSupportedException {
        return (Help) super.clone();
    } */  // Поверхностное клонирование


    @Override
    protected Help clone() throws CloneNotSupportedException {
        Help help = (Help) super.clone();
        help.newNew = newNew.clone();
        return help;
    } // Дефолтовый нужно переписать для полного клонирования

}

class  New implements Cloneable{  // без этого будет поверхностное клонирование
    int j;

    @Override
    protected New clone() throws CloneNotSupportedException {
        return (New) super.clone();
    }
}