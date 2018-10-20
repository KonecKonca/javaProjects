package com.kozitski.task2.util.parser.impl;

import com.kozitski.task2.composite.impl.TextComponent;
import com.kozitski.task2.composite.impl.TypeOfTextComponent;
import com.kozitski.task2.composite.impl.redundant.TextToken;
import com.kozitski.task2.composite.impl.symbol.TextSign;
import com.kozitski.task2.util.parser.AbstractTextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements AbstractTextParser {
    private static final String LEXEME_REGEXP = "[\\w-']+";
    private WordParser wordParser = new WordParser();

    @Override
    public TextComponent parse(String str) {
        TextComponent token = new TextComponent(TypeOfTextComponent.LEXEME);

        Pattern pattern = Pattern.compile(LEXEME_REGEXP);
        Matcher matcher = pattern.matcher(str);
        String word = "";
        while(matcher.find()){
            word = matcher.group();
            token.add(wordParser.parse(word));
        }
        if((str.length() - word.length()) == 1){
           token.add(new TextSign(String.valueOf(str.charAt(str.length() - 1))));
        }

        return token;
    }

}
