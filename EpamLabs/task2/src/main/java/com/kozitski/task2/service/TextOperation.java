package com.kozitski.task2.service;

import com.kozitski.task2.composite.impl.redundant.TextAll;
import com.kozitski.task2.composite.impl.redundant.TextParagraph;
import com.kozitski.task2.composite.impl.redundant.TextSentence;
import com.kozitski.task2.composite.impl.redundant.TextToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextOperation {
    private static final Logger LOGGER = LogManager.getLogger(TextOperation.class);

    public static TextAll sortParagraphsByNumOFSentences(TextAll text){
        if(text == null){
            LOGGER.error("text can't be null");
            throw new RuntimeException("text can't be null");
        }

        TextAll result = new TextAll();

        List<TextParagraph> paragraphs = new ArrayList<>();
        for(int i = 0; i < text.getNumOfParagraphs(); i++){
            paragraphs.add(text.getParagraph(i));
        }
        paragraphs = paragraphs.stream().sorted( (e1, e2) -> e1.getNumOfSentences() - e2.getNumOfSentences()).collect(Collectors.toList());
        for(TextParagraph paragraph : paragraphs){
            result.add(paragraph);
        }

        LOGGER.info("Paragraphs was sorted by number of sentences");

        return result;
    }
    public static TextAll sortSentencesByTokenLength(TextAll text){
        if(text == null){
            LOGGER.error("text can't be null");
            throw new RuntimeException("text can't be null");
        }

        TextAll result = new TextAll();

        for(int i = 0; i < text.getNumOfParagraphs(); i++){
            TextParagraph paragraph = text.getParagraph(i);
            TextParagraph resultParagraph = new TextParagraph();

            for(int j = 0; j < paragraph.getNumOfSentences(); j++){
                TextSentence sentence = paragraph.getSentence(j);
                List<TextToken> tokens = new ArrayList<>();
                for(int z = 0; z < sentence.getNumOfTokens(); z++){
                    tokens.add(sentence.getToken(z));
                }
                tokens = tokens.stream().sorted( (e1, e2) -> e1.getNumOfSymbols() - e2.getNumOfSymbols()).collect(Collectors.toList());

                TextSentence resultSentence = new TextSentence();
                for(TextToken token : tokens){
                        resultSentence.add(token);
                }
                resultParagraph.add(resultSentence);
            }

            result.add(resultParagraph);
        }

        LOGGER.info("Sentences was sorted by length of tokens");

        return result;
    }
    public static TextAll reverseSortTokensByNumberOfSymbol(TextAll text, String searchSymbol){
        if(text == null){
            LOGGER.error("text can't be null");
            throw new RuntimeException("text can't be null");
        }

        TextAll result = new TextAll();
        TextParagraph resultParagraph = new TextParagraph();
        TextSentence resultSentence = new TextSentence();
        result.add(resultParagraph);
        resultParagraph.add(resultSentence);

        List<TextToken> tokens = new ArrayList<>();
        for(int i = 0; i < text.getNumOfParagraphs(); i++){
            TextParagraph paragraph = text.getParagraph(i);
            for(int j = 0; j < paragraph.getNumOfSentences(); j++){
                TextSentence sentence = paragraph.getSentence(j);
                for(int z = 0; z < sentence.getNumOfTokens(); z++){
                    tokens.add(sentence.getToken(z));
                }
            }
        }

        tokens.sort(Comparator.comparing( o -> getNumberMentionedSymbolInToken((TextToken) o, searchSymbol))
                .thenComparing( (e1, e2) -> ((TextToken) e1).getTextMessage().compareToIgnoreCase(((TextToken) e2).getTextMessage())));
        for(TextToken token : tokens){
            resultSentence.add(token);

        }

        LOGGER.info("Tokens was sorted in reverse order by number of mentioned symbols");

        return result;
    }



    private static int getNumberMentionedSymbolInToken(TextToken token, String searchSymbol){
        int result = 0;
        for(int i = 0; i < token.getNumOfSymbols(); i++){
            if(searchSymbol.equals(token.getSymbol(i).getTextMessage())){
                result--;
            }
        }
        return result;
    }

}












