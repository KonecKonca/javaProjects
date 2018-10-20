package com.kozitski.task2.util.parser.impl;

import com.kozitski.task2.composite.impl.TextComponent;
import com.kozitski.task2.composite.impl.TypeOfTextComponent;
import com.kozitski.task2.composite.impl.symbol.TextLetter;
import com.kozitski.task2.composite.impl.symbol.TextSign;
import com.kozitski.task2.util.parser.AbstractTextParser;

import java.util.regex.Pattern;

public class WordParser implements AbstractTextParser {
    private static final String LETTER_REGEXP = "\\w";

    @Override
    public TextComponent parse(String str) {
        TextComponent word = new TextComponent(TypeOfTextComponent.WORD);

        for (int i = 0; i < str.length(); i++) {
            if(String.valueOf(str.charAt(i)).matches(LETTER_REGEXP)){
                word.add(new TextLetter(String.valueOf(str.charAt(i))));
            }
            else {
                word.add(new TextSign(String.valueOf(str.charAt(i))));
            }
        }

        return word;
    }

}
