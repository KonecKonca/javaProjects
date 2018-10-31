import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.border.Border;
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

        JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25); // ласт число - значение по умолчанию
        jPanel.add(jSlider);
        jSlider.setMinorTickSpacing(10);  //  маленькие деления
        jSlider.setMajorTickSpacing(20);  // большие деления
        jSlider.setPaintTicks(true);   // отрисовать разметку
        jSlider.setSnapToTicks(true);  // выбирать строка по разметке(нельзя по середине остановиться// )
        jSlider.setPaintLabels(true);  // подписи на главной разметке
}

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }
}