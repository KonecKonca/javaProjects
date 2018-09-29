import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
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
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.applet.Applet;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;


public class FXclass extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Media media = new Media(new File("11.mp3").toURI().toString());  // работало , но не более 11-12 секунд (в jar стало работать всё!!!!)
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setAutoPlay(true);
//        mediaPlayer.play(); // у плеера есть методы с которыми можно поиграться

//        FileInputStream fis = new FileInputStream("11.mp3");
//        Player playMP3 = new Player(fis);
//        playMP3.play(300); // сколько мс(хотя хз в каких единицах) играть

        OtherThread otherThread = new OtherThread();
        Thread other = new Thread(otherThread);
        other.start();

        //проигрыш видео
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!///////////////
        //   топовая штука в видео можно музыку запихнуть(с этим жарка работает)
        Media media1 = new Media(new File("запипик.mp4").toURI().toString());  // работало , но не более 11-12 секунд
        MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        mediaPlayer1.setAutoPlay(true);
        MediaView mediaView = new MediaView(mediaPlayer1);
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!///////////////


        Group group = new Group();
        group.getChildren().addAll(mediaView);
        primaryStage.setScene(new Scene(group, 1000, 700));
        primaryStage.show();
    }

    class OtherThread implements Runnable{
        @Override
        public void run(){
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Media media = new Media(new File("11.mp3").toURI().toString());  // работало , но не более 11-12 секунд (в jar стало работать всё!!!!)
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.play(); // у плеера есть методы с которыми можно поиграться
        }
    }
}
