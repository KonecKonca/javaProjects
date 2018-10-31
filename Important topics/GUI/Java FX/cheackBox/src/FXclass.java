import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
        import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("CheakBox");

        CheckBox box1 = new CheckBox("Выбор1");
        CheckBox box2 = new CheckBox("Выбор2");
        CheckBox box3 = new CheckBox("Выбор3");
        CheckBox box4 = new CheckBox("Выбор4");
        box1.setSelected(true); // выбран по умолчанию

        button = new Button("Голосовать");
        button.setOnAction(e -> handleOption(box1, box2, box3, box4));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20, 20, 20));
        layout.getChildren().addAll(button, box1, box2, box3, box4);

        Scene scene = new Scene(layout, 350, 200);
        window.setScene(scene);
        window.show();
    }

    private void handleOption(CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4){
        String message = "Вы проголосовали за\n";
        if(box1.isSelected()){
            message+= "№1\n";
        }
        if(box2.isSelected()){
            message+= "№2\n";
        }
        if(box3.isSelected()){
            message+= "№3\n";
        }
        if(box4.isSelected()){
            message+= "№4\n";
        }
        System.out.println(message);
    }
}

