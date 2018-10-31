package otherOptions.loginRegester;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import otherOptions.PatternForWindows;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Regester extends PatternForWindows {

    private Data data = null;
    public void setData(Data data){
         this.data = data;
    }
    private Menu menu;
    public void setForMenu(Menu menu){
        this.menu = menu;
    }

    public void start(){
        Stage window = new Stage();
        window.setTitle("Регистрация");
        window.initModality(Modality.APPLICATION_MODAL);  // нельзя юзать другие окна
        window.setResizable(false);

        Button registr = new Button("Зарегистрироваться");
        TextField forLogin = new TextField("Логин");
        forLogin.setBackground(Background.EMPTY);
        PasswordField forPassword = new PasswordField();
        forPassword.setBackground(Background.EMPTY);

        VBox vBox = new VBox(3);
        vBox.getChildren().addAll(registr, forLogin, forPassword);
        vBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().addAll(imageView);
        borderPane.setCenter(vBox);

        registr.setOnAction(e -> {
            try {
                boolean result = registration(forLogin, forPassword);
                if(!result){
                    JOptionPane.showMessageDialog(null, "Такой логин уже занят, или пароль не был введён");
                }
                else{
                    data.setLogin(forLogin.getText());
                    data.setPassword(forPassword.getText());
                    menu.setText("\t\t\tВы зашли под ником:  " + data.getLogin() + "\t\t");
                    window.close();
                }
            }
            catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Во время регистрации произошла ошибка");
            }
        });


        Scene scene = new Scene(borderPane, 200, 110);
        window.setScene(scene);
        window.show();
    }

    public boolean registration(TextField forLogin, PasswordField forPassword) throws IOException {
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

        if(!cheakComplience(forLogin, logins, forPassword)){
            FileWriter out = new FileWriter("dataForAccounts\\headerAcc.txt");

            logins.add(forLogin.getText());
            passwords.add(forPassword.getText());
            for(int i = 0; i < logins.size(); i++){
                out.write( logins.get(i) + " " + passwords.get(i) + "\n");
                out.flush();
            }

            out.close();
        }
        else {
            return false;
        }

        return true;
    }
    public boolean cheakComplience(TextField forLogin, List<String> logins, PasswordField forPassword){
        if((forLogin.getText().equals("")) || (forPassword.getText().equals(""))){
            return true;
        }

        for(int i = 0; i < logins.size(); i++){
            if(logins.get(i).equals(forLogin.getText())){
                return true;
            }
        }
        return false;
    }

}
