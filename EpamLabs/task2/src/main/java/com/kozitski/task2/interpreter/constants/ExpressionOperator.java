package com.kozitski.task2.interpreter.constants;

public enum ExpressionOperator {
    OR_EXPRESSION(5, "|"), XOR_EXPRESSION(6, "^"), AND_EXPRESSION(7, "&"),
    LEFT_SHIFT_EXPRESSION(10, "<<"), RIGHT_SHIFT_EXPRESSION(10, ">>"),
    TILDE_EXPRESSION(13, "~"), OPEN_BRACKET_EXPRESSION(14, "("),
    CLOSE_BRACKET_EXPRESSION(14, ")");

    private final int rate;
    private final String value;
    public int getRate() {
        return rate;
    }
    public String getValue() {
        return value;
    }

    ExpressionOperator(int rate, String value) {
        this.rate = rate;
        this.value = value;
    }
    public static ExpressionOperator getExpressionOperator(String value){
        if(value.equals("|")){
            return OR_EXPRESSION;
        }
        else if(value.equals("^")){
            return XOR_EXPRESSION;
        }
        else if(value.equals("&")){
            return AND_EXPRESSION;
        }
        else if(value.equals("<<")){
            return LEFT_SHIFT_EXPRESSION;
        }
        else if(value.equals(">>")){
            return RIGHT_SHIFT_EXPRESSION;
        }
        else if(value.equals("~")){
            return TILDE_EXPRESSION;
        }
        else if(value.equals("(")){
            return OPEN_BRACKET_EXPRESSION;
        }
        else if(value.equals(")")){
            return CLOSE_BRACKET_EXPRESSION;
        }

        return null;
    }

}
