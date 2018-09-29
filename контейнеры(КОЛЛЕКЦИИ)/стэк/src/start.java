/**
 * Created by Андрей on 31.12.2017.
 */

import java.lang.reflect.Array;
import java.util.*;

public class start {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("Красный");
        printStack(stack);
        stack.push("Зелёный");
        printStack(stack);
        stack.push("Синий");
        printStack(stack);

        stack.pop();
        printStack(stack);
        stack.pop();
        printStack(stack);
        stack.pop();
        printStack(stack);

        stack.push("1");
        stack.push("2");
        System.out.println(stack.pop() + "\t" + stack.pop());  // вывод верхнего элемента
    }

    public static void printStack(List<String> s){
        if(s.isEmpty()){
            System.out.println("Стек пустой");
        }
        else {
            System.out.println(s);  // вывод всего стека
        }
    }
}
