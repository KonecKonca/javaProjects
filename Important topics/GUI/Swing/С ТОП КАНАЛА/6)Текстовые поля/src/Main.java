import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.EventHandler;
import java.net.URL;
import java.util.concurrent.Exchanger;

// Можно будет юзать в всплывающих меню
public class Main{
    public static void main(String[] args) throws Exception{
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.add(new JLabel("<html><h1><i>This is<br>label</i></h1></html>"));
        jPanel.add(new JTextField("text", 10));
        jPanel.add(new JPasswordField(10));
        JTextArea jTextArea = new JTextArea(5,20);
        jTextArea.setLineWrap(true);  // переход на новую строку, а не расширение рамки
        JScrollPane jScrollPane = new JScrollPane(jTextArea);  // добавка прокрутки
        jPanel.add(jScrollPane);
        jPanel.revalidate();  // перерисовка объектов (проверка правильного расположения)
}

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }
}