import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
        import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;

public class FXclass extends Application{
    Stage window;
    Scene scene;

    public static void main(String[] args) {
        launch(args);
        ;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Any Title");
        Group group = new Group();
        scene = new Scene(group, 800, 600);
        BorderPane root = new BorderPane();

        // подключение конструктора
        Parent content = FXMLLoader.load(getClass().getResource("constryctor.fxml"));
        root.setCenter(content); // закидываем в свою разметку

        group.getChildren().add(root);  // добавляем на сцену уже свою разметку

        window.setScene(scene);
        window.show();
    }
}

