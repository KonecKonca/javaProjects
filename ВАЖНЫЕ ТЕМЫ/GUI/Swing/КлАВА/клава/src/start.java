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

public class start extends JFrame{

    public static void main(String[] args) throws Exception {
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        JButton jButton = new JButton("dgfrfgr");
        jPanel.add(jButton);

        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();
        Robot robot = new Robot();
        robot.mouseMove(1000, 300);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    jButton.
                }
            }
        }).start();

//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//        Thread.sleep(5);
//        jFrame.setVisible(false);

        jButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.print(e.getKeyChar());
                try(FileWriter writer =  new FileWriter("result.txt", true)){   // append true чтоб не затиралось
                    writer.write(e.getKeyChar());
                }
                catch(IOException e1){
                    System.out.println("Dont write");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        jPanel.revalidate();
    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}




