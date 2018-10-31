import java.util.*;

public class start {
    public static void main(String[] args) {
        uservvod();
    }

    public static void uservvod(){
        boolean cheaker = true;
        int length;

        while(cheaker){
            try {
                Scanner vvod = new Scanner(System.in);
                System.out.println("Введите размер массива");
                length = vvod.nextInt();
                cheaker = false;
            }
            catch (Exception ex){
                System.out.println("Ввод неверный, попробуй ещё раз");
            }
        }
    }
}
