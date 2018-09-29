/**
 * Created by Андрей on 31.12.2017.
 */

import java.util.*;

public class start {
    public static void main(String[] args) {
        ArrayList<Dannie> list1 = new ArrayList<Dannie>();
        Scanner vvod = new Scanner(System.in);
        System.out.println("Введи длину списка");
        int len = vvod.nextInt();
        for (int i = 0; i < len; i++) {
            Dannie d = new Dannie();
            System.out.println("№" + (i + 1) + " Введи имя");
            d.setName(vvod.next());
            System.out.println("№" + (i + 1) + " Введи возраст");
            d.setAge(vvod.nextInt());
            list1.add(d);
        }

        ArrayList<Dannie> list2 = new ArrayList<Dannie>();
        System.out.println("Введи длину списка");
        len = vvod.nextInt();
        for (int i = 0; i < len; i++) {
            Dannie d = new Dannie();
            System.out.println("№" + (i + 1) + " Введи имя");
            d.setName(vvod.next());
            System.out.println("№" + (i + 1) + " Введи возраст");
            d.setAge(vvod.nextInt());
            list2.add(d);
        }

        for (int i = 0; i < list1.size(); i++) {
            System.out.println("Имя: " + list1.get(i).getName() + ", Возраст: " + list1.get(i).getAge());
        }
        System.out.println("//////////////////////////////////////////////////");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println("Имя: " + list2.get(i).getName() + ", Возраст: " + list2.get(i).getAge());
        }
        System.out.println("//////////////////////////////////////////////////");
        editList(list1, list2);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("Имя: " + list1.get(i).getName() + ", Возраст: " + list1.get(i).getAge());
        }
    }

    public static void editList(ArrayList<Dannie> lst1, ArrayList<Dannie> lst2){
        for(int i = 0; i < lst1.size(); i++){
            for(int j = 0; j < lst2.size(); i++ ){
                if(lst1.get(i).getName() == lst2.get(j).getName()){
                    lst1.get(i).setName("XxXxXxX");
                    lst1.get(i).setAge(666);
                }
            }
        }
    }
}
