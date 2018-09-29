package main.books.impl.magazines;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.books.library.abstractPrototypes.AbstractMagazine;
import main.books.library.interfaces.country.English;
import main.books.library.interfaces.matireal.Glossable;
import main.books.library.interfaces.priority.HighPrioritiable;


public class NewYorkCity extends AbstractMagazine implements English, Glossable, HighPrioritiable{
    @Override
    public String forMagazine() {
        return "released in ---> NewYorkCity";
    }
}
