package com.kozitski.task2.interpreter;

import com.kozitski.task2.util.constants.MathOperations;
import com.kozitski.task2.util.constants.ExpressionOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolishNotationInterpreter {
    private static final String SPLIT_REGEX = "\\p{Blank}+";

    public List<MathExpression> parse(String polishNotation){
        List<MathExpression> expressions = new ArrayList<>();

        Arrays.asList(polishNotation.split(SPLIT_REGEX)).forEach( token -> {
             switch (token){
                 case  MathOperations.AND_SIGN:  /// ExpressionOperator.MINUS.getValue() -- constant expression required
                     expressions.add(res-> res.push(res.pop() & res.pop()));
                     break;
                 case MathOperations.LEFT_SHIFT_SIGN :
                     expressions.add(res -> {
                         int right = res.pop();
                         int left = res.pop();
                         res.push(left << right);
                     });
                     break;
                 case MathOperations.RIGHT_SHIFT_SIGN :
                     expressions.add(res -> {
                         int right = res.pop();
                         int left = res.pop();
                         res.push(left >> right);
                     });
                     break;
                 case MathOperations.TILDE_SIGN :
                     expressions.add(res-> res.push(~res.pop()));
                     break;
                 case MathOperations.OR_SIGN :
                     expressions.add(res-> res.push(res.pop() | res.pop()));
                     break;
                 case MathOperations.XOR_SIGN :
                     expressions.add(res-> res.push(res.pop() ^ res.pop()));
                     break;
                 case "+" :
                     expressions.add(res -> res.push(res.pop() + res.pop()));
                     break;
                 case  "-" :
                     expressions.add(res -> res.push(-res.pop() + res.pop()));
                     break;
                 case "*" :
                     expressions.add(res -> res.push(res.pop() * res.pop()));
                     break;
                 case "/" :
                     expressions.add(res -> res.push(1 / res.pop() * res.pop()));
                     break;
                 default:
                    expressions.add(res -> res.push(Integer.parseInt(token)));
             }
        });

        return expressions;
    }

}












