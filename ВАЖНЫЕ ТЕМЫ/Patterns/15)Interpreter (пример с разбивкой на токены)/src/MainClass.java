import java.text.MessageFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args){
        String expression = "1+2+3-4+9";  //11

        Expression evaluater = new Evaluate(expression);
        System.out.println(evaluater.inrerpret(evaluater));
    }
}

interface Expression{
    int inrerpret(Expression context);
}

class Number implements Expression{
    private int number;

    public Number(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    @Override
    public int inrerpret(Expression context) {
        return number;
    }
}

class Plus implements  Expression{
    private Expression expressionLeft;
    private Expression expressionRight;

    public Plus(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public int inrerpret(Expression context) {
        return expressionLeft.inrerpret(context) + expressionRight.inrerpret(context);
    }
}

class Minus implements  Expression{
    private Expression expressionLeft;
    private Expression expressionRight;

    public Minus(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public int inrerpret(Expression context) {
        return expressionLeft.inrerpret(context) - expressionRight.inrerpret(context);
    }
}

class Evaluate implements Expression{
    private Expression evaluate;

    public Evaluate(String expression) {
        Stack<Expression> expressions = new Stack<>();
        String expressionRever = new StringBuilder(expression).reverse().toString();
        for(String s : expressionRever.split("\\D")){
            expressions.push(new Number(Integer.parseInt(s)));
        }
        for (String s : expression.split("\\d")){
            if (s.equals("+")){
                expressions.push(new Plus(expressions.pop(), expressions.pop()));
            }
            else if (s.equals("-")){
                expressions.push(new Minus(expressions.pop(), expressions.pop()));
            }
        }
        evaluate = expressions.pop();
    }

    @Override
    public int inrerpret(Expression context) {
        return evaluate.inrerpret(context);
    }
}


























































