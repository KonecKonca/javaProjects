package com.kozitski.task2.service;

import com.kozitski.task2.interpreter.Client;
import com.kozitski.task2.interpreter.MathExpression;
import com.kozitski.task2.interpreter.PolishNotationParser;
import com.kozitski.task2.util.parser.impl.TextAllParser;
import com.kozitski.task2.util.polishnotation.PolishNotationConverter;
import com.kozitski.task2.util.reader.TextReader;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionConverter {
    // search all number expressions
    private static final String NUMBER_EXPRESSION_REGEX = "\\p{Punct}*\\d[\\p{Punct}\\d]+";

    public String replaceNumberExpressionsByNumber(String text){
        PolishNotationConverter polishNotationParser = new PolishNotationConverter();
        PolishNotationParser interpreter = new PolishNotationParser();

        List<String> mustReplace = getAllExpressions(text);
        List<String> willReplace = convertToNumbers(mustReplace);

        String result = text;
        for (int i = 0; i < mustReplace.size(); i++) {
            result = result.replace(mustReplace.get(i), willReplace.get(i));
        }

        return result;
    }

    private List<String> getAllExpressions(String text){
        List<String> expressions = new ArrayList<>();

        Pattern p = Pattern.compile(NUMBER_EXPRESSION_REGEX);
        Matcher matcher = p.matcher(text);

        while (matcher.find()){
            expressions.add(matcher.group());
        }

        return expressions;
    }
    private List<String> convertToNumbers(List<String> input){
        List<String> result = new ArrayList<>();

        PolishNotationConverter polishNotationParser = new PolishNotationConverter();
        PolishNotationParser interpreter = new PolishNotationParser();

        for(String value : input){
            List<MathExpression> mathExpressions = interpreter.parse(polishNotationParser.calculatePolishNotation(value));
            Client client = new Client();
            int res = client.handleExpression(mathExpressions);
            result.add(String.valueOf(res));
        }

        return result;
    }

}
