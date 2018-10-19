package com.kozitski.task2.interpreter;

import java.util.List;

public class Client {
    private Context context = new Context();

    public int handleExpression(List<MathExpression> expressions){
            for(MathExpression terminal : expressions){
                terminal.interpret(context);
            }
            return context.pop();
    }

}
