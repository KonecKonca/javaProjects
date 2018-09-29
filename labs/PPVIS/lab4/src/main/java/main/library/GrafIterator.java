package main.library;

import java.util.ArrayList;

public interface GrafIterator<E> {
    boolean hasNext();
    E next();
    boolean hasPrevious();
    E previous();
}
