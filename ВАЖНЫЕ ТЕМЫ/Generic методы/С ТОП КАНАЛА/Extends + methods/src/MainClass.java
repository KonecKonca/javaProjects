import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MainClass {
    public static void main(String[] args) {
        Cell<String> cell = new Cell<>(new Integer(4));
        System.out.println(cell.getE(new Object()));
        System.out.println(cell.<Object>getE(new Object()));
    }
}

class Cell<T>{
    T t;
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
    public Cell(){}

    // generic method  (тупо передаёшь что хочешь)
    public <E> E getE(E e){
        return e;
    }
    // genetic constructoy
    public <E> Cell(E e) {
        System.out.println(e);
    }
}


// дженирик онли на уровне компиляции,
// при наследовании идут только наужесточение
class Parent{}
class GenParent<T> extends Parent{}

class Child1 extends GenParent{}
//class Child2 extends GenParent<T>{}
class Child2 extends GenParent<String>{}

//class Child03<X, Y> extends GenParent<T>{}
class Child3<X, T, Y> extends GenParent<T>{}
class Child4<T, X, Y> extends GenParent{}



