package main.books.library;

import main.books.library.abstractPrototypes.AbstractCatalog;

public class Dictionary extends AbstractCatalog {
    public String forDictionary(){
        return "make for ---> Dictionary";
    }

    @Override
    public String forCatalog() {
        return "Realeased in ---> Dictionary";
    }
}
