import jdk.nashorn.internal.ir.WhileNode;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Scanner;

public class failWork {
    private Formatter file;
    public void sozdanie(){
        try{
            file = new Formatter("d:\\джава проекты\\основы\\основы синтаксиса\\работа с файлами\\text.txt");
            System.out.println("Файл создан");
        }
        catch (Exception ex){
            System.out.println("Произошла ошибка");
        }
    }
    public void addInfo(){
        Scanner vvod = new Scanner(System.in);
        System.out.println("Введите кол-во персонажей");
        int kol;
        kol = vvod.nextInt();
        for(int i = 0; i < kol; i++) {
            System.out.println("Введите имя персонажа № " + (i+1));
            file.format("%d)\t%s\n", (i + 1), vvod.next());
        }
    }
    public void closeFail(){
        file.close();
    }

    private Scanner reader;
    public void readInfo(){
        try{
            reader = new Scanner(new File("d:\\джава проекты\\основы\\основы синтаксиса\\работа с файлами\\text.txt"));
        }
        catch (Exception e){
            System.out.println("Произошла ошибка");
        }
        String nomber;
        String name;
        while (reader.hasNext()){
                nomber = reader.next();
                name = reader.next();
            System.out.printf("%s\t%s\n",nomber, name);
        }
        reader.close();
    }
}
