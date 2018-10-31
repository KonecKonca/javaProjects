package main.books.impl.catalogs.dictonary;

import main.books.library.Dictionary;
import main.books.library.interfaces.country.English;

public class EnglishDictionary extends Dictionary implements English{
    public String forEnglishDictionary(){
        return "make for ---> EnglishDictionary";
    }
}
