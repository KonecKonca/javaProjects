package game;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Setter;
import main.GuiClass;
import time.Timer;

import javax.swing.*;
import java.awt.*;

public class GameLogic {
    @Setter
    private static GameData gameData;

    //  Position in array of pressed buttons
    //  range [1 .. 16]
    private static int pressed1Nomber;
    private static int pressed2Nomber;

    private static int coordinatI1;
    private static int coordinatJ1;
    private static int coordinatI2;
    private static int coordinatJ2;

    public GameLogic(){
    }

    public static boolean checkWin(){
        int counter = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if(gameData.getField(i, j).getText().equalsIgnoreCase(gameData.getNomber(i, j))){
                    counter++;
                }
            }
        }
        if(counter == 16){
            return true;
        }
        return false;
    }
    public static void change(){
        int counter = 0;
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                counter++;
                if(gameData.getPressed1().getSource() == gameData.getField(i, j)){
                    pressed1Nomber = counter;
                    coordinatI1 = i;
                    coordinatJ1 = j;
                }
                if(gameData.getPressed2().getSource() == gameData.getField(i, j)){
                    pressed2Nomber = counter;
                    coordinatI2 = i;
                    coordinatJ2 = j;
                }
            }
        }
        counter = 0;
//        System.out.println(pressed1Nomber + " " +  pressed2Nomber);
        if(allowChanging()){
            String press1 = gameData.getField(coordinatI1, coordinatJ1).getText();
            gameData.getField(coordinatI1, coordinatJ1)
                    .setText(gameData.getField(coordinatI2, coordinatJ2).getText());
            gameData.getField(coordinatI2, coordinatJ2).setText(press1);

            if(gameData.getField(coordinatI1, coordinatJ1).getText().equals("?")){
                gameData.getField(coordinatI1, coordinatJ1).setBackground(Color.white);
                gameData.getField(coordinatI2, coordinatJ2).setBackground(Color.green);
            }
            if(gameData.getField(coordinatI2, coordinatJ2).getText().equals("?")){
                gameData.getField(coordinatI2, coordinatJ2).setBackground(Color.white);
                gameData.getField(coordinatI1, coordinatJ1).setBackground(Color.green);
            }
        }
    }

    public static boolean allowChanging(){
        // УГЛЫ
//        if((coordinatI1 == 0 && coordinatJ1 == 0) && ((coordinatI2 == 0 && coordinatJ2 == 1) || (coordinatI2 == 1 && coordinatJ2 == 0))){
//            return true;
//        }
//        if((coordinatI1 == gameData.getLevel() - 1 && coordinatJ1 == gameData.getLevel() - 1) && ((coordinatI2 == gameData.getLevel() - 2 && coordinatJ2 == gameData.getLevel() - 1 || (coordinatI2 == gameData.getLevel() - 1  && coordinatJ2 == gameData.getLevel() - 2)))){
//            return true;
//        }
//        if((coordinatI1 == gameData.getLevel() - 1 && coordinatJ1 == 0)  && ((coordinatI2 == gameData.getLevel() - 2 && coordinatJ2 == 0) || (coordinatI2 == gameData.getLevel() - 1 && coordinatJ2 == 1))){
//            return true;
//        }
//        if((coordinatI1 == 0 && coordinatJ1 == gameData.getLevel() - 1) && ((coordinatI2 == 0 && coordinatJ2 == gameData.getLevel() - 2 || (coordinatI2 == 1  && coordinatJ2 == gameData.getLevel() - 1)))){
//            return true;
//        }
//
//        // центр
//        for(int ii = 1; ii < gameData.getLevel() - 1; ii++){
//            for(int jj = 1; jj < gameData.getLevel() - 1; jj++){
//                if((Math.abs(coordinatI1 - coordinatI2) + Math.abs(coordinatJ1 - coordinatJ2)) == 1){
//                    // кресты
//                    if((coordinatI2 == ii - 1) && (coordinatJ2 == jj)){
//                        return true;
//                    }
//                    if( (coordinatI2 == ii + 1) && (coordinatJ2 == jj)){
//                        return true;
//                    }
//                    if( (coordinatI2 == ii) && (coordinatJ2 == jj + 1)){
//                        return true;
//                    }
//                    if( (coordinatI2 == ii) && (coordinatJ2 == jj - 1)){
//                        return true;
//                    }
//                }
//            }
//        }
//
//        // lines
//        for(int ii = 1; ii < gameData.getLevel()-1; ii++){
//            if(coordinatJ1 != 0 && coordinatJ1 != gameData.getLevel() - 1 && coordinatI1 == 0){
//                if((Math.abs(coordinatI1 - coordinatI2) + Math.abs(coordinatJ1 - coordinatJ2)) == 1){
//                    return true;
//                }
//            }
//        }

        int counter = 0;
        if(gameData.getField(coordinatI1, coordinatJ1).getText().equals("?")){
            counter++;
        }
        if(gameData.getField(coordinatI2, coordinatJ2).getText().equals("?")){
            counter++;
        }
        if(((Math.abs(coordinatI1 - coordinatI2) + Math.abs(coordinatJ1 - coordinatJ2)) == 1) && counter == 1){
            return true;
        }

        return false;
    }
}

// прохождение
// https://cepia.ru/pyatnashki