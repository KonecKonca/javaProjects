package com.kozitski.task2.composite;

public interface AbstractText {

    String getTextMessage();
    boolean add(AbstractText abstractText);
    boolean remove(AbstractText abstractText);
    boolean removeAll();

}
