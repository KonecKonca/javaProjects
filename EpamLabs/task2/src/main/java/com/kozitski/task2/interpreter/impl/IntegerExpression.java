package com.kozitski.task2.interpreter.impl;

import com.kozitski.task2.interpreter.Expression;

public class IntegerExpression implements Expression {
    private int number;

    public IntegerExpression(int number) {
        this.number = number;
    }
    @Override
    public int interpret() {
        return number;
    }
}
