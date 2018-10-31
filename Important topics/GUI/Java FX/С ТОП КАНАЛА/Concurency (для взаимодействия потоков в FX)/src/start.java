/**
 * Created by Андрей on 31.12.2017.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;

public class start extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MyService myService = new MyService();

        // вызовется при успешном завершении  работы потока
        myService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t){
                System.out.println("done: " + t.getSource().getValue());
            }
        });

        myService.start();

        Group root = new Group();
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }


    /// многопоточное приложение для FX
    static class MyService extends Service<String> {
        @Override
        protected Task<String> createTask(){
            return new Task<String>() {
                @Override
                protected String call() throws Exception {
                    return "Hello world";
                }
            };
        }
    }
}
