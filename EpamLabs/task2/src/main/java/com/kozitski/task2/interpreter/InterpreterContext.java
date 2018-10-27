package com.kozitski.task2.interpreter;

import java.util.ArrayDeque;

public class InterpreterContext {
    private ArrayDeque<Integer> contextValue = new ArrayDeque<>();

    public Integer pop() {
        return contextValue.pop();
    }
    public void push(Integer integer) {
        contextValue.push(integer);
    }

}
