import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
        import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

        HBox topMenu = new HBox(5);
        Button button1 = new Button("Файл");
        Button button2 = new Button("Вид");
        Button button3 = new Button("Правка");
        topMenu.getChildren().addAll(button1, button2, button3);
        topMenu.setAlignment(Pos.CENTER); // верхнее по центру

        HBox bottomMenu = new HBox(5);
        Button button10 = new Button("Закрыть");
        bottomMenu.getChildren().add(button10);
        bottomMenu.setAlignment(Pos.CENTER);
        bottomMenu.setStyle("-fx-background-color: #c0eef3");  // коды и из CSS покраска

        VBox leftMenu = new VBox(5);
        Button button4 = new Button("Скопировать");
        Button button5 = new Button("Вырезать");
        Button button6 = new Button("Вставить");
        leftMenu.getChildren().addAll(button4, button5, button6);
        leftMenu.setAlignment(Pos.CENTER_LEFT);  // слева по центрру(смещая кнопки влево)

        VBox rightMenu = new VBox(5);
        Button button7 = new Button("Покрасить");
        Button button8 = new Button("Залить");
        Button button9 = new Button("Отменить");
        rightMenu.getChildren().addAll(button7, button8, button9);
        rightMenu.setAlignment(Pos.CENTER_RIGHT); // по анологии

        BorderPane borderPane = new BorderPane();  // вместо стакпаэна
        borderPane.setTop(topMenu);
        borderPane.setBottom(bottomMenu);
        borderPane.setRight(rightMenu);
        borderPane.setLeft(leftMenu);


        Scene scene = new Scene(borderPane, 400, 300);
        window.setScene(scene);
        window.show();
    }

}

