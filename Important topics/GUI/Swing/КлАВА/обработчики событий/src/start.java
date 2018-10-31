import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class start{
    public static void main(String[] args) throws Exception {
        Test test = new Test();
//        test.addEventListener(new MyEventListener() {
//            @Override
//            public void processEvent(MyEvent event) {
//                System.out.println("XXXXXXX");
//            }
//        });
//        test.addEventListener(e -> System.out.println("113132"));
//
//        test.notifyEventListeners(new MyEvent(test, MyEvent.Type.TYPE_2));

        MyKey myKey = new MyKey();
        myKey.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }
        });
    }
}




