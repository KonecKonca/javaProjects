package com.kozitski.task2.util.parser.impl;

import com.kozitski.task2.composite.AbstractText;
import com.kozitski.task2.util.parser.AbstractTextParser;

public class ParagraphParser implements AbstractTextParser {
    private SentenceParser sentenceParser = new SentenceParser();

    @Override
    public void parse(AbstractText textAll, String str) {

    }
}
