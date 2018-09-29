import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import useMnojestva.*;

import javax.swing.*;

public class MainClass extends Application{
    private Stage window;
    private Scene scene;

    private Button first, resFirst;
    private Button second, resSecond;
    private Button resetFirst, resetSecond;

    private Mnojestvo mnojestvo1 = new Mnojestvo();
    private Mnojestvo mnojestvo2 = new Mnojestvo();
    private Mnojestvo resultMnoj = new Mnojestvo();

    int levelVloj = 0;
    boolean helpinfo = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Разность множеств");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15, 15, 15, 15));
        gridPane.setVgap(10);
        gridPane.setHgap(12);

        first = new Button(" Ввести 1-ое мн-во ");
        GridPane.setConstraints(first, 0, 0);
        first.setOnAction(e ->{
                    System.out.println("Все элементы 1-го множества");
                    helpMnojestvoHow(mnojestvo1);
                    showMnojPodmnoj(mnojestvo1);
                    System.out.println();
                    levelVloj = 0;
                }
        );

        second = new Button(" Ввести 2-ое мн-во ");
        GridPane.setConstraints(second, 1, 0);
        second.setOnAction(e ->{
                    System.out.println("Все элементы 2-го множества");
                    helpMnojestvoHow(mnojestvo2);
                    showMnojPodmnoj(mnojestvo2);
                    System.out.println();
                    levelVloj = 0;
                }
        );

        resFirst = new Button("Разность 1-го мн-ва");
        GridPane.setConstraints(resFirst, 0, 1);
        resFirst.setOnAction(e ->{
            resultMnoj = mnojestvo1.raznost(mnojestvo2);
            System.out.println("\nРазность 1-го множества");
            showMnojPodmnoj(resultMnoj);
            System.out.println();
        });


        resSecond = new Button("Разность 2-го мн-ва");
        GridPane.setConstraints(resSecond, 1, 1);
        resSecond.setOnAction(e ->{
            resultMnoj = mnojestvo2.raznost(mnojestvo1);
            System.out.println("\nРазность 2-го множества");
            showMnojPodmnoj(resultMnoj);
            System.out.println();
        });

        resetFirst = new Button("Очистить 1-ое мн-во");
        GridPane.setConstraints(resetFirst, 0, 2);
        resetFirst.setOnAction(e ->{
            System.out.println("1-ое множество очищено");
            mnojestvo1 = new Mnojestvo();
            System.out.println();
        });

        resetSecond = new Button("Очистить 2-ое мн-во");
        GridPane.setConstraints(resetSecond, 1, 2);
        resetSecond.setOnAction(e ->{
            System.out.println("2-ое множество очищено");
            mnojestvo2 = new Mnojestvo();
            System.out.println();
        });

        gridPane.getChildren().addAll(first, second, resFirst, resSecond, resetFirst, resetSecond);
        scene = new Scene(gridPane, 295, 123);
        window.setScene(scene);
        window.show();
    }

    private void helpMnojestvoHow(Mnojestvo mnojestvo){
        if(!helpinfo){
            JOptionPane.showMessageDialog(null, "Вводите по 1-му элементу мн-ва ------ Если элемент является мн-вом - вводите (mn)" +
                    "Если вводите кортеж - вводите (k) ------ Если ввод подмн-ва окончен введите - (end)", "Ввод данных", JOptionPane.PLAIN_MESSAGE);
            helpinfo = true;
        }
        String vvod;
        String message = "Уровень вложенности :";
        while(true){
            try {
                vvod = JOptionPane.showInputDialog(message + levelVloj);
                if(vvod.toLowerCase().equals("end")){
                    levelVloj--;
                    break;
                }
                else if(vvod.toLowerCase().equals("mn")){
                    Mnojestvo mn = new Mnojestvo();
                    levelVloj++;
                    helpMnojestvoHow(mn);
                    mnojestvo.addMnojestvo(mn);
                }
                if(vvod.toLowerCase().equals("k")){
                    Kortej kortej = new Kortej();
                    levelVloj++;
                    helpMnojestvoHow(kortej);
                    mnojestvo.addKortej(kortej);
                }
                else{
                    try {
                        mnojestvo.addDannie(Integer.parseInt(vvod));
                    }
                    catch (Exception ex){
                        //JOptionPane.showMessageDialog(null, "Вы ввели ерунду", "Ошибка ввода", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
            catch (Exception ex){}
        }
    }

    private void showMnojPodmnoj(Mnojestvo mnojestvo){
        showMnojForVloj(mnojestvo);
        for(int i = 0; i < mnojestvo.getLengthVlojMnoj(); i++){
            System.out.print(" {");
            showMnojPodmnoj(mnojestvo.geElementVlojMnoj(i));
            System.out.print("}");
        }
        for(int i = 0; i < mnojestvo.getLengthVlojkortej(); i++){
            System.out.print(" <");
            showMnojPodmnoj(mnojestvo.geElementVlojKortej(i));
            System.out.print(">");
        }
    }

    private void showMnojForVloj(Mnojestvo mnojestvo){
        String str = "";
        for(int i = 0; i < mnojestvo.getLengthDannie(); i++){
            str +=  " " + mnojestvo.geElementDannie(i);
        }
        System.out.print(str + " ");
    }

}

