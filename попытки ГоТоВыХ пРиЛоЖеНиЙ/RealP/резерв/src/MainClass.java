import com.sun.jndi.toolkit.url.Uri;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

//import java.awt.*;
import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.logging.Logger;

import otherOptions.*;
import otherOptions.loginRegester.Data;
import otherOptions.loginRegester.Login;
import otherOptions.loginRegester.Regester;

public class MainClass extends Application{
    private Stage window;
    private Scene mainScene;
    static final int MAINSIZEX = 450;
    static final int MAINSIZEY = 520;

    Data data = new Data();
    {
        data.setLogin("xxxXXX99-5~~~fd~");
    }

    private ImageView imageView;
    private String wayForImage[] = {"style3.jpg"};

    private BorderPane borderPane;
    private VBox centreMenu;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        intro();
    }

    private void intro(){
        BorderPane introBorderPane = new BorderPane();
        Scene forIntro = new Scene(introBorderPane, MAINSIZEX + 820, MAINSIZEY + 190);

        Media media1 = new Media(new File("игра.mp4").toURI().toString());
        MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        MediaView mediaView = new MediaView(mediaPlayer1);
        mediaPlayer1.play();
        introBorderPane.getChildren().addAll(mediaView);

        Stage stage = new Stage();
        stage.setScene(forIntro);
        stage.setResizable(false);
        stage.show();

        forIntro.setOnKeyPressed(e -> {
            MainMenu();
            stage.close();
            mediaPlayer1.stop();
        });
    }
    private void MainMenu(){
        window.setTitle("~ШкОлЯрОк~ШкОлЯрОк~ШкОлЯрОк~~ШкОлЯрОк~");
        window.setOnCloseRequest(e -> {
            e.consume(); // прога не закроется
            closeProgram();
        });

        MenuBar menuBar = new MenuBar();
        Menu chooseStyle = new Menu("Выбрать стиль");
        Menu name = new Menu("\t\t\tТы ещё не ввел свой пароль \t\t\t ");
        MenuItem login = new MenuItem("Уже есть аккаунт");
        MenuItem regestering = new MenuItem("Создать новый аккаунт");
        name.getItems().addAll(login, regestering);

        login.setOnAction(e -> {
            Login log = new Login();
            log.getImage("styles\\"  + "W" + wayForImage[0]);
            log.start();
        });
        regestering.setOnAction(e ->{
            Regester regester = new Regester();
            regester.setData(data);
            regester.getImage("styles\\"  + "W" + wayForImage[0]);
            regester.start();
            regester.setForMenu(name);
        });

        Button mainButtons[] = new Button[5];
        mainButtons[0] = new Button("Игра");
        mainButtons[0].setPrefSize(190, 65);
        mainButtons[0].setOnAction(e -> {
            if(data.getLogin().equals("xxxXXX99-5~~~fd~")){
                JOptionPane.showMessageDialog(null,"<html><h3><i>Зарегистрируйся," +
                        " или зайди на свой аккаунт<i><h3></html>");
            }
            else{
                // непосредственно сама игра
                name.setText("\t\t\tВы зашли под ником:  " + data.getLogin() + "\t\t");
            }
        });

        mainButtons[1] = new Button("Добавить тест");
        mainButtons[1].setPrefSize(190, 65);

        mainButtons[2] = new Button("Пройти тест");
        mainButtons[2].setPrefSize(190, 65);

        mainButtons[3] = new Button("О программе");
        mainButtons[3].setPrefSize(190, 65);

        mainButtons[4] = new Button("Выход");
        mainButtons[4].setPrefSize(190, 65);
        mainButtons[4].setOnAction(e -> closeProgram());

        setCSS(mainButtons, 25);

        menuBar.getMenus().addAll(chooseStyle, name);
        MenuItem[] styles = new MenuItem[7];
        for(int i = 0; i < 7; i++){
            styles[i] = new MenuItem((i+1) + " стиль");
            chooseStyle.getItems().addAll(styles[i]);
        }
        redrawMainScene(styles);  // полная перерисовка сцены с уже измененным фоном

        centreMenu = new VBox(18);  // отступ между кнопками
        centreMenu.setMargin(menuBar, new Insets(0, 0,45,0));  // выравнивание панели и кнопок на главной менюшке
        centreMenu.setMargin(mainButtons[4], new Insets(0, 0,45,0));
        centreMenu.getChildren().addAll(menuBar, mainButtons[0],mainButtons[1], mainButtons[2], mainButtons[3], mainButtons[4]);
        centreMenu.setAlignment(Pos.CENTER);

        borderPane = new BorderPane();
        try {
            setStyle();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        borderPane.getChildren().addAll(imageView);
        borderPane.setCenter(centreMenu);

        mainScene = new Scene(borderPane, MAINSIZEX - 10, MAINSIZEY - 10);
        window.setScene(mainScene);
        window.setResizable(false);
        window.show();
    }
    private void setStyle()throws FileNotFoundException{
        Image image = new Image(new FileInputStream("styles\\style3.jpg"));  // также можно передать URL
        imageView = new ImageView(image);
    }
    private void redrawMainScene(MenuItem[] styles){
        wayForImage[0] = new String();
        for(int i = 0; i < styles.length; i++){
            String str = "style" + (i + 1) + ".jpg";  /// "styles\\style1.jpg"

            styles[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        changeStyle("styles\\" + str);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    borderPane = new BorderPane();
                    borderPane.getChildren().addAll(imageView);
                    borderPane.setCenter(centreMenu);

                    mainScene = new Scene(borderPane, MAINSIZEX, MAINSIZEY);
                    window.setScene(mainScene);

                    wayForImage[0] =  str;
                }
            });
        }
    }
    private void changeStyle(String str)throws FileNotFoundException{
        Image image = new Image(new FileInputStream(str));
        imageView = new ImageView(image);
    }
    private void closeProgram(){
        if(wayForImage[0] != null ){
            ConfirmWindow.getImage("styles\\"  + "W" + wayForImage[0]);
        }
        boolean answer = ConfirmWindow.display("Окно подтверждения", "Выйти");
        if(answer){
            window.close();
        }
    }
    private void setCSS(Button[] buttons, int size){
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setStyle("    -fx-border-width: 2.5;" +
                                "    -fx-border-color: #708090;" +
                                "    -fx-font-size:" + size + ";" +
                                "    -fx-font-family: \"Monotype Corsiva\" ;"
            );
        }
    }
}
