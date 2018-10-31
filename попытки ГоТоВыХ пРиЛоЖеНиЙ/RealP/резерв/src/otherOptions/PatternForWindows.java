package otherOptions;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PatternForWindows {
    static Image image;

    static {
        try {
            image = new Image(new FileInputStream("styles\\style3.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static ImageView imageView = new ImageView(image);
    static String forImage;

    public void getImage(String img){
        forImage = img;

        if(forImage.toCharArray()[forImage.length() - 1] == 'g'){  // заполняем переданной картинкой только в случае если там прописан коорректный адрес
            Image image = null;
            try {
                image = new Image(new FileInputStream(forImage));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imageView = new ImageView(image);
        }

    }

    public void create(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        VBox layout = new VBox(3);
        layout.getChildren().addAll(imageView);
        layout.setAlignment(Pos.CENTER);  //ыровнять по центру

        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().addAll(imageView);
        borderPane.setCenter(layout);

        Scene scene = new Scene(borderPane, 270, 160);
        window.setScene(scene);
        window.showAndWait();  // ждать доработку в другом классе
        window.setResizable(false);
    }
}
