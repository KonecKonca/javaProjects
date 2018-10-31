import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
        import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FXclass extends Application{
    Stage window;

    public static void main(String[] args) {
        launch(args);
        ;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Окно с разметкой");
        GridPane gridPane = new GridPane(); // сама разметка
        gridPane.setPadding(new Insets(10,10,10,10)); // отступы в ячейке
        gridPane.setVgap(10);//отоступы между разными полями
        gridPane.setHgap(12);

        Label nameLabel = new Label("Имя пользователя");
        GridPane.setConstraints(nameLabel, 0, 0); // раpмещ по координатам (типо как в табличке)

        TextField nameInput = new TextField("Введи имя");
        GridPane.setConstraints(nameInput,1,0);

        Label passLabel = new Label("Пароль");
        GridPane.setConstraints(passLabel, 0, 1);

        TextField passInput = new TextField();
        passInput.setText("Пароль");
        GridPane.setConstraints(passInput , 1, 1);

        Button loginButtom = new Button("Войти");
        GridPane.setConstraints(loginButtom, 1, 2);

        gridPane.getChildren().addAll(nameInput, nameLabel, passInput, passLabel, loginButtom);

        Scene scene = new Scene(gridPane, 350, 200);
        window.setScene(scene);
        window.show();
    }

}

