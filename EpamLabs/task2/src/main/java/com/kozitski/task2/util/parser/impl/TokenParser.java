package com.kozitski.task2.util.parser.impl;

import com.kozitski.task2.composite.impl.redundant.TextToken;
import com.kozitski.task2.util.parser.AbstractTextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TokenParser implements AbstractTextParser {
    private static final Logger LOGGER = LogManager.getLogger(TextAllParser.class);
    private SymbolParser symbolParser = new SymbolParser();

    @Override
    public TextToken parse(String str) {
        TextToken token = new TextToken();

        for(int i = 0; i < str.length(); i++){
            token.add(symbolParser.parse(String.valueOf(str.charAt(i))));
        }

        LOGGER.info("Token was parsed");

        return token;
    }

}
