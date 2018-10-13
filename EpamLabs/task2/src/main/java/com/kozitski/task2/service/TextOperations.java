package com.kozitski.task2.service;

import com.kozitski.task2.composite.impl.TextAll;
import com.kozitski.task2.composite.impl.TextParagraph;
import org.apache.logging.log4j.core.util.Integers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextOperations {

    public static TextAll sortParagraphsByNumOFSentences(TextAll text){
        TextAll result = new TextAll();

        List<TextParagraph> paragraphs = new ArrayList<>();
        for(int i = 0; i < text.getNumOfParagraphs(); i++){
            paragraphs.add(text.getParagraph(i));
        }
        paragraphs = paragraphs.stream().sorted( (e1, e2) -> e1.getNumOfSentences() - e2.getNumOfSentences()).collect(Collectors.toList());
        for(TextParagraph paragraph : paragraphs){
            result.add(paragraph);
        }

        return result;
    }
    public static TextAll sortSentencesByTokenLength(TextAll text){
        TextAll result = new TextAll();



        return result;
    }
    public static TextAll reverseSortTokensByNumberOfSymbol(TextAll text){
        TextAll result = new TextAll();



        return result;
    }

}
