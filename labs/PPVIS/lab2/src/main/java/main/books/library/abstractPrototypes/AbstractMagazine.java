package main.books.library.abstractPrototypes;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public abstract class AbstractMagazine extends AbstractBook{
    @Override
    public String usingOfBook() {
        return "Released in  ----> AbstractMagazine";
    }

    public abstract String forMagazine();
}
