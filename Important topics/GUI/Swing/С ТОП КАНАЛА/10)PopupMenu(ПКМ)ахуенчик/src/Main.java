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
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);

        JLabel label = new JLabel("");
        jPanel.add(label);

        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem firstAction = new JMenuItem("first action");
        JMenuItem secondAction = new JMenuItem("second action");
        firstAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("text " + Math.random()*100);
            }
        });
        secondAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("xyi " + Math.random()*100);
            }
        });
        jPopupMenu.add(firstAction);
        jPopupMenu.add(secondAction);
        jPanel.setComponentPopupMenu(jPopupMenu);
    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }
}