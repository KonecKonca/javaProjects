package com.kozitski.task2.composite;

public interface CommonText {

    String getTextMessage();
    boolean add(CommonText commonText);
    CommonText getComponent(int index);
    int getComponentsSize();
    ComponentType getTypeOfTextComponent();
    int countOfOrderedSymbol(String symbol);

}
