import com.sun.javafx.scene.control.skin.FXVK;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Observable;

public class FXclass extends Application{
    Stage window;
    Scene scene;
    TableView<Dannie> table;  // общая таблица

    public static void main(String[] args) {
        launch(args);
        ;
    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TableView");

        // колонка (имя автора)
        TableColumn<Dannie, String> nameColumn = new TableColumn<>();
        nameColumn.setText("Автор");
        nameColumn.setMaxWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("autorName"));

        // колонка (название книги)
        TableColumn<Dannie, String> titleColumn = new TableColumn<>();
        titleColumn.setText("Книга");
        titleColumn.setMaxWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("workTitle"));

        // колонка (Цена)
        TableColumn<Dannie, String> priceColumn = new TableColumn<>();
        priceColumn.setText("Цена");
        priceColumn.setMaxWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // добавим колонки в таблицу
        table = new TableView<>();
        table.setItems(getBook());
        table.getColumns().addAll(nameColumn, titleColumn, priceColumn);

        VBox layout = new VBox();
        layout.getChildren().addAll(table);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public ObservableList<Dannie> getBook(){
        ObservableList<Dannie> books = FXCollections.observableArrayList();
        books.add(new Dannie("Лукьяненко", "Черновик", 200));
        books.add(new Dannie("Хренов", "Дядя Стёпа", 464));
        books.add(new Dannie("Пушкин", "Каштанка", 3075));
        books.add(new Dannie("Лермонтов", "Трах-бабах", 350));
        books.add(new Dannie("Есенин", "Отцы и дети", 220));
        books.add(new Dannie("Гоголь", "МУ-му", 50));
        return books;
    }
}

