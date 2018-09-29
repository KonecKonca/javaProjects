import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.JFrame;

public class Servak{
    public static void main(String[] args) {
        Servakk iServer = new Servakk();
        iServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iServer.startServer();
    }
}