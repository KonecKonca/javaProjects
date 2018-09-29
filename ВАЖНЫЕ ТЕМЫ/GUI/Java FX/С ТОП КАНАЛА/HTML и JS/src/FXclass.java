import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.concurrent.Worker;
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

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.loadContent("" +
                "<div id='div'> hello world</div>" +
                "<script>document.getElementById('div').style.color='blue';" +
                "function changeColor(){" +
                "   document.getElementById('div').style.color='green';" +
                // Вызов в js-ке джавовскоого метода
                "    document.getElementById('div').innerHTML = myClass.getHello('MAX');" +
                "}</script>" +
        "");

        JSObject jsObject = (JSObject) webEngine.executeScript("window");
        jsObject.setMember("myClass", new MyClass());

        // вызов js-ной ф-ции из джавы
        // чтоб фузвать скриптовую функцию (+ проверка загружени ли уже ф-ия)
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldvalue, newvalue) -> {
                if(newvalue == Worker.State.SUCCEEDED){
                    webEngine.executeScript("changeColor();");
                }
        });

        Group group = new Group();
        group.getChildren().addAll(webView);
        window.setScene(new Scene(group, 400, 300));
        window.show();
    }

    public class MyClass{
        public String getHello(String name){
            return "Hello " + name;
        }
    }
}
