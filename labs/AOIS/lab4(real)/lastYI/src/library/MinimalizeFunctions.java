package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimalizeFunctions {

    public static String checkComplienceOfFunction(String str, char nameValueWithoutNomber, List<Integer> usingIndexes, String typeOfFunction) {
        if (usingIndexes.size() != 3) {
            throw new IllegalArgumentException();
        }

        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == nameValueWithoutNomber) {
                if ((i < (str.length() - 1)) && usingIndexes.contains(Integer.parseInt(String.valueOf(str.charAt(i + 1))))) {
                    counter++;
                }
            }
        }
        if (counter == 12)
            return typeOfFunction + " function is correct";

        return "Invalid " + typeOfFunction + " function";
    }

    public static String logicMethod(StringBuilder startFunction, TypesOfFunctions type, char nameValueWithoutNomber, List<Integer> usingIndexes) {
        StringBuilder result = new StringBuilder("Value of minimalize function: ");
        ArrayList<String> allTokens = new ArrayList<>(Arrays.asList(MinimalizeFunctions.parsingOnConstituents(startFunction, type)));

        StringBuilder res = new StringBuilder();
        int counter = 0;
        int position = 0;
        while (counter < 2){
            boolean checker = true;
            if(checker && !(allTokens.get(0).charAt(position) == allTokens.get(1).charAt(position))){
                
            }
            position++;
        }

        return result.toString();
    }

    public static String[] parsingOnConstituents(StringBuilder startFunctionm, TypesOfFunctions typesOfFunctions) {
        if (typesOfFunctions.equals(TypesOfFunctions.SDNF)) {
            for (int i = 0; i < startFunctionm.length(); i++) {
                if (startFunctionm.charAt(i) == '+') {
                    startFunctionm.setCharAt(i, 'r');
                }
            }
        } else {
            for (int i = 0; i < startFunctionm.length(); i++) {
                if (startFunctionm.charAt(i) == '*') {
                    startFunctionm.setCharAt(i, 'r');
                }
            }
        }
        String str = startFunctionm.toString();

        return str.split(" r ");
    }

}
