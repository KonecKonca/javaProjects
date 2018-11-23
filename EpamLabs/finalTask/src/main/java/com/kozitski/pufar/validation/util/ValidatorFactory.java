package com.kozitski.pufar.validation.util;

import com.kozitski.pufar.validation.validator.*;

import java.util.ArrayList;
import java.util.List;

// Will be good generate validators by string with classLoader (in use must be change only .property file)
class ValidatorFactory {

    static ArrayList<Validator> getActiveValidators(List<Object> names, List<Object> isActive){

        List<String> stringNames = new ArrayList<>();
        for(Object o : names){
            stringNames.add(o.toString());
        }

        List<Boolean> boolIsActive = new ArrayList<>();
        for(Object o : isActive){
            boolIsActive.add(Boolean.valueOf(o.toString()));
        }


        ArrayList<Validator> activeValidators = new ArrayList<>();

        for(int i = 0; i < boolIsActive.size(); i++){
            if(boolIsActive.get(i)){
                switch (stringNames.get(i)){
                    case ValidatorType.STRING_VALIDATOR:
                        activeValidators.add(new StringValidator());
                        break;
                    case ValidatorType.INT_VALIDATOR:
                        activeValidators.add(new IntValidator());
                        break;
                    case ValidatorType.USER_VALIDATOR:
                        activeValidators.add(new UserValidator());
                        break;
                    case ValidatorType.NOTIFICATION_VALIDATOR:
                        activeValidators.add(new NotificationValidator());
                        break;
                }
            }
        }

        return activeValidators;
    }

}
