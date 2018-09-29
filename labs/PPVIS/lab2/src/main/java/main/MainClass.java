package main;

import main.books.impl.catalogs.cyclopedia.AllWorldInMe;
import main.books.impl.catalogs.dictonary.BigRussianDictionary;
import main.books.impl.catalogs.dictonary.EnglishDictionary;
import main.books.impl.magazines.MinskToday;
import main.books.impl.magazines.NewYorkCity;
import main.books.impl.newspapers.Guardian;
import main.books.impl.newspapers.MyGarden;
import main.books.library.Cyclopedia;
import main.books.library.Dictionary;
import main.books.library.abstractPrototypes.AbstractBook;
import main.books.library.abstractPrototypes.AbstractMagazine;
import main.books.library.abstractPrototypes.AbstractNewspaper;
import main.books.library.interfaces.country.Belarusian;
import main.books.library.interfaces.country.English;
import main.books.library.interfaces.priority.HighPrioritiable;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        TestCLass testCLass = new TestCLass();
        testCLass.test();


    }
}

class TestCLass{
    private List<AbstractBook> list = new ArrayList<>();

    private void add(){
        AbstractMagazine newYorkCity = new NewYorkCity();
            newYorkCity.setName("newYorkCity");
            newYorkCity.setAutor("-------");
            newYorkCity.setNobmerOfPages(40);
            newYorkCity.setPublishes("xArt");
            newYorkCity.setPrice("14$");
        AbstractMagazine minskToday = new MinskToday();
            minskToday.setName("minskToday");
            minskToday.setAutor("Vasia pypkin");
            minskToday.setNobmerOfPages(20);
            minskToday.setPublishes("Aversev");
            minskToday.setPrice("2р");

        AbstractNewspaper guardian = new Guardian();
            guardian.setName("guardian");
            guardian.setAutor("Mr. Jakson");
            guardian.setNobmerOfPages(25);
            guardian.setPublishes("English Print");
            guardian.setPrice("6$");
        AbstractNewspaper myGarden = new MyGarden();
            myGarden.setName("myGarden");
            myGarden.setAutor("Baba Zina");
            myGarden.setNobmerOfPages(34);
            myGarden.setPublishes("Kolhoz Ivanovo");
            myGarden.setPrice("50 коп");

        Dictionary bigRussianDictionary = new BigRussianDictionary();
            bigRussianDictionary.setName("bigRussianDictionary");
            bigRussianDictionary.setAutor("Institut Filologii");
            bigRussianDictionary.setNobmerOfPages(1097);
            bigRussianDictionary.setPublishes("Print House");
            bigRussianDictionary.setPrice("50р");
        Dictionary englishDictionary = new EnglishDictionary();
            englishDictionary.setName("englishDictionary");
            englishDictionary.setAutor("Institut Filologii");
            englishDictionary.setNobmerOfPages(797);
            englishDictionary.setPublishes("Print House");
            englishDictionary.setPrice("45р");

        Cyclopedia allWorldInMe = new AllWorldInMe();
            allWorldInMe.setName("allWorldInMe");
            allWorldInMe.setAutor("I. Isachenko, V. Petrichenko");
            allWorldInMe.setNobmerOfPages(940);
            allWorldInMe.setPublishes("Print Art");
            allWorldInMe.setPrice("95р");

        list.add(newYorkCity);
        list.add(minskToday);
        list.add(guardian);
        list.add(myGarden);
        list.add(bigRussianDictionary);
        list.add(englishDictionary);
        list.add(allWorldInMe);

    }
    private void input(Functional functional){
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        functional.function(list);
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
    }
    private void fasad(){

        System.out.println("List of all objects: ");
        input(list ->{
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }
        });

        System.out.println("List of all HighPrioritiable: ");
        input(list ->{
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) instanceof HighPrioritiable){
                    System.out.println(list.get(i));
                }
            }
        });

        System.out.println("List of all Magazines: ");
        input(list ->{
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) instanceof AbstractMagazine){
                    AbstractMagazine abstractMagazine = (AbstractMagazine) list.get(i);
                    System.out.println(abstractMagazine.getName() + ": " + abstractMagazine.forMagazine() + ",  " + abstractMagazine.usingOfBook());
                }
            }
        });

        System.out.println("List of all Belarusin: ");
        input(list ->{
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) instanceof Belarusian){
                    Belarusian belarusian = (Belarusian) list.get(i);
                    System.out.println(belarusian.belarusian());
                }
            }
        });

        System.out.println("List of all English NewsPaper (English and Newspaper) : ");
        input(list ->{
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) instanceof English && list.get(i) instanceof AbstractNewspaper){
                    AbstractNewspaper abstractNewspaper = (AbstractNewspaper)list.get(i);
                    System.out.println(abstractNewspaper.getName() + ":  " + abstractNewspaper.forNewspaper() + " \n" +  abstractNewspaper + "\n" + abstractNewspaper.getClass());
                }
            }
        });

    }


    public void test(){
        add();
        fasad();
    }
}

interface Functional{
    void function(List<AbstractBook> list);
}

