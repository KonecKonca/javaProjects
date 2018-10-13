package com.kozitski.task2.composite.impl;

import com.kozitski.task2.composite.AbstractText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextSentence implements AbstractText {
    private List<TextToken> tokens = new ArrayList<>();
    private static final String SPLIT_SENTENCE_REGEXP = "\\s";

    public TextSentence(String str) {
        List<String> allStr = new ArrayList<>(Arrays.asList(str.split(SPLIT_SENTENCE_REGEXP)));

        for(String s : allStr){
            tokens.add(new TextToken(s));
        }
    }

    public TextToken getToken(int index) {
        return tokens.get(index);
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(TextToken token : tokens){
            stringBuilder.append(token.getTextMessage());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
