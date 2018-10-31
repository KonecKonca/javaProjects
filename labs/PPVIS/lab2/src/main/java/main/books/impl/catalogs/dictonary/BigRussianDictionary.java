package main.books.impl.catalogs.dictonary;

import main.books.library.Dictionary;
import main.books.library.interfaces.priority.MidlePrioritiable;

public class BigRussianDictionary extends Dictionary implements MidlePrioritiable{
    public String forBigRussianDictionary(){
        return "make for ---> BigRussianDictionary";
    }
}
