import com.sun.org.apache.xpath.internal.SourceTree;
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
import java.util.Scanner;

import useMnojestvo.*;
public class MainClass extends Application {
    private Stage window;
    private Scene scene;
    private Scene sceneDopOperates;

    private Mnojestvo mnojestvo1 = new Mnojestvo();
    private Mnojestvo mnojestvo2 = new Mnojestvo();
    private Mnojestvo resultMnoj = new Mnojestvo();

    private Label textleft1;
    private Label textLeft2;
    private Label textRight1;
    private Label textRight2;
    private Label soderjanie1;
    private Label soderjanie2;
    private Label info;
    private Label textOperations;
    private Label resText;
    private Label resOperation;

    private TextField inputLeft;
    private TextField inputRight;

    private Button vvod1;
    private Button vvod2;
    private Button del1;
    private Button del2;
    private Button defoultvvod;
    private Button znachByExpression;

    private Button[] operations = new Button[5];
    private Button dopOperations;
    private Button CleanMn;

    private Button mnojByExpression;
    private Label textForExpression[] = new Label[3];
    private Label dopInfo;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private Button vozvrat;
    private Button fromFail;

    int width = 585;
    int heigth = 320;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("Операции над множествами");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(12);
        scene = new Scene(gridPane, width, heigth - 10);

        //ЛЕВЫЙ СТОЛБЕЦ
        textleft1 = new Label("Добавить в 1-ое множество");
        GridPane.setConstraints(textleft1, 0, 0);
        textLeft2 = new Label("1-ое множество");
        GridPane.setConstraints(textLeft2, 0, 2);
        info = new Label("строка состояния . . . ");
        GridPane.setConstraints(info, 0, 7);
        soderjanie1 = new Label("  .  .  . ");
        GridPane.setConstraints(soderjanie1, 0, 3);
        inputLeft = new TextField();
        GridPane.setConstraints(inputLeft, 0, 1);
        vvod1 = new Button("Ввести элемент в 1-ое мн-во");
        GridPane.setConstraints(vvod1, 0, 5);
        vvod1.setOnAction(e -> isNumber(inputLeft, 1));
        del1 = new Button(" Удалить элем. из 1-го мн-ва ");
        GridPane.setConstraints(del1, 0, 6);
        del1.setOnAction(e -> del(inputLeft, mnojestvo1, soderjanie1));

        //ПРАВЫЙ СТОЛБЕЦ
        textRight1 = new Label("Добавить в 2-ое множество");
        GridPane.setConstraints(textRight1, 1, 0);
        textRight2 = new Label("2-ое множество");
        GridPane.setConstraints(textRight2, 1, 2);
        soderjanie2 = new Label("  .  .  .  ");
        GridPane.setConstraints(soderjanie2, 1, 3);
        inputRight = new TextField();
        GridPane.setConstraints(inputRight, 1, 1);
        vvod2 = new Button("Ввести элемент во 2-ое мн-во");
        GridPane.setConstraints(vvod2, 1, 5);
        vvod2.setOnAction(e -> isNumber(inputRight, 2));
        del2 = new Button("  Удалить элем. из 2-го мн-ва  ");
        GridPane.setConstraints(del2, 1, 6);
        del2.setOnAction(e -> del(inputRight, mnojestvo2, soderjanie2));

        // ДРУГИЕ СПОСОБЫ ВВОДА
        defoultvvod = new Button("     Значения по умолчанию    ");
        GridPane.setConstraints(defoultvvod, 1, 7);
        defoultvvod.setOnAction(e -> defoultZnach());
        znachByExpression = new Button("Задать мн-ва выраж-ем");
        GridPane.setConstraints(znachByExpression, 3, 7);
        // ДОП СЦЕНА
        GridPane gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(10, 10, 10, 10));
        gridPane2.setVgap(10);
        gridPane2.setHgap(12);
        Scene dopScene = new Scene(gridPane2,width/1.5 - 40, heigth/2 - 15);
        textForExpression[0] = new Label("№1: 0 2 4 6 8 . . .");
        GridPane.setConstraints(textForExpression[0], 0, 0);
        textForExpression[1] = new Label("№2: 1 3 5 7 9 . . .");
        GridPane.setConstraints(textForExpression[1], 1, 0);
        textForExpression[2] = new Label("№3: 5 10 15 20 . . .");
        GridPane.setConstraints(textForExpression[2], 2, 0);
        /////////////////
        checkBox1 = new CheckBox("Для 1-го мн-ва");
        GridPane.setConstraints(checkBox1, 0, 2);
        checkBox2 = new CheckBox("Для 2-го мн-ва");
        GridPane.setConstraints(checkBox2, 1, 2);
        mnojByExpression = new Button("Применить");
        GridPane.setConstraints(mnojByExpression, 1, 3);
        RadioButton radioButton[] = new RadioButton[3];
        radioButton[0] = new RadioButton(" 1 ");
        GridPane.setConstraints(radioButton[0], 0, 1);
        radioButton[1] = new RadioButton(" 2 ");
        GridPane.setConstraints(radioButton[1], 1, 1);
        radioButton[2] = new RadioButton(" 3 ");
        GridPane.setConstraints(radioButton[2], 2, 1);
        dopInfo = new Label("Строка состояния ");
        GridPane.setConstraints(dopInfo, 0, 4);
        vozvrat = new Button("Возврат");
        GridPane.setConstraints(vozvrat, 2, 3);
        vozvrat.setOnAction(e -> window.setScene(scene));
        //ДЛЯ ФАЙЛОВОГО ВВОДА
        fromFail = new Button("Из файла");
        GridPane.setConstraints(fromFail, 0, 3);
        fromFail.setOnAction(e -> dataFromFail());
        //////////////
        mnojByExpression.setOnAction(e -> {
            setByExpression(checkBox1, checkBox2, radioButton[0], radioButton[1], radioButton[2]);
        });
        gridPane2.getChildren().addAll(textForExpression[0], textForExpression[1], textForExpression[2],
                mnojByExpression, checkBox1, checkBox2, radioButton[0], radioButton[1], radioButton[2],
                dopInfo, vozvrat, fromFail);
        znachByExpression.setOnAction(e -> window.setScene(dopScene));

        // ДОПОЛНИТЕЛЬНЫЙ ОПЕРАЦИИ
        GridPane gridPane3 = new GridPane();
        gridPane3.setPadding(new Insets(10, 10, 10, 10));
        gridPane3.setVgap(10);
        gridPane3.setHgap(12);
        CleanMn = new Button(" Очистить оба множества ");
        gridPane3.setConstraints(CleanMn, 0, 0);
        CleanMn.setOnAction(e ->{
            window.setScene(scene);
            mnojestvo1 = new Mnojestvo();
            mnojestvo2 = new Mnojestvo();
            showMnoj(mnojestvo1, soderjanie1);
            showMnoj(mnojestvo2, soderjanie2);
            resOperation.setText(" .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        });
        sceneDopOperates = new Scene(gridPane3, width, heigth - 10);

        gridPane3.getChildren().addAll(CleanMn);

        // ОПЕРАЦИИ
        textOperations = new Label("Операции над множествами");
        GridPane.setConstraints(textOperations, 3, 0);
        resText = new Label("Результат операций - - - - - ->");
        GridPane.setConstraints(resText, 0, 4);
        resOperation = new Label(" .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        GridPane.setConstraints(resOperation, 1, 4);
        operations[0] = new Button(" СИММЕТР. РАЗНОСТЬ ");
        operations[1] = new Button("       ОБЪЕДИНЕНИЕ      ");
        operations[2] = new Button("        ПЕРЕСЕЧЕНИЕ       ");
        operations[3] = new Button("    РАЗНОСТЬ для 1-го  ");
        operations[4] = new Button("    РАЗНОСТЬ для 2-го  ");
        GridPane.setConstraints(operations[0], 3, 1);
        GridPane.setConstraints(operations[1], 3, 2);
        GridPane.setConstraints(operations[2], 3, 3);
        GridPane.setConstraints(operations[3], 3, 4);
        GridPane.setConstraints(operations[4], 3, 5);
        operations[0].setOnAction(e ->{
            resultMnoj = mnojestvo1.simmetrichajaRaznost(mnojestvo2);
            showResalt();
        } );
        operations[1].setOnAction(e ->{
            resultMnoj = mnojestvo1.objedinenie(mnojestvo2);
            showResalt();
        });
        operations[2].setOnAction(e ->{
            resultMnoj = mnojestvo1.searchOdinakov(mnojestvo1, mnojestvo2);
            showResalt();
        });
        operations[3].setOnAction(e ->{
            resultMnoj = mnojestvo1.raznost(mnojestvo2);
            showResalt();
        });
        operations[4].setOnAction(e ->{
            resultMnoj = mnojestvo2.raznost(mnojestvo1);
            showResalt();
        });
        dopOperations = new Button("     Другие операции    ");
        GridPane.setConstraints(dopOperations, 3, 6);
        dopOperations.setOnAction(e -> window.setScene(sceneDopOperates));

        //ОБЩЕЕ ДЛЯ СЦЕНЫ
        gridPane.getChildren().addAll(textleft1, textLeft2, textRight1, textRight2, soderjanie1,
                soderjanie2, info, inputLeft, inputRight, vvod1, vvod2, textOperations, resText,
                resOperation, operations[0], operations[1], operations[2], operations[3],
                operations[4], del1, del2, defoultvvod, znachByExpression, dopOperations);
        window.setScene(scene);
        window.show();
    }

    private void isNumber(TextField textField, int nomber){
        try {
            int nom = Integer.parseInt(textField.getText());
            if(nomber == 1){
                mnojestvo1.add(nom);
                showMnoj(mnojestvo1, soderjanie1);
                info.setText("1-ое мн-во ---> " + nom);
            }
            if(nomber == 2){
                mnojestvo2.add(nom);
                showMnoj(mnojestvo2, soderjanie2);
                info.setText("2-ое мн-во ---> " + nom);
            }
        }
        catch (NumberFormatException ex){
            info.setText("Вы вводите ерунду");
        }
    }

    private void showMnoj(Mnojestvo mnojestvo, Label soderjanie){
        mnojestvo.cheakcomplience();
        mnojestvo.sort();
        String str = "";
        int count = 0;
        for(int i = 0; i < mnojestvo.getArraylenth(); i++){
            str += mnojestvo.getArrayEl(i) + ", ";
            count++;
            if(count == 7){
                str += "\n";
                count = 0;
            }
        }
        soderjanie.setText(str);
    }

    private void showResalt(){
        resultMnoj.sort();
        String str = "";
        byte count = 0;
        for(int i = 0; i < resultMnoj.getArraylenth(); i++){
            str += resultMnoj.getArrayEl(i) + ", ";
            count++;
            if(count == 7){
                str += "\n";
            }
        }
        resOperation.setText(str);
    }

    private void del(TextField textField, Mnojestvo mnojestvo, Label label){
        try {
            int nom = Integer.parseInt(textField.getText());
            mnojestvo.delete(nom);
            showMnoj(mnojestvo, label);
            resOperation.setText(" .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        }
        catch (NumberFormatException ex){
            info.setText("Вы вводите ерунду");
        }
    }

    private void sort(){
        mnojestvo1.sort();
        mnojestvo2.sort();
    }

    private void defoultZnach(){
        Mnojestvo mn1 = new Mnojestvo();
        Mnojestvo mn2 = new Mnojestvo();
        for(int i = 3; i < 9; i++){
            mn1.add(i);
        }
        for(int i = 6; i< 13; i++){
            mn2.add(i);
        }
        mnojestvo1 = mn1;
        mnojestvo2 = mn2;
        showMnoj(mnojestvo1, soderjanie1);
        showMnoj(mnojestvo2, soderjanie2);
        resOperation.setText(" .   .   .   .   .   .   .   .   .   .   .   .   .   .");
    }

    private void setByExpression(CheckBox check1, CheckBox check2, RadioButton radioButton1, RadioButton radioButton2, RadioButton radioButton3){
        if(radioButton1.isSelected() && radioButton2.isSelected() && radioButton3.isSelected()){
            dopInfo.setText("Неверный выбор");
            return;
        }
        else if(radioButton1.isSelected() && radioButton2.isSelected()){
            dopInfo.setText("Неверный выбор");
            return;
        }
        else if(radioButton1.isSelected() && radioButton3.isSelected()){
            dopInfo.setText("Неверный выбор");
            return;
        }
        else if(radioButton2.isSelected() && radioButton3.isSelected()){
            dopInfo.setText("Неверный выбор");
            return;
        }
        else if((!check1.isSelected()) && (!check2.isSelected())){
            dopInfo.setText("Неверный выбор");
            return;
        }

        if(check1.isSelected()){
            expressionHandle(check1, radioButton1, radioButton2, radioButton3);
        }
        if(check2.isSelected()){
            expressionHandle(check2, radioButton1, radioButton2, radioButton3);
        }
    }

    private void expressionHandle(CheckBox checkBox, RadioButton radioButton1, RadioButton radioButton2, RadioButton radioButton3){
        Mnojestvo mnojestvo = new Mnojestvo();
        if(radioButton1.isSelected()){
            for(int i = 0; i <= 30; i+=2){
                mnojestvo.add(i);
            }
        }
        else if(radioButton2.isSelected()){
            for(int i = 1; i <= 30; i+=2){
                mnojestvo.add(i);
            }
        }
        else if(radioButton3.isSelected()){
            for(int i = 5; i <= 65; i+=5){
                mnojestvo.add(i);
            }
        }

        if(checkBox1 == checkBox){
            mnojestvo1 = mnojestvo;
            showMnoj(mnojestvo1, soderjanie1);
            resOperation.setText(" .   .   .   .   .   .   .   .   .   .   .   .   .   .");
            info.setText("Стандартное выражение мн-во 1");
            window.setScene(scene);
        }
        if(checkBox2 == checkBox){
            mnojestvo2 = mnojestvo;
            showMnoj(mnojestvo2, soderjanie2);
            resOperation.setText(" .   .   .   .   .   .   .   .   .   .   .   .   .   .");
            info.setText("Стандартное выражение мн-во 2");
            window.setScene(scene);
        }
    }

    private void dataFromFail(){
        Scanner reader1;
        Scanner reader2;
        Mnojestvo mn1 = new Mnojestvo();
        Mnojestvo mn2 = new Mnojestvo();
        try {
            reader1 = new Scanner(new FileInputStream("mnoj1.txt"));
            while(reader1.hasNext()){
                mn1.add(Integer.parseInt(reader1.next()));
            }
            reader2 = new Scanner(new FileInputStream("mnoj2.txt"));
            while(reader2.hasNext()){
                mn2.add(Integer.parseInt(reader2.next()));
            }
            mnojestvo1 = mn1;
            mnojestvo2 = mn2;
            showMnoj(mnojestvo1, soderjanie1);
            showMnoj(mnojestvo2, soderjanie2);
            dopInfo.setText("Данные взяты");
            reader1.close();
            reader2.close();
        }
        catch (Exception ex){
            dopInfo.setText("Пробл. с файлом");
            info.setText("Проблемы с файлом");
        }
    }
}
