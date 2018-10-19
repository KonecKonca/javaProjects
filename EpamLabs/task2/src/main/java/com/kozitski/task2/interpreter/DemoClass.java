package com.kozitski.task2.interpreter;

import java.util.List;

public class DemoClass {
    public static void main(String[] args) {


//        String expression = "2 4 + 7 * 3 3 + - 4 *";  //  ((2 + 4) * 7 - (3 + 3)) * 4

        String expression = "4 7 + 7 / 3 * 4 2 + * 4 2 - 3 * +";

        PolishNotationParser interpreter = new PolishNotationParser();
        List<MathExpression> list = interpreter.parse(expression);

        Client client = new Client();
        int result = client.handleExpression(list);

        System.out.println(expression + " = " + result);


    }
}
