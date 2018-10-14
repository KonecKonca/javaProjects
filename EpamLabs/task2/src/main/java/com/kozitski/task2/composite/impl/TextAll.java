package com.kozitski.task2.composite.impl;

import com.kozitski.task2.composite.AbstractText;
import com.kozitski.task2.util.parser.impl.TextAllParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextAll implements AbstractText {
    private static final Logger LOGGER = LogManager.getLogger(TextAll.class);
    private List<TextParagraph> paragraphs = new ArrayList<>();

    public TextParagraph getParagraph(int index) {
        return paragraphs.get(index);
    }
    public int getNumOfParagraphs(){
        return paragraphs.size();
    }

    @Override
    public String getTextMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        paragraphs.removeIf(o -> o == null);
        paragraphs.forEach(o -> stringBuilder.append(o.getTextMessage()).append("\n\t"));
        return stringBuilder.toString();
    }

    @Override
    public boolean add(AbstractText paragraph) {
        if(paragraph instanceof TextParagraph){
            LOGGER.info("Paragraph was added");
            return paragraphs.add((TextParagraph) paragraph);
        }
        return false;
    }
    @Override
    public boolean remove(AbstractText paragraph) {
        if(paragraph instanceof TextParagraph){
            LOGGER.info("Paragraph was removed");
            return paragraphs.remove(paragraph);
        }
        return false;
    }
    @Override
    public boolean removeAll() {
        paragraphs = new ArrayList<>();
        LOGGER.info("Paragraphs were removed");
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(TextParagraph paragraph : paragraphs){
            stringBuilder.append(paragraph.getTextMessage());
            stringBuilder.append("\n\t");
        }
        return stringBuilder.toString();
    }

}
