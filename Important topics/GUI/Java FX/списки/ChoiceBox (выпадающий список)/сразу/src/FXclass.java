import com.sun.javafx.scene.control.skin.ChoiceBoxSkin;
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

    public static void main(String[] args) {
        launch(args);
        ;
    }
    /// КАК СПРАВКА -----> TREVIEW вложенный выпадающий список
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ChoiceBox");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("По умолчанию", "Форест", "Джокер", "1", "2", "3");
        //choiceBox.getSelectionModel().select(0);  //  по умолчанрю выбран этот элеиент
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)
                -> System.out.println("Было: " + oldValue + "\tСтало: " + newValue));
        // (v, oldValue, newValue) са список, старое значение, новое значение (это часть лямбды)

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20, 20, 20));
        layout.getChildren().addAll(choiceBox);

        Scene scene = new Scene(layout, 350, 200);
        window.setScene(scene);
        window.show();
    }

    private void getChoise(ChoiceBox<String> choiceBox){
        String element = choiceBox.getValue();
        System.out.println("Был выбран " + element);
    }
}



































