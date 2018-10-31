import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 23; i+=3){
            list.add(i);
        }

        /// НИже элемент функционального стиля
        list.forEach(System.out::print);
    }
}
