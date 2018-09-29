import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.layout.StackPane;
        import javafx.stage.Stage;

public class FXclass extends Application implements EventHandler<ActionEvent>{  // интерфейс -- для обраб событий
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Первое FX-окно");
        StackPane layot = new StackPane();
        button = new Button("Кнопка");
        button.setOnAction(this);
        layot.getChildren().add(button);
        Scene scene = new Scene(layot, 300, 300);  // место действия
        primaryStage.setScene(scene);  // выорка места действия
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == button){
            System.out.println("etgsrdfs");
        }
    }
}
