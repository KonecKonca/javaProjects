package com.kozitski.task2.interpreter;

import java.util.ArrayDeque;

public class Context {
    private ArrayDeque<Integer> contextValue = new ArrayDeque<>();

    public Integer pop() {
        return contextValue.pop();
    }
    public void push(Integer integer) {
        contextValue.push(integer);
    }
    public Integer peek() {
        return contextValue.peek();
    }

}
