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
        JButton button = new JButton("button");
        button.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);  // вывод в консоле дебага
        jPanel.add(button);

        RepaintManager.currentManager(jFrame.getRootPane()).setDoubleBufferingEnabled(false);
        ((JComponent)jFrame.getContentPane()).setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);  // замедленная прорисовка
    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }
}

// ctrl + shift + f1 -- вывод в консоль инфы(при запущенной проге)

// не тодлько свинги
// alt + f8 --- писать выражения, юзая значения переменных на текущий момент
// f8 --- шаг с заходом
// пкь по точке останова --- настройки дебага