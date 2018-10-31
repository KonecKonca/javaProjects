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
    Button button;

    public static void main(String[] args) {
        launch(args);
        ;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Окно для подтверждения");
        window.setOnCloseRequest(e -> {  // метод отвечаюший за крестик
            e.consume();  //  значит setOnCloseRequest - не должен закрывать программу (типо мв с этим сами разберёмся)
            closeProgram();
        });  // обработка крестика закрытия

        Button button = new Button("Закрыть");
        button.setPrefSize(120, 60);
        button.setOnAction(e -> closeProgram());
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram(){
        boolean answer = ConfirmWindow.display("Окно подтверждения", "сохранить и выйти");
        if(answer){
            System.out.println("Всё ок");
            window.close();
        }
    }
}

