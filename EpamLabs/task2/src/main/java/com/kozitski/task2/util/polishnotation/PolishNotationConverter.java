package com.kozitski.task2.util.polishnotation;

import com.kozitski.task2.interpreter.constants.ExpressionOperator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolishNotationConverter {
    private List<ExpressionOperator> expressionOperators;


    public PolishNotationConverter() {
        expressionOperators = new ArrayList<>(Arrays.asList(ExpressionOperator.values()));
    }

    public String calculatePolishNotation(String expression){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '<' && expression.charAt(i + 1) == '<'){
                list.add(String.valueOf(expression.charAt(i)) + expression.charAt(i + 1));
                i++;
            }
            else if(expression.charAt(i) == '>' && expression.charAt(i + 1) == '>'){
                list.add(String.valueOf(expression.charAt(i)) + expression.charAt(i + 1));
                i++;
            }
            else{
                list.add(String.valueOf(expression.charAt(i)));
            }
        }

        return convert(list);
    }


    public String convert(List<String> expression){
        ArrayDeque<Integer> values = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();



        return "";
    }

    public String convert2(List<String> expression){
        ArrayDeque<Integer> values = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();

        for(String ex : expression){
            if(isCharacterOperator(ex)){

                if(operators.isEmpty()){
                    operators.push(ex);
                }
                else{
                    String pop = operators.pop();

                    if((ExpressionOperator.getExpressionOperator(pop).getRate() < ExpressionOperator.getExpressionOperator(ex).getRate())
                            || (ExpressionOperator.getExpressionOperator(pop).getRate() > ExpressionOperator.getExpressionOperator(ex).getRate()
                                && ((ExpressionOperator.getExpressionOperator(pop).getValue().equals("(")) || ExpressionOperator.getExpressionOperator(pop).getValue().equals(")")))){
                        operators.push(ex);
                    }
                    else{
                        int second = values.pop();
                        int first = values.pop();

                        values.push(second);

                    }

                }

            }
            else {
//                values.push(ex);
            }
        }

        return "";
    }
    private boolean isCharacterOperator(String character){
        for(int i = 0; i < expressionOperators.size(); i++){
            if(expressionOperators.get(i).getValue().equals(character)){
                return true;
            }
        }
        return false;
    }
    private boolean isRateOfFirstOperatorBigger(ExpressionOperator operator1, ExpressionOperator operator2){
        int firstOperator = 0;
        int secondOperator = 0;
        for(ExpressionOperator operator : expressionOperators){
            if(operator1.equals(operator)){
                firstOperator = operator.getRate();
            }
            else if(operator2.equals(operator)){
                secondOperator = operator.getRate();
            }
        }

        return  ((firstOperator > secondOperator) ? true : false);
    }

}
