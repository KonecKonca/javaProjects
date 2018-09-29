package main.books.library.abstractPrototypes;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class AbstractBook {
    protected String name;
    private String autor;
    private int nobmerOfPages;
    private String publishes;
    private String price;

    public abstract String usingOfBook();

    @Override
    public String toString() {
        return "AbstractBook{" +
                "\n\t\tname='" + name + '\'' +
                "\n\t\tautor='" + autor + '\'' +
                "\n\t\tnobmerOfPages=" + nobmerOfPages +
                "\n\t\tpublishes='" + publishes + '\'' +
                "\n\t\tprice=" + price +
                '}';
    }
}
