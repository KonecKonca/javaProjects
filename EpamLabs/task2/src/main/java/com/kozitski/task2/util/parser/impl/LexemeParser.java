package com.kozitski.task2.util.parser.impl;

import com.kozitski.task2.composite.impl.TextComponent;
import com.kozitski.task2.composite.impl.TypeOfTextComponent;
import com.kozitski.task2.composite.impl.symbol.TextSign;
import com.kozitski.task2.util.parser.AbstractTextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements AbstractTextParser {
    private static final String WORD_REGEXP = "[\\w)('][\\w-)(']*";
    private WordParser wordParser = new WordParser();

    @Override
    public TextComponent parse(String str) {
        TextComponent lexeme = new TextComponent(TypeOfTextComponent.LEXEME);

        Pattern pattern = Pattern.compile(WORD_REGEXP);
        Matcher matcher = pattern.matcher(str);
        String word = "";
        while(matcher.find()){
            word = matcher.group();
            lexeme.add(wordParser.parse(word));
        }
        if((str.length() - word.length()) == 1){
           lexeme.add(new TextSign(String.valueOf(str.charAt(str.length() - 1))));
        }

        return lexeme;
    }

}
