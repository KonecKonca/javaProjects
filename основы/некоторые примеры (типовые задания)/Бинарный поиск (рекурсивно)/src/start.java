import java.util.Arrays;
import java.util.Collections;

public class start {
    public static void main(String[] args) {
        int[] mass = {1,2,3,4,7,90,676,1000};
        for(int i = mass.length -1  ; i >= 0; i--){
            System.out.println("индекс = " + binarnik(mass,mass[i],0, mass.length) + "; values = " + mass[i]);
        }
        System.out.println("\n");

        for(int i = 0 ; i < 59; i+=7){
            System.out.println("индекс = " + binarnik(mass,i,0, mass.length) + "; values = " + i);
        }

    }

    public static int binarnik(int[] mass, int value, int start, int end){
        int center = (start + end)/2;
        if(mass[center] == value){
            return center;
        }
        if((end - start) <= 0){
            return -(center + 1);
        }
        if(mass[center] < value){
            return binarnik(mass, value, center + 1, end);
        }
        if(mass[center] > value){
            return binarnik(mass, value, start, center - 1);
        }

        return -1;
    }

}
