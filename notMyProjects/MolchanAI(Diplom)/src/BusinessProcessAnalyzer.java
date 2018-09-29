import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.URLHolder;

import model.db.DBHelper;
import view.LoginController;

import view.ProcessesController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BusinessProcessAnalyzer extends Application  {

    private Stage stage;
    private VBox rootLayout;

    @FXML
    private AnchorPane processTabLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Business Processes Analyzer");
        setViewUrls();
        /*IMainView view= new IMainView() {
            @Override
            public void showMainView(Stage stage) {

            }
        };*/
        showLoginView();
    }

   private void showLoginView() {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 250.0, 200.0);

        stage.setOnCloseRequest(e -> Platform.exit());
        stage.setScene(scene);
        stage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/LoginView.fxml"));
        try {
            AnchorPane loginView = loader.load();
            layout.getChildren().add(loginView);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setViewUrls(){
        URLHolder.registrationViewURL=getClass().getResource("view/RegistrationView.fxml");
        URLHolder.processViewURL = getClass().getResource("view/ProcessesView.fxml");
        URLHolder.processEditorURL=getClass().getResource("view/ProcessEditingView.fxml");
        URLHolder.processDetailsURL=getClass().getResource("view/ProcessDetailsView.fxml");
        URLHolder.rootLayoutURL=getClass().getResource("view/RootLayout.fxml");
        URLHolder.reportLayoutURL=getClass().getResource("view/ReportsView.fxml");
    }


    public static void main(String[] args) {
        launch(args);
    }

}
