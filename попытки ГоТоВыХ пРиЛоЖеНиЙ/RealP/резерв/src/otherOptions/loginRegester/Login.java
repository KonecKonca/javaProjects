package otherOptions.loginRegester;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import otherOptions.PatternForWindows;

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

        login.setOnAction(e -> {
            window.close();
        });

        Scene scene = new Scene(borderPane, 450, 57);
        window.setScene(scene);
        window.show();
    }
}