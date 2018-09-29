package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static library.LogicOperations.*;

public class MainClass {
    private static final String str = "!((!x1+x2) * !(x2*x3))";
    private static List<List<Boolean>> list = new ArrayList<>();

    public static void main(String[] args) {
        fasad();
    }

    private static void fasad(){
        initialization();

        inputFunctionResult();
        System.out.println(getSdnf());
        System.out.println(getSknf());
        System.out.println("In number representation:  " + numberFormat());
    }

    private static void inputFunctionResult(){
        System.out.println("Start function: " + str);
        int counter = 0;
        for(List<Boolean> l : list){
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println(counter + ": value1 = " + l.get(0) + " | value2 = " + l.get(1) + " | value3 = " + l.get(2) + "| \t result = "
                    + function(l.get(0), l.get(1), l.get(2)));
            counter++;
        }
        System.out.println("\n");

    }
    private static String getSdnf(){
        StringBuilder functions = new StringBuilder();
        functions.append("SDNF: ");
        int plusCounter = 0;
        for(List<Boolean> l : list){
            if(function(l.get(0), l.get(1), l.get(2))){
                for(int i = 0; i < l.size(); i++){
                    String value = "";
                    value += (l.get(i) ? ("x" + i) : ("!x" + i));
                    if(i != 2){
                        functions.append(value);
                        functions.append("*");
                    }
                    else if(plusCounter != (list.size() - 1)){
                        functions.append(value);
                        functions.append(" + ");
                    }
                    else{
                        functions.append(value);
                    }
                }
            }
            plusCounter++;
        }

        return functions.toString();
    }
    private static String getSknf(){
        StringBuilder functions = new StringBuilder();
        functions.append("SKNF: ");
        int multiplayCounter = 0;
        for(List<Boolean> l : list){
            if(!function(l.get(0), l.get(1), l.get(2))){
                functions.append("(");
                for(int i = 0; i < l.size(); i++){
                    String value = "";
                    value += (l.get(i) ? ("x" + i) : ("!x" + i));
                    if(i != 2){
                        functions.append(value);
                        functions.append("+");
                    }
                    else {
                        functions.append(value);
                    }
                }
                if(multiplayCounter < ((list.size() - 1)/2)){
                    multiplayCounter++;
                    functions.append(") * ");
                }
                else {
                    functions.append(")");
                }
            }
        }

        return functions.toString();
    }
    private static String numberFormat(){
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("V(");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("λ(");

        for(int i = 0; i < list.size(); i++){
            if(!function(list.get(i).get(0), list.get(i).get(1), list.get(i).get(2))){
                stringBuilder2.append(i);
                stringBuilder2.append(", ");
            }
            else if(function(list.get(i).get(0), list.get(i).get(1), list.get(i).get(2))){
                stringBuilder1.append(i);
                stringBuilder1.append(", ");
            }
        }

        stringBuilder1.append(")");
        stringBuilder2.append(")");
        stringBuilder1.append(" = ");
        stringBuilder1.append(stringBuilder2);
        return stringBuilder1.toString();
    }
    private static String getValue(){

        return "";
    }

    private static void initialization(){
        list.add(new ArrayList<>(Arrays.asList(false, false, false)));
        list.add(new ArrayList<>(Arrays.asList(false, false, true)));
        list.add(new ArrayList<>(Arrays.asList(false, true, false)));
        list.add(new ArrayList<>(Arrays.asList(false, true, true)));
        list.add(new ArrayList<>(Arrays.asList(true, true, true)));
        list.add(new ArrayList<>(Arrays.asList(true, true, false)));
        list.add(new ArrayList<>(Arrays.asList(true, false, false)));
        list.add(new ArrayList<>(Arrays.asList(true, false, true)));
    }
    private static boolean function(boolean value1, boolean value2, boolean value3){
        return not(and(or(not(value1), value2), not(and(value2, value3))));
    }

}


//   * => &