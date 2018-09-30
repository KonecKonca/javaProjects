package main;

import library.MinimalizeFunctions;
import library.TypesOfFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static final String SDNF = "!x0*x1*x2 + x0*x1*x2 + x0*!x1*!x2 + x0*!x1*x2";
    public static final String SKNF = "(!x0+!x1+!x2) * (!x0+!x1+x2) * (!x0+x1+!x2) * (x0+x1+!x2)";

    public static void main(String[] args) {
        fasad();
    }

    private static void fasad(){
        System.out.println("Input data: ");
        System.out.println(commonInput());

        System.out.println("\n-------------------------------------------------------------\n");

        System.out.println("Result of cheaking complience SDNF:  " + MinimalizeFunctions.checkComplienceOfFunction(SDNF, 'x', new ArrayList<>(Arrays.asList(0, 1, 2)), "SDNF"));
        System.out.println("Result of cheaking complience SKNF:  " + MinimalizeFunctions.checkComplienceOfFunction(SKNF, 'x', new ArrayList<>(Arrays.asList(0, 1, 2)), "SKNF"));

        System.out.println(MinimalizeFunctions.logicMethod(new StringBuilder(SDNF), TypesOfFunctions.SDNF, 'x', new ArrayList<>(Arrays.asList(0, 1, 2))));
        System.out.println(MinimalizeFunctions.logicMethod(new StringBuilder(SKNF), TypesOfFunctions.SKNF, 'x', new ArrayList<>(Arrays.asList(0, 1, 2))));

    }

    public static String commonInput(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SDNF:  ");
        stringBuilder.append(SDNF);

        stringBuilder.append("\n");

        stringBuilder.append("SKNF:  ");
        stringBuilder.append(SKNF);

        return stringBuilder.toString();
    }

}


//   * => &