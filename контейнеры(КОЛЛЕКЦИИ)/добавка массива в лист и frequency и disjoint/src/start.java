     /**
 * Created by Андрей on 31.12.2017.
 */

import java.lang.reflect.Array;
import java.util.*;

public class start {
    public static void main(String[] args) {
        String[] planeti = {"Земля", "Марс", "Венера", "Сатурн"};
        List<String> planetList1 = Arrays.asList(planeti);

        ArrayList<String> planetList2 = new ArrayList<String>();
        planetList2.add("Уран");
        planetList2.add("Меркурий");
        planetList2.add("Юпитер");
        planetList2.add("нептун");

        for(String str : planetList2){
            System.out.print(str + "\t");
        }
        System.out.println();

        Collections.addAll(planetList2, planeti); // добавить в 1-ую коллекцию 2-ой массив

        for(String str : planetList2){
            System.out.print(str + "\t");
        }
        System.out.println();

        System.out.println(Collections.frequency(planetList2, "Земля")); // поиск кол-ва Земель
        boolean check = Collections.disjoint(planetList1, planetList2);  // false если есть хоть 1 одинак элемент
        if(check) {
           System.out.println("У списков нет ничего общего");
        }
        else{
           System.out.println("Есть общий элемент");
        }

        System.out.println("Отсорированный лист2");
        Collections.sort(planetList2);
        for(String str : planetList2){
            System.out.print(str + "\t");
        }
        System.out.println();

        System.out.println("Похеренный лист2");
        Collections.shuffle(planetList2); // антисортировка
        for(String str : planetList2){
            System.out.print(str + "\t");
        }
        System.out.println();
    }
}
