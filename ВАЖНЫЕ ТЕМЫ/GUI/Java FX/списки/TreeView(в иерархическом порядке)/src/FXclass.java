import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Observable;

public class FXclass extends Application{
    Stage window;
    Scene scene;
    Button button;
    TreeView<String> treeView;

    public static void main(String[] args) {
        launch(args);
        ;
    }
    // в отличии от чоиза можно вводить свои!!!!
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TreeView");

        // КОРЕНЬ
        TreeItem<String> root, movie, cartoon;
        root = new TreeItem<>();
        root.setExpanded(true);  // вложенность

        //ФИЛЬМЫ
        movie = addChild("Кинофильмы", root);  // добавка данных
        addChild("Инттерстелар", movie);
        addChild("Форест", movie);
        addChild("ХУЙ", movie);
        addChild("Эйс Вентура", movie);

        // МУЛЬТ
        cartoon = addChild("Мультфильмы", root);  // добавка данных
        addChild("Симсоны", cartoon);
        addChild("Хуимсоны", cartoon);
        addChild("Валии", cartoon);
        addChild("Ну, погоди!", cartoon);

        //саmо дерево
        treeView = new TreeView<>(root);  // в параметрах указывем корневой элемент
        treeView.setShowRoot(false);  //  не показывать название(вкладку корня) root(он у нас просто контейнер)
        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if(newValue != null){
                System.out.println(newValue.getValue());
            }
        });

        button = new Button("Выбрать");

        StackPane layout = new StackPane();
        layout.setPadding(new Insets(20,20, 20, 20));
        layout.getChildren().add(treeView);

        Scene scene = new Scene(layout, 350, 200);
        window.setScene(scene);
        window.show();
    }

    private TreeItem<String> addChild(String title, TreeItem<String> parent){
        TreeItem<String> treeItem = new TreeItem<String>(title);  // создание нового объекта с переданнымназванием
        treeItem.setExpanded(true); // элемент будет развёрнутым
        parent.getChildren().add(treeItem);
        return treeItem;
    }
}

