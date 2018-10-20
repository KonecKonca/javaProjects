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
    private static final String TILDA_EXPRESSION_REGEX = "~\\d+";

    public String replaceNumberExpressionsByNumber(String text){
        Pattern p = Pattern.compile(NUMBER_EXPRESSION_REGEX);
        Matcher matcher = p.matcher(text);

        PolishNotationConverter polishNotationParser = new PolishNotationConverter();
        PolishNotationParser interpreter = new PolishNotationParser();

        List<String> mustReplace = getAllExpressions(text);
        List<String> willReplace = convertToNumbers(reduceTilda(mustReplace));

        System.out.println(mustReplace);
        System.out.println(willReplace);

        System.out.println(13<<2);
        System.out.println(3>>5);
        System.out.println(6&9|(3&4));
        System.out.println(5|(1&2&(3|(4&(1^5|6&47)|3)|2)|1));
        System.out.println((71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78);
        System.out.println((7^5|1&2<<(2|5>>2&71))|1200);


        String result = "";
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
    private List<String> reduceTilda(List<String> input){
        List<String> result = new ArrayList<>();

        for(String string : input){

            if(isTildaPresent(string)){
                String newString = "";

                Pattern p = Pattern.compile(TILDA_EXPRESSION_REGEX);
                Matcher m = p.matcher(string);
                while (m.find()){
                    String useless = m.group();
                    int index = string.indexOf(useless);

                    newString = string.substring(0, index);
                    newString += ~Integer.parseInt(useless.substring(1));
                    newString += string.substring(index + useless.length());

                }
                result.add(newString);
            }
            else {
                result.add(string);
            }

        }

        return result;
    }
    private boolean isTildaPresent(String string){
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '~'){
                return true;
            }
        }

        return false;
    }

}
