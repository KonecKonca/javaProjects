import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class start{
    public static void main(String[] args) {
        NameClass nameClass = new NameClass();
        nameClass.n = new NameClass();
        nameClass.n.n = new NameClass();

        System.out.println(nameClass.n.n.a);
    }
}

class NameClass{
    public int a = 7;
    public NameClass n;
}