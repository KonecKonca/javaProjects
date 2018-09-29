package main.books.library.interfaces.country;

public interface English {
    default String english(){
        return "english:  " + this;
    }
}
