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

public class ConfirmWindow {
    static boolean answer;

    public static boolean display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);  // нельзя юзать другие окна
        window.setTitle(title);
        window.setMaxWidth(350);
        window.setMinHeight(200);  // мин параметры размеров

        Label label = new Label(message);
        label.setFont(Font.font(20)); // разиер шрифта

        Button yesButton = new Button("Да");
        Button noButton = new Button("Нет");
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

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);  //ыровнять по центру
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();  // ждать доработку в другом классе

        return answer;
    }
}
