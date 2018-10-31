package main.books.library.abstractPrototypes;

public abstract class AbstractNewspaper extends AbstractBook {
    @Override
    public String usingOfBook() {
        return "Released in  ----> AbstractCatalog";
    }

    public abstract String forNewspaper();
}
