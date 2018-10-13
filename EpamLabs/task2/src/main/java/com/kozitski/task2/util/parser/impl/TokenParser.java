package com.kozitski.task2.util.parser.impl;

import com.kozitski.task2.composite.impl.TextSymbol;
import com.kozitski.task2.composite.impl.TextToken;
import com.kozitski.task2.util.parser.AbstractTextParser;

public class TokenParser implements AbstractTextParser {
    private SymbolParser symbolParser = new SymbolParser();

    @Override
    public TextToken parse(String str) {
        TextToken token = new TextToken();

        for(int i = 0; i < str.length(); i++){
            token.add(symbolParser.parse(String.valueOf(str.charAt(i))));
        }

        return token;
    }

}
