package view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Authorization;
import model.URLHolder;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class LoginController {
    @FXML
    private AnchorPane loginLayout;
    @FXML
    private TextField login;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorFirst;
    @FXML
    private Label errorSecond;


    @FXML
    public void handleRegistrationButtonClick(){
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout,400.0, 280.0);

        Stage newWindow = new Stage();
        newWindow.setScene(scene);
        newWindow.show();

        FXMLLoader loader = new FXMLLoader(URLHolder.registrationViewURL);
        try {
            AnchorPane view=loader.load();
            layout.getChildren().add(view);
          //  RegistrationController controller=loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleLoginButtonClick(){
       /* if(!new Authorization().auth(login.getText(), passwordField.getText())) {
            errorFirst.setText("Неверное имя пользователя");
            errorSecond.setText("или пароль!");
        } else{*/
            Stage stage = (Stage) loginLayout.getScene().getWindow();
            showProcessView();
            stage.close();
       // }
    }

    private void showProcessView() {

     /*   VBox rootLayout=null;
        FXMLLoader loader = new FXMLLoader(URLHolder.rootLayoutURL);
        try{
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout, 900.0, 630.0);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FXMLLoader l = new FXMLLoader(URLHolder.reportLayoutURL);
        try {
           AnchorPane view =  l.load();
            //  ProcessesController controller = loader.getController();
            rootLayout.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        VBox rootLayout=null;
        FXMLLoader loader = new FXMLLoader(URLHolder.rootLayoutURL);
        try{
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout, 900.0, 630.0);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FXMLLoader l = new FXMLLoader(URLHolder.processViewURL);
        try {
            HBox view =  l.load();
          //  ProcessesController controller = loader.getController();
            rootLayout.getChildren().add(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
