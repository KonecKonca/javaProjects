import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.omg.PortableInterceptor.SUCCESSFUL;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;


public class FXclass extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("Any Title");

        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
                new PieChart.Data("grapefruit", 13),
                new PieChart.Data("Aple", 53),
                new PieChart.Data("Pear", 34));

        PieChart chart = new PieChart(data);
        chart.setTitle("It is my CHart");

        Group group = new Group();
        group.getChildren().addAll(chart);
        window.setScene(new Scene(group, 500, 400));
        window.show();
    }

}
