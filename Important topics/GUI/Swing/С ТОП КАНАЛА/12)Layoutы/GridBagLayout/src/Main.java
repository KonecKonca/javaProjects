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
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);

        GridBagConstraints constraints1 = new GridBagConstraints();  // для конктретного позиционирования
        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridheight = 2;
        constraints1.gridwidth = 2;
        jPanel.add(new JTextArea(4, 20), constraints1);
        jPanel.revalidate();  // БЕЗ ЭТОГО ГОВНА МОЖЕТ НЕ ПРОРИСОВАТЬСЯ

        GridBagConstraints constraints2 = new GridBagConstraints();  // для конктретного позиционирования
        constraints2.weightx = 0;
        constraints2.weighty = 0;
        constraints2.gridx = 2;
        constraints2.gridy = 0;
        constraints2.gridheight = 1;
        constraints2.gridwidth = 2;
        jPanel.add(new JButton("submitwery long name"), constraints2);
        jPanel.revalidate();  // БЕЗ ЭТОГО ГОВНА МОЖЕТ НЕ ПРОРИСОВАТЬСЯ

        GridBagConstraints constraints3 = new GridBagConstraints();  // для конктретного позиционирования
        constraints3.weightx = 0;
        constraints3.weighty = 0;
        constraints3.gridx = 2;
        constraints3.gridy = 1;
        constraints3.gridheight = 1;
        constraints3.gridwidth = 1;
        jPanel.add(new JButton("submit"), constraints3);
        jPanel.revalidate();  // БЕЗ ЭТОГО ГОВНА МОЖЕТ НЕ ПРОРИСОВАТЬСЯ

        GridBagConstraints constraints4 = new GridBagConstraints();  // для конктретного позиционирования
        constraints4.weightx = 0;
        constraints4.weighty = 0;
        constraints4.gridx = 3;
        constraints4.gridy = 1;
        constraints4.gridheight = 1;
        constraints4.gridwidth = 1;
        jPanel.add(new JButton("submit"), constraints4);
        jPanel.revalidate();  // БЕЗ ЭТОГО ГОВНА МОЖЕТ НЕ ПРОРИСОВАТЬСЯ
    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }
}