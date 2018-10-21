package com.kozitski.task2.util.parser.impl;

import com.kozitski.task2.composite.impl.TextComponent;
import com.kozitski.task2.composite.impl.TypeOfTextComponent;
import com.kozitski.task2.util.parser.AbstractTextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceParser implements AbstractTextParser {
    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);
    private static final String SPLIT_ON_LEXEME_REGEXP = "\\s+(?=[\\w-(])";
    private LexemeParser lexemeParser = new LexemeParser();

    @Override
    public TextComponent parse(String str) {
        TextComponent sentence = new TextComponent(TypeOfTextComponent.SENTENCE);

        List<String> allStr = new ArrayList<>(Arrays.asList(str.split(SPLIT_ON_LEXEME_REGEXP)));
        allStr.removeIf(o -> o.equals(""));

        for(String s : allStr){
            sentence.add(lexemeParser.parse(s));
        }

        LOGGER.info("Sentence was parsed on lexemes");

        return sentence;
    }

}
