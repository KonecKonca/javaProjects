import useMnojestvo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner vvod = new Scanner(System.in);
        Mnojestvo mn1 = new Mnojestvo();
        Mnojestvo mn2 = new Mnojestvo();
        int length1 = 0;
        int length2 = 0;

        System.out.println("Введите кол-во элементов 1-го множества");
        try {
            length1 = vvod.nextInt();
        } catch (Exception ex){
            System.out.println("Ввод не верный");
        }

        System.out.println("Введите кол-во элементов 2-го множества");
        try {
            length2 = vvod.nextInt();
        } catch (Exception ex) {
            System.out.println("Ввод не верный");
        }

        System.out.println("Введите элементы 1-го множества(они не должны повторяться)");
        for(int i = 0; i < length1; i++){
            mn1.add(vvod.nextInt());
        }
        Mnojestvo mnn = mn1.cheakcomplience();
        mn1 = mnn;
        System.out.println("Введите элементы 2-го множества(они не должны повторяться)");
        for(int i = 0; i < length2; i++){
            mn2.add(vvod.nextInt());
        }
        Mnojestvo mnojestvo = mn2.cheakcomplience();
        mn2 = mnojestvo;

        System.out.print("Ваши множества: \n" + "1-ое: ");
        mn1.show();
        System.out.print("2-ое: ");
        mn2.show();
    }

    public static void ODM(){
        Mnojestvo mn1 = new Mnojestvo();
        for(int i = 4; i< 20; i++){  // 4 - 10
            mn1.add(i);
        }

        Mnojestvo mn2 = new Mnojestvo();
        for(int i = 5; i < 30; i++){   // 5 - 12
            mn2.add(i);
        }

        System.out.println("1 - oe множество");
        mn1.show();
        System.out.println("2 - oe множество");
        mn2.show();

        System.out.println("Разность для 1-го множества");
        Mnojestvo mnRaznost1 = mn1.raznost(mn2);
        mnRaznost1.show();
        System.out.println("Разность для 2-го множества");
        Mnojestvo mnRaznost2 = mn2.raznost(mn1);
        mnRaznost2.show();

        System.out.println("Объединение 1-го множества(сумма)");
        Mnojestvo mnObjed1 = mn1.objedinenie(mn2);
        mnObjed1.show();
        System.out.println("Объединение 2-го множества(сумма)");
        Mnojestvo mnObjed2 = mn2.objedinenie(mn1);
        mnObjed2.show();

        System.out.println("Пересечение множеств");
        Mnojestvo mnPeresech = mn1.searchOdinakov(mn1, mn2);
        mnPeresech.show();

        System.out.println("Симметричная разность");
        Mnojestvo mnSimmetrRaznost = mn1.simmetrichajaRaznost(mn2);
        mnSimmetrRaznost.show();

        /*System.out.println("Декартово произведение множеств 1 и 2");
        ArrayList<Mnojestvo> arrayPodmn = new ArrayList<>();
        mn1.decartmnojestvo(arrayPodmn, mn2);
        Mnojestvo.showArray(arrayPodmn);

        Mnojestvo Nadmnoj1 = new Mnojestvo();
        for(int i = 0 ; i < mn1.getArraylenth(); i++){
            Nadmnoj1.add(mn1.getArrayEl(i));
        }
        for(int i = 10; i < 15; i++){
            Nadmnoj1.add(i);
        }
        System.out.println("Надмножество 1-го множества");
        Nadmnoj1.show();
        System.out.println("Дополнение 1-го множества");
        Mnojestvo dopoln1 = mn1.dopolnenie(Nadmnoj1);
        dopoln1.show();*/

        /*System.out.println("Булеан множеств");
        ArrayList<Mnojestvo> arrayBolean = new ArrayList<>();
        mn1.booleanMnojestva(arrayBolean);*/
    }
}