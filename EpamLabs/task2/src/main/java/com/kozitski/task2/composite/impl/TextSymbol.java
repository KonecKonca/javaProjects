package com.kozitski.task2.composite.impl;

import com.kozitski.task2.composite.AbstractText;

public class TextSymbol implements AbstractText {
    private String symbol;

    public TextSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getTextMessage() {
        return symbol;
    }
    @Override
    public boolean add(AbstractText abstractText) {
        return false;
    }
    @Override
    public boolean remove(AbstractText abstractText) {
        return false;
    }

    @Override
    public String toString() {
        return symbol;
    }

}
