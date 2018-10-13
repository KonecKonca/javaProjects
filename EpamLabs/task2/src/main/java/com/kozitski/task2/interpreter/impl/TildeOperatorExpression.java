package com.kozitski.task2.interpreter.impl;

import com.kozitski.task2.interpreter.Expression;

public class TildeOperatorExpression implements Expression{
    private Expression right;

    public TildeOperatorExpression(Expression right) {
        this.right = right;
    }

    @Override
    public int interpret() {
        return ~right.interpret();
    }
}
