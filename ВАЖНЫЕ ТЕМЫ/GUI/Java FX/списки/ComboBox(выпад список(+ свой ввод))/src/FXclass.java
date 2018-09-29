import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FXclass extends Application{
    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
        ;
    }
    // в отличии от чоиза можно вводить свои!!!!
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ChoiseBox");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("1", "2", "3");
        comboBox.setPromptText("Проголосуй за кого-нить");  // подпись
        //comboBox.setEditable(true);  // можно вводить свою информацию
        comboBox.setOnAction(e -> System.out.println("Вы выбрали через список " + comboBox.getValue())); // выбор без нажатия кнопки

        button = new Button("Выбрать");
        button.setOnAction(e -> System.out.println("Вы выбрали " + comboBox.getValue()));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20, 20, 20));
        layout.getChildren().addAll(comboBox, button);

        Scene scene = new Scene(layout, 350, 200);
        window.setScene(scene);
        window.show();
    }

}

