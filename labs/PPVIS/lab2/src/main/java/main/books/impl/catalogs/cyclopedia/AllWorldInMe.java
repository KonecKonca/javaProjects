package main.books.impl.catalogs.cyclopedia;

import main.books.library.Cyclopedia;
import main.books.library.interfaces.priority.MidlePrioritiable;

public class AllWorldInMe extends Cyclopedia implements MidlePrioritiable{
    public String forAllWorldInMe(){
        return "make for ---> AllWorldInMe";
    }
}
