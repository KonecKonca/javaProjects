package com.kozitski.task2.composite.impl;

import com.kozitski.task2.composite.AbstractText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextToken implements AbstractText {
    private List<TextSymbol> symbols = new ArrayList<>();

    public TextToken(String str) {
        for(int i = 0; i < str.length(); i++){
            symbols.add(new TextSymbol(String.valueOf(str.charAt(i))));
        }
    }

    public TextSymbol getSymbol(int index) {
        return symbols.get(index);
    }

    @Override
    public String getTextMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        symbols.removeIf(o -> o == null);
        symbols.forEach(o -> stringBuilder.append(o.getTextMessage()));
        return stringBuilder.toString();
    }

    @Override
    public boolean add(AbstractText symbol) {
        if(symbol instanceof TextSymbol){
            return symbols.add((TextSymbol) symbol);
        }
        return false;
    }
    @Override
    public boolean remove(AbstractText symbol) {
        if(symbol instanceof TextSymbol){
            return symbols.remove(symbol);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(TextSymbol symbol : symbols){
            stringBuilder.append(symbol.getTextMessage());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
