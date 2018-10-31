import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class start{
    public static void main(String[] args) throws Exception {
        int n = 1;
        int[] mass = new int[n];
        for(int i = 0; i < n; i++){
            mass[i] = i;
            System.out.println("проход № " + mass[i]);
            mass = new int[++n];
            /*try {
                Thread.sleep(50);
            }
            catch (Exception ex){}*/
        }
    }
}

