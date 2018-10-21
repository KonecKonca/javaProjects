package com.kozitski.task2.composite;

import com.kozitski.task2.composite.impl.TypeOfTextComponent;

public interface AbstractText {

    String getTextMessage();
    boolean add(AbstractText abstractText);
    boolean remove(AbstractText abstractText);
    boolean removeAll();
    AbstractText getComponent(int index);
    int getComponentsSize();
    TypeOfTextComponent getTypeOfTextComponent();
    int countOfOrderedSymbol(String symbol);

}
