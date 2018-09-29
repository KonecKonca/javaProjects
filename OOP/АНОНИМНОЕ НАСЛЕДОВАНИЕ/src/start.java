import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class start{
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        System.out.println(list.getClass());

        List<String> list2 = new ArrayList<String>(){};  // тут у нас анонимка заэкстендженная от ArrayLista
        System.out.println(list2.getClass());

        List<Integer> list3 = new ArrayList<Integer>(){
            @Override
            public String toString() {
                return "Hello";
            }
        };
        System.out.println(list3);

    }
}
