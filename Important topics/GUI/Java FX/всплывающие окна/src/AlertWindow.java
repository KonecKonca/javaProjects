import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertWindow {
    public static void display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);  // нельзя юзать другие окна
        window.setTitle(title);
        window.setMaxWidth(350);
        window.setMinHeight(200);  // мин параметры размеров

        Label label = new Label(message);
        label.setFont(Font.font(20)); // разиер шрифта

        Button closeButton = new Button("закрыть");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);  //ыровнять по центру
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
}
