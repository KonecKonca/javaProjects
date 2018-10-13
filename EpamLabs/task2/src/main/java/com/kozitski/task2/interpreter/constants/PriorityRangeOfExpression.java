package com.kozitski.task2.interpreter.constants;

public enum PriorityRangeOfExpression {
    OR_EXPRESSION(5), XOR_EXPRESSION(6), AND_EXPRESSION(7),
    SHIFT_EXPRESSION(10), TILDE_EXPRESSION(13), BRACKET_EXPRESSION(14);

    private final int rate;
    PriorityRangeOfExpression(int rate) {
        this.rate = rate;
    }
    public int getRate() {
        return rate;
    }
}
