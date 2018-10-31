package main.books.impl.newspapers;

import main.books.library.abstractPrototypes.AbstractNewspaper;
import main.books.library.interfaces.country.Belarusian;
import main.books.library.interfaces.country.English;
import main.books.library.interfaces.priority.LowPrioritiable;

public class MyGarden extends AbstractNewspaper implements Belarusian, LowPrioritiable {
    @Override
    public String forNewspaper() {
        return "relised in ---> MyGarden";
    }

    public String forMyGarden(){
        return "make for ---> MyGarden";
    }
}
