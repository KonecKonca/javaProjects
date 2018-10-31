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


public class Main{
    static JFrame jFrame = getFrame();

    public static void main(String[] args) throws Exception {
        JPanel jPanel = new JPanel(new BorderLayout());
        jFrame.add(jPanel, BorderLayout.NORTH);

        //// По дефолту юзатся FlowLayout
        jPanel.add(new JButton("one"), BorderLayout.WEST);
        jPanel.add(new JButton("two"), BorderLayout.EAST);
        jPanel.add(new JButton("three"), BorderLayout.CENTER);

        JPanel panel2 = new JPanel(new BorderLayout());
        jFrame.add(panel2, BorderLayout.EAST);
        panel2.add(new JButton("four"), BorderLayout.NORTH);
        panel2.add(new JButton("five"), BorderLayout.SOUTH);
        panel2.add(new JButton("six"), BorderLayout.CENTER);

        JFrame newFrame = getFrame();
        newFrame.setLayout(new GridLayout(3, 3));
        newFrame.add(new JButton("A"), 0, 0);
        newFrame.add(new JButton("B"),1,1);
        newFrame.add(new JButton("C"),2, 2);
        newFrame.add(new JButton("D"),0,1);
    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }
}