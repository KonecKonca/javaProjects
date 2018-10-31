import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.StackPane;
        import javafx.scene.layout.VBox;
        import javafx.stage.Stage;

public class FXclass extends Application{
    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage; // теперь главная сцена доступна через window
        Label label1 = new Label("Вы в первой сцене");
        Button button1 = new Button("Перейти ко 2-ой сцене");
        button1.setOnAction(e -> window.setScene(scene2));  // выбор 2-ой сцены
        VBox layout1 = new VBox(20);   // разметка (расстояние по вертикали 20 px)
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 300, 300);

        Label label2 = new Label("Вы во 2-ой сцене");
        Button button2 = new Button("перейти к 1-ой сцене");
        button2.setOnAction(e -> window.setScene(scene1));
        HBox layot2 = new HBox(20);   // горизонтальная разметка
        layot2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layot2, 300, 300);

        window.setScene(scene1);
        window.setTitle("Много сцен");
        window.show();
    }
}
