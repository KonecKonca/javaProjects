package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimalizeFunctions {

    public static String checkComplienceOfFunction(String str, char nameValueWithoutNomber, List<Integer> usingIndexes, String typeOfFunction){
        if(usingIndexes.size() != 3){
            throw new IllegalArgumentException();
        }

        int counter = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == nameValueWithoutNomber){
                if((i < (str.length() - 1)) && usingIndexes.contains(Integer.parseInt(String.valueOf(str.charAt(i + 1))))){
                    counter++;
                }
            }
        }
        if(counter == 12)
            return  typeOfFunction + " function is correct";

        return "Invalid " + typeOfFunction + " function";
    }


}
