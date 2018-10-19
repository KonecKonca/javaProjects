package com.kozitski.task2.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionConverter {
    private static final String NUMBER_EXPRESSION_REGEX = "\\p{Punct}*\\d[\\p{Punct}\\d]+";

    public static int convertToInteger(String text){
        List<String> list = parseToNumberStrings(text);

        return 1;
    }

    private static List<String> parseToNumberStrings(String text){
        List<String> result = new ArrayList<>();

        Pattern p = Pattern.compile(NUMBER_EXPRESSION_REGEX);
        Matcher matcher = p.matcher(text);

        while (matcher.find()){
            result.add(matcher.group());
        }

        return result;
    }

}
