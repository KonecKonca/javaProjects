import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.EventHandler;
import java.net.URL;
import java.util.concurrent.Exchanger;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        //String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); // список фриштов
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JButton jButton = new JButton("Button");
        jPanel.add(jButton);

        jButton.addActionListener(EventHandler.create(ActionListener.class, jFrame, "title", "source.text"));  // некое сокращение, вместо анонимного класса
        // онли, если код нужно выполнтть 1 просту операцию
    }

    static  JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setTitle("Any text");
        Toolkit toolkit = Toolkit.getDefaultToolkit();  // своего рода помощь в работе
        Dimension dimension = toolkit.getScreenSize();  // получили размер экрана
        jFrame.setBounds(dimension.width/2 - 250, dimension.height/2 - 150, 500, 300);  // альтернатива 2-ум предыдущим Норм если не занем с каким разрешением работаем
        return jFrame;
    }
}