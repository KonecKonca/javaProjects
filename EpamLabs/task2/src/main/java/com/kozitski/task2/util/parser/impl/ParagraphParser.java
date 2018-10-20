package com.kozitski.task2.util.parser.impl;

import com.kozitski.task2.composite.impl.redundant.TextParagraph;
import com.kozitski.task2.util.parser.AbstractTextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParagraphParser implements AbstractTextParser {
    private static final Logger LOGGER = LogManager.getLogger(ParagraphParser.class);
    private static final String SPLIT_PARAGRAPH_REGEX = "(?<=[.{1}!?])\\s";
    private SentenceParser sentenceParser = new SentenceParser();

    @Override
    public TextParagraph parse(String str) {
        TextParagraph paragraph = new TextParagraph();

        List<String> allStr = new ArrayList<>(Arrays.asList(str.split(SPLIT_PARAGRAPH_REGEX)));

        for(String s : allStr){
            paragraph.add(sentenceParser.parse(s));
        }

        LOGGER.info("Paragraph was parsed");

        return paragraph;
    }

}
