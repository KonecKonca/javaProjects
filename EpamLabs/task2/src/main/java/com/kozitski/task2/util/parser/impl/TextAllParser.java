package com.kozitski.task2.util.parser.impl;

import com.kozitski.task2.composite.impl.redundant.TextAll;
import com.kozitski.task2.util.parser.AbstractTextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextAllParser implements AbstractTextParser {
    private static final Logger LOGGER = LogManager.getLogger(TextAllParser.class);
    private static final String SPLIT_ALL_TEXT_REGEXP = "\\s{4}";
    private ParagraphParser paragraphParser = new ParagraphParser();

    @Override
    public TextAll parse(String str) {
        TextAll text = new TextAll();

        List<String> allStr = new ArrayList<>(Arrays.asList(str.split(SPLIT_ALL_TEXT_REGEXP)));

        for(String s : allStr){
            text.add(paragraphParser.parse(s));
        }

        LOGGER.info("Text was parsed all");

        return text;
    }

}
