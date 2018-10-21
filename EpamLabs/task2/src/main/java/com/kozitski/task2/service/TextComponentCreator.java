package com.kozitski.task2.service;

import com.kozitski.task2.composite.impl.TextComponent;
import com.kozitski.task2.util.parser.impl.TextAllParser;
import com.kozitski.task2.util.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextComponentCreator {
    private static final Logger LOGGER = LogManager.getLogger(TextComponentCreator.class);

    public static TextComponent create(){

        TextAllParser parser = new TextAllParser();
        String text = TextReader.readAllText(TextReader.INPUT_DATA_PATH);

        ExpressionConverter converter = new ExpressionConverter();
        String changeText = converter.replaceNumberExpressionsByNumber(text);

        LOGGER.info("TextComponent Object is created");

        return parser.parse(changeText);
    }

}
