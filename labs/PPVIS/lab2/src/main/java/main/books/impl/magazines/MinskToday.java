package main.books.impl.magazines;

import main.books.library.abstractPrototypes.AbstractMagazine;
import main.books.library.interfaces.country.Belarusian;
import main.books.library.interfaces.priority.LowPrioritiable;

public class MinskToday  extends AbstractMagazine implements Belarusian, LowPrioritiable{
    @Override
    public String forMagazine() {
        return "released in ---> MinskToday";
    }

    public String forMinskToday() {
        return "make for ---> MinskToday";
    }
}
