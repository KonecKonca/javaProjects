import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.layout.StackPane;
        import javafx.stage.Stage;

public class FXclass extends Application{
    private Button button1;
    private Button button2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Первое FX-окно");
        StackPane layot = new StackPane();
        button1 = new Button("-1-            \n\n\n\n");
        button1.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Обработка анонимом)");
                    }
                }
        );
        button2 = new Button("-2-");
        button2.setOnAction(e -> {
                    System.out.println("Ебись в рот, ЭТО ЛЯМБДА!!!!");
                    System.out.println("так можно несколько команд");
                    }
        );
        layot.getChildren().add(button1);
        layot.getChildren().add(button2);
        Scene scene = new Scene(layot, 300, 300);  // место действия
        primaryStage.setScene(scene);  // выорка места действия
        primaryStage.show();
    }

}
