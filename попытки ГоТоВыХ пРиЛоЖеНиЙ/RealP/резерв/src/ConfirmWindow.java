import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ConfirmWindow {
    static boolean answer;

    static Image image;

    static {
        try {
            image = new Image(new FileInputStream("styles\\style3.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static ImageView imageView = new ImageView(image);
    static String forImage;

    public static void getImage(String img){
        forImage = img;
    }

    public static boolean display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);  // нельзя юзать другие окна
        window.setTitle(title);

        Label label = new Label(message);
        label.setFont(Font.font(20)); // разиер шрифта
        label.setStyle(" -fx-text-fill: #FFD700; " +
                        " -fx-font-size: 28;");

        if(forImage.toCharArray()[forImage.length() - 1] == 'g'){  // заполняем переданной картинкой только в случае если там прописан коорректный адрес
           if(forImage.toCharArray()[forImage.length() - 5] == '7'){  //  были проблемы при запуске без смены стиля
               label.setStyle(" -fx-text-fill: #708090; " +
                                " -fx-font-size: 28;");
           }
            Image image = null;
            try {
                image = new Image(new FileInputStream(forImage));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imageView = new ImageView(image);
        }

        Button yesButton = new Button("Да");
        yesButton.setPrefSize(100, 30);
        Button noButton = new Button("Нет");
        noButton.setPrefSize(100, 30);
        yesButton.setOnAction(e ->
                {
                    answer = true;
                    window.close();
                }
        );
        noButton.setOnAction(e ->
                {
                    answer = false;
                    window.close();
                }
        );

        yesButton.setStyle("    -fx-border-width: 2.5;" +
                "    -fx-border-color:#708090;" +
                "    -fx-font-size: 22;" +
                "    -fx-text-fill: #000000;" +
                "    -fx-font-family: \"Monotype Corsiva\" ;"
        );
        noButton.setStyle("    -fx-border-width: 2.5;" +
                "    -fx-border-color: #708090;" +
                "    -fx-font-size: 22;" +
                "    -fx-text-fill: #B22222;" +
                "    -fx-font-family: \"Monotype Corsiva\" ;"
        );

        VBox layout = new VBox(3);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);  //ыровнять по центру

        BorderPane borderPane = new BorderPane();
        borderPane.getChildren().addAll(imageView);
        borderPane.setCenter(layout);

        Scene scene = new Scene(borderPane, 270, 160);
        window.setScene(scene);
        window.showAndWait();  // ждать доработку в другом классе
        window.setResizable(false);

        return answer;
    }
}