package com.kozitski.task2.interpreter.impl;

import com.kozitski.task2.interpreter.Expression;

public class OrOperationExpression implements Expression {
    private Expression right;
    private Expression left;

    public OrOperationExpression(Expression right, Expression left) {
        this.right = right;
        this.left = left;
    }

    @Override
    public int interpret() {
        return left.interpret() | right.interpret();
    }
}
