package com.kozitski.task2.util.parser.impl;

import com.kozitski.task2.composite.impl.redundant.TextSymbol;
import com.kozitski.task2.util.parser.AbstractTextParser;

public class SymbolParser implements AbstractTextParser {

    @Override
    public TextSymbol parse(String str) {
        return new TextSymbol(str);
    }
}
