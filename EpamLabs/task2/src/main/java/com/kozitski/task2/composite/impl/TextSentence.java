package com.kozitski.task2.composite.impl;

import com.kozitski.task2.composite.AbstractText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextSentence implements AbstractText {
    private List<TextToken> tokens = new ArrayList<>();

    public TextToken getToken(int index) {
        return tokens.get(index);
    }
    public int getNumOfTokens(){
        return tokens.size();
    }

    @Override
    public String getTextMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        tokens.removeIf(o -> o == null);
        tokens.forEach(o -> stringBuilder.append(o.getTextMessage()).append(" "));
        return stringBuilder.toString();
    }

    @Override
    public boolean add(AbstractText token) {
        if(token instanceof TextToken){
            return tokens.add((TextToken) token);
        }
        return false;
    }
    @Override
    public boolean remove(AbstractText token) {
        if(token instanceof TextToken){
            return tokens.remove(token);
        }
        return false;
    }

    @Override
    public boolean removeAll() {
        tokens = new ArrayList<>();
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(TextToken token : tokens){
            stringBuilder.append(token.getTextMessage());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
