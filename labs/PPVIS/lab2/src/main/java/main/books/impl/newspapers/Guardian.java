package main.books.impl.newspapers;

import main.books.library.abstractPrototypes.AbstractNewspaper;
import main.books.library.interfaces.country.English;
import main.books.library.interfaces.priority.HighPrioritiable;

public class Guardian extends AbstractNewspaper implements English, HighPrioritiable{
    @Override
    public String forNewspaper() {
        return "relised in ---> Guardian";
    }

    public String forGuardian(){
        return "make for ---> Guardian";
    }
}
