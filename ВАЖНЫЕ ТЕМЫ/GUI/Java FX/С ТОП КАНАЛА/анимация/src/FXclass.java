import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
        import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;


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

        Image image = new Image(new FileInputStream("1.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(HEIGHT);
        imageView.setFitWidth(WIDTH);

        fade(imageView);  // исчезновение

        Group root = new Group();
        root.getChildren().addAll(imageView);
        scene = new Scene(root, WIDTH, HEIGHT);
        window.setScene(scene);
        window.show();
    }

    private static void fade(ImageView imageView){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1500), imageView);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(Timeline.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
    }
}
