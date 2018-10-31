import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Observable;

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
        window.setTitle("ListView");

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // возможность выбора нескольких пунктов

        button = new Button("Выбрать");
        button.setOnAction(e -> buttonCliked(listView));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20, 20, 20));
        layout.getChildren().addAll(listView, button);

        Scene scene = new Scene(layout, 350, 200);
        window.setScene(scene);
        window.show();
    }

    private void buttonCliked(ListView<String> listView){
        String str = "";
        ObservableList<String> perebor; // представлять как массив(общий тип всех списков)
        perebor = listView.getSelectionModel().getSelectedItems(); // заполнение выбранными элементами
        for(String message : perebor){
            str += message + "\n";
        }
        System.out.println(str);
    }
}

