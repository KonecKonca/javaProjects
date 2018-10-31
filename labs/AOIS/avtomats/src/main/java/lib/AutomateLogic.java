package lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutomateLogic {
    private final int value1;
    private final int value2;
    private final int value3;

    private boolean isEvenValue1;
    private boolean isEvenValue2;
    private boolean isEvenValue3;


    public AutomateLogic(int value1, int value2, int value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;

        isEvenValue1 = false;
        isEvenValue2 = false;
        isEvenValue3 = false;
    }

    public void addToAnalise(int number){
        if(number != value1 && number != value2 && number != value3)
            throw new IllegalArgumentException("Value is not valid");

        if(number  == value1){
            isEvenValue1 = !isEvenValue1;
            return;
        }
        if(number == value2) {
            isEvenValue2 = !isEvenValue2;
            return;
        }
        isEvenValue3 = !isEvenValue3;
    }
    public States getState(){
        if(isEvenValue1 && isEvenValue2 && isEvenValue3){
            return States.ALL_EVEN;
        }
        else if(!isEvenValue1 && !isEvenValue2 && !isEvenValue3){
            return States.AlL_NOT_EVEN;
        }
        else if(isEvenValue1 && !isEvenValue2 && !isEvenValue3){
            return States.VALUE1_EVEN;
        }
        else if(!isEvenValue1 && isEvenValue2 && !isEvenValue3){
            return States.VALUE2_EVEN;
        }
        else if(!isEvenValue1 && !isEvenValue2 && isEvenValue3){
            return States.VALUE3_EVEN;
        }
        else if(isEvenValue1 && isEvenValue2 && !isEvenValue3){
            return States.VALUE1_VALUE2_EVEN;
        }
        else if(isEvenValue1 && !isEvenValue2 && isEvenValue3){
            return States.VALUE1_VALUE3_EVEN;
        }
        else{
            return States.VALUE2_VALUE3_EVEN;
        }

    }
    public List<Integer> getAvailableValues(){
        return new ArrayList<>(Arrays.asList(value1, value2, value3));
    }

}
