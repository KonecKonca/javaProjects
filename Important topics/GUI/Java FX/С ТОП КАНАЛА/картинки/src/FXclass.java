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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;


public class FXclass extends Application{
    Stage window;
    Scene scene;

    private static final int HEIGHT = 500;
    private static final int WIDTH = 800;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Any Title");

        Image image = new Image(new FileInputStream("1.jpg"));  // также можно передать URL
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(HEIGHT);
        imageView.setFitWidth(WIDTH);

        Button button1 = new Button("Any button1");
        Button button2 = new Button("Any button2");

        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().addAll(imageView);

        HBox topMenu = new HBox(15);
        topMenu.getChildren().addAll(button1, button2);
        topMenu.setAlignment(Pos.TOP_CENTER);
        borderPane.setCenter(topMenu);


        primaryStage.setMaxHeight(HEIGHT);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setMaxWidth(WIDTH);
        primaryStage.setMinWidth(WIDTH);
        scene = new Scene(borderPane,WIDTH, HEIGHT);
        window.setScene(scene);
        window.show();
    }

}
