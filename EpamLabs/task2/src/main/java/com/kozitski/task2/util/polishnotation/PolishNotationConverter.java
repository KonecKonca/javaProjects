package com.kozitski.task2.util.polishnotation;

import com.kozitski.task2.interpreter.constants.ExpressionOperator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolishNotationConverter {
    private List<ExpressionOperator> expressionOperators;
    private static final Logger LOGGER = LogManager.getLogger(PolishNotationConverter.class);

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

            else if(!isCharacterOperator(String.valueOf(expression.charAt(i)))){
                StringBuilder number = new StringBuilder();
                int counter = i;
                do {
                    number.append(expression.charAt(counter));
                    counter++;
                    if(counter >= expression.length()){
                        break;
                    }
                }
                while (!isCharacterOperator(String.valueOf(expression.charAt(counter))));

                i = counter - 1;
                list.add(number.reverse().toString());
            }



//            else if(expression.charAt(i) == '-'){
//                StringBuilder number = new StringBuilder();
//                int counter = i++;
//                do {
//                    number.append(expression.charAt(counter));
//                    counter++;
//                    if(counter >= expression.length()){
//                        break;
//                    }
//                }
//                while (!isCharacterOperator(String.valueOf(expression.charAt(counter))));
//
//                i = counter - 1;
//                list.add("-" + number.reverse());
//            }



            else{
                list.add(String.valueOf(expression.charAt(i)));
            }
        }

        return convert(list);
    }

    private String convert(List<String> expression){
        ArrayDeque<String> kiev = new ArrayDeque<>();
        ArrayDeque<String> moskov = new ArrayDeque<>();

        for(String character : expression){
             if(!character.equals("")){
                if(!isCharacterOperator(character)){
                    kiev.push(character);
                }
                else {
                    if(moskov.isEmpty()){
                        moskov.push(character);
                    }
                    else{
                        String lastWait = moskov.pop();

                        if(ExpressionOperator.getExpressionOperator(character).getValue().equals("(")){
                            moskov.push(lastWait);
                            moskov.push(character);
                        }
                        else if(ExpressionOperator.getExpressionOperator(character).getValue().equals(")") && !lastWait.equals("(")){
                            kiev.push(lastWait);

                            String lastPop = "";
                            while (!moskov.isEmpty()){
                                lastPop = moskov.pop();

                                if(lastPop.equals("(")){
                                    break;
                                }
                                else{
                                    kiev.push(lastPop);
                                }

                            }

                        }
                        else if(ExpressionOperator.getExpressionOperator(lastWait).getValue().equals("(")){
                            moskov.push(lastWait);
                            moskov.push(character);
                        }
                        else if(ExpressionOperator.getExpressionOperator(lastWait).getValue().equals(")")){
                            moskov.push(lastWait);
                        }

                        else if(ExpressionOperator.getExpressionOperator(character).getRate() > ExpressionOperator.getExpressionOperator(lastWait).getRate()){
                            moskov.push(lastWait);
                            moskov.push(character);
                        }
                        else if(ExpressionOperator.getExpressionOperator(character).getRate() <= ExpressionOperator.getExpressionOperator(lastWait).getRate()){
                            kiev.push(lastWait);

                            String lastPop = "";

                            if(!moskov.isEmpty()){
                                while(true){
                                    lastPop = moskov.pop();

                                    if(lastPop.equals("(")){
                                        moskov.push(lastPop);
                                        moskov.push(character);
                                        break;
                                    }
                                    if(ExpressionOperator.getExpressionOperator(lastPop).getRate() >= ExpressionOperator.getExpressionOperator(character).getRate()){
                                        kiev.push(lastPop);
                                    }
                                    else if(ExpressionOperator.getExpressionOperator(lastPop).getRate() < ExpressionOperator.getExpressionOperator(character).getRate()){
                                        moskov.push(lastPop);
                                        moskov.push(character);
                                        break;
                                    }
                                }
                            }

                        }
                        // Redundant
                        else{
                            kiev.push(lastWait);
                            moskov.push(character);
                        }
                    }
                }
            }
        }

        while (!moskov.isEmpty()){
            String add = moskov.pop();
            if(!add.equals("(") && !add.equals(")")){
                kiev.push(add);
            }
        }
//
//        System.out.println("Kiev: " + kiev);
//        System.out.println("Moscov: " + moskov);

        LOGGER.debug("Kiev: " + kiev);  /// RENAME FUCKING KIEV and MOSCOW
        LOGGER.debug("Moscov: " + moskov);

        return reverseNotation(kiev);
    }
    private boolean isCharacterOperator(String character){
        for(int i = 0; i < expressionOperators.size(); i++){
            if(expressionOperators.get(i).getValue().equals(character)){
                return true;
            }
        }
        if(String.valueOf(character).equals(">") || String.valueOf(character).equals("<")){
            return true;
        }
        return false;
    }
    private String reverseNotation(ArrayDeque<String> deque){
        StringBuilder stringBuilder = new StringBuilder();

        for(String str : deque){
            stringBuilder.append(str);
            stringBuilder.append(" ");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);

        return stringBuilder.reverse().toString();
    }

    @Deprecated
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
    @Deprecated
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
