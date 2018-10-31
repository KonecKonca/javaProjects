import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import javax.swing.*;

public class start{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing and FX together");

        frame.add(FX());

        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /// создание фх сцены
    private static JFXPanel FX(){
        JFXPanel jfxPanel = new JFXPanel();

        Group group = new Group();
        group.getChildren().addAll(new Button("Button"));
        Scene scene = new Scene(group, Color.ALICEBLUE);

        jfxPanel.setScene(scene);
        return jfxPanel;
    }
}
