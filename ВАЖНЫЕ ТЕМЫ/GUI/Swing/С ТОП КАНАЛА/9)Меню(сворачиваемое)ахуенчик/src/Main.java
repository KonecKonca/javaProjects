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
        JMenuBar jMenuBar = new JMenuBar();// основа меню

        JMenu meny1 = new JMenu("meny1");
        JMenu meny2 = new JMenu("meny2");
        jMenuBar.add(meny1);
        jMenuBar.add(meny2);

        meny1.add(new JMenuItem("1 operations"));  // добавка элементов в меню
        JMenuItem pole = new JMenuItem("2 operations");
        pole.setEnabled(false);  // сделать не активной
        meny1.add(pole);
        meny1.addSeparator();  // полоска между выбором
        meny1.add(new JMenuItem("3 operations"));

        meny2.add(new JMenuItem("11 operations"));
        JMenuItem exit = new JMenuItem("exit");
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));  // по сочетанию клавиш !!!!
        meny2.add(exit);
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);   // выход по нажатию
            }
        });

        JMenu vlojMenu = new JMenu("Options");
        vlojMenu.add(new JMenuItem("1 option"));
        vlojMenu.add(new JMenuItem("2 option"));
        meny1.add(vlojMenu);

        JLabel label = new JLabel("");
        jFrame.add(label);
        JMenu forCheckBoxes = new JMenu("cheakBox");
        JMenuItem displayText = new JMenuItem("Display any xren");
        displayText.setAccelerator(KeyStroke.getKeyStroke("ctrl M"));
        displayText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Text " + Math.random()*100);
            }
        });
        forCheckBoxes.add(displayText);
        jMenuBar.add(forCheckBoxes);


        forCheckBoxes.add(new JCheckBoxMenuItem("cheakBox"));
//        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem("Radio1");
        JRadioButtonMenuItem radioButtonMenuItem2 = new JRadioButtonMenuItem("Radio2");
//        buttonGroup.add(radioButtonMenuItem);
//        buttonGroup.add(radioButtonMenuItem2);
        forCheckBoxes.add(radioButtonMenuItem);
        forCheckBoxes.add(radioButtonMenuItem2);

        jFrame.setJMenuBar(jMenuBar);
        jFrame.revalidate();  // прорисовка элементов
}

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }
}