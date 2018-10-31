import java.util.*;

public class start {
    public static void main(String[] args) {
        simpleNums();
    }

    public static void simpleNums(){
        boolean cheaker = false;
        for(int i = 2; i < 100; i++){
            for(int j = 2; j < i; j++ ){
                if((i % j) == 0){
                    cheaker = true;
                    break;
                }
            }
            if(!cheaker){
                System.out.println(i);
            }
            cheaker = false;
        }
    }
}
