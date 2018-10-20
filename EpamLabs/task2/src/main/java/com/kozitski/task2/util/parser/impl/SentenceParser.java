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
    private static final String SPLIT_SENTENCE_REGEXP = "\\s+(?=\\w)";
    private LexemeParser lexemeParser = new LexemeParser();

    @Override
    public TextComponent parse(String str) {
        TextComponent sentence = new TextComponent(TypeOfTextComponent.SENTENCE);

        List<String> allStr = new ArrayList<>(Arrays.asList(str.split(SPLIT_SENTENCE_REGEXP)));

        for(String s : allStr){
            sentence.add(lexemeParser.parse(s));
        }

        LOGGER.info("Sentence was parsed");

        return sentence;
    }
}
