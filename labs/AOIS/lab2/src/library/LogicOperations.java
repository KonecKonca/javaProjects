package library;

public class LogicOperations {

    public static boolean or(boolean value1, boolean value2){
        if(value1){
            return true;
        }
        if(value2){
            return true;
        }
        return false;
    }
    public static boolean and(boolean value1, boolean value2){
        int counter = 0;
        if(value1){
            counter++;
        }
        if(value2){
            counter++;
        }

        if(counter == 2){
            return true;
        }
        return false;
    }
    public static boolean not(boolean value){
        if(value){
            return false;
        }
        return true;
    }
    public static boolean inBoolean(int value){
        return value != 0;
    }

}
