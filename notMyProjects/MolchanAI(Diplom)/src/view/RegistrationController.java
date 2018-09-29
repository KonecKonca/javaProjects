package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Authorization;
import model.Registration;

import java.awt.*;

public class RegistrationController {
    private Registration registration;
    @FXML
    private TextField loginField;
    @FXML
    private  TextField passwordField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private Label errorFirst;
    @FXML
    private Label errorSecond;
    @FXML
    private Label loginRule;
    @FXML
    private Label passwordRule;
    @FXML
    private Label namesRule;
    @FXML
    private AnchorPane layout;

    @FXML
    public void initialize(){
        registration=new Registration();
        loginRule.setText(
                "(не менее "+registration.getMinLoginLength()+
                " и не более "+registration.getMaxLoginLength()+" символов)");
        passwordRule.setText(
                "(не менее "+registration.getMinPasswordLength()+
                        " и не более "+registration.getMaxPasswordLength()+" символов)");
        namesRule.setText("(только символы алфавита)");
    }

    public void handleRegisterButtonClick(){
        String login=loginField.getText();
        String password=passwordField.getText();
        String name=nameField.getText();
        String surname=surnameField.getText();
        if(!registration.isLoginCorrect(login)){
            errorFirst.setText("Логин уже существует или содержит неправильное");
            errorSecond.setText("количество символов!");
        }
        else if(!registration.isPasswordCorrect(password))
            errorFirst.setText("Пароль содержит неправильное количество символов!");
        else if(!registration.isNameCorrect(name,surname))
            errorFirst.setText("Имя или фамилия состоят из неправильных символов!");
        else {
            registration.register(login,password,name,surname);
            handleCancelButtonClick();
        }
    }
    public void handleCancelButtonClick(){
      Stage stage = (Stage)layout.getScene().getWindow();
      stage.close();
    }

}
