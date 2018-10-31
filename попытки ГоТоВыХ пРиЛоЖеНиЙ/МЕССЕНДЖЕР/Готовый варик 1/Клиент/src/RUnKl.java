import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JFrame;

public class RUnKl {
    public static void main(String[] args) {
        Klien client = new Klien("192.168.100.2");  // 192.168.100.2 айпиха моего компа
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.startClient();
    }
}
