package main.books.library.abstractPrototypes;

public abstract class AbstractCatalog extends AbstractBook {
    @Override
    public String usingOfBook() {
        return "Released in  ----> AbstractCatalog";
    }

    abstract public String forCatalog();
}
