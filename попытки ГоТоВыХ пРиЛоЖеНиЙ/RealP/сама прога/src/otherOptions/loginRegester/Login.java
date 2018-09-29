package otherOptions.loginRegester;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import otherOptions.PatternForWindows;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login extends PatternForWindows{

    public void start(){
        Stage window = new Stage();
        window.setTitle("Авторизация");
        window.initModality(Modality.APPLICATION_MODAL);  // нельзя юзать другие окна
        window.setResizable(false);

        Button login = new Button("Войти на свой аккаунт");
        Button allLogins = new Button("Посмотреть все логины");
        TextField forLogin = new TextField();
        PasswordField forPassword = new PasswordField();
        Label info = new Label("Строка состояния");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(7);
        gridPane.setVgap(7);
        GridPane.setConstraints(login, 0, 0);
        GridPane.setConstraints(forLogin, 1, 0);
        GridPane.setConstraints(forPassword, 2, 0);
        GridPane.setConstraints(allLogins, 0, 1);
        GridPane.setConstraints(info, 1, 1);
        gridPane.getChildren().addAll(login, forLogin, forPassword, allLogins, info);

        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().addAll(imageView);
        borderPane.setCenter(gridPane);

        allLogins.setOnAction(e -> {
            try{
                forAllLogins(allLogins);
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Ошибка файла");
            }
        });

        login.setOnAction(e -> {
            try {
                boolean result = searchAccount(forLogin, forPassword);
                if(!result){
                    JOptionPane.showMessageDialog(null, "Данные введены неверно");
                }
                else{
                    data.setLogin(forLogin.getText());
                    data.setPassword(forPassword.getText());
                    menu.setText("\t\t\tВы зашли под ником:  " + data.getLogin() + "\t\t");
                    window.close();
                    window.close();
                }
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Scene scene = new Scene(borderPane, 450, 57);
        window.setScene(scene);
        window.show();
    }

    private void forAllLogins(Button allLogins)throws Exception{
        FileInputStream in = new FileInputStream(new File("dataForAccounts\\headerAcc.txt"));
        Scanner vvod = new Scanner(in);

        List<String> logins = new ArrayList<>();
        while(vvod.hasNext()){
            logins.add(vvod.next());
            vvod.next();
        }
        in.close();
        vvod.close();

        String output = "";
        int localCount = 0;
        for(int i =0; i < logins.size(); i++){
            localCount++;
            if(localCount == 7){
                localCount = 0;
                output+= (i+1) + ") " + logins.get(i) + "\n";
            }
            else {
                output+= (i+1) + ") " + logins.get(i) + "\t\t\t    ";
            }
            if(i > 200){
                break;
            }
        }
        JOptionPane.showMessageDialog(null, output);
    }
    private boolean searchAccount(TextField forLogin, PasswordField forPassword) throws Exception {
        FileInputStream in = new FileInputStream(new File("dataForAccounts\\headerAcc.txt"));
        Scanner vvod = new Scanner(in);

        List<String> logins = new ArrayList<>();
        List<String> passwords = new ArrayList<>();
        while(vvod.hasNext()){
            logins.add(vvod.next());
            passwords.add(vvod.next());
        }
        in.close(); // по сути не имеет смысла(т.к оба раза будет закрываться один и тот же файл)
        vvod.close();

        if(cheakComplience(forLogin, logins, forPassword, passwords)){
            return true;
        }
        return false;
    }

    private boolean cheakComplience(TextField forLogin, List<String> logins, PasswordField forPassword, List<String> passwords){
        for(int i = 0; i < logins.size(); i++){
            if(logins.get(i).equals(forLogin.getText()) && passwords.get(i).equals(forPassword.getText())){
                return true;
            }
        }
        return false;
    }
}