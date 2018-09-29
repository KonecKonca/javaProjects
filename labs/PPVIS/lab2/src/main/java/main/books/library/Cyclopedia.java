package main.books.library;

import main.books.library.abstractPrototypes.AbstractCatalog;

public class Cyclopedia extends AbstractCatalog {

    public String forCyclopedia(){
        return "make for ---> Cyclopedia";
    }

    @Override
    public String forCatalog() {
        return "Realeased in ---> Cyclopedia";
    }
}
