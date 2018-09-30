import lib.AutomateLogic;

import java.lang.Math;
import java.util.*;

public class Lab {
    public static void main(String[] args) {
        fasad();
    }

    public static void fasad(){
        AutomateLogic automate = new AutomateLogic(1, 2, 3);

        System.out.println("Available values: " + automate.getAvailableValues());
        System.out.println("Before changing states: " + automate.getState());

        System.out.println("Resalts of changing states in automate:\n");

        for(int i = 0; i < 30; i++){
            Random random = new Random();
            int addNumber = random.nextInt(3) + 1;
            automate.addToAnalise(addNumber);
            System.out.println("Add nomber: " + addNumber + " ==>  " + automate.getState());
        }

    }

}