import com.sun.javafx.charts.ChartLayoutAnimator;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.EventHandler;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;
import java.util.concurrent.Exchanger;


public class Main{
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        JButton jButton = new JButton("show file dialog");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                int i = fileChooser.showDialog(jPanel, "save as");
                System.out.println(i);

                File file = fileChooser.getSelectedFile();
                System.out.println(file.getName());
            }
        });
        jPanel.revalidate();

//        jButton.addActionListener(e -> {
//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setMultiSelectionEnabled(true);  // выюорка несколько файлов одновременно
//            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  // выборка только файлов
//            fileChooser.setFileFilter(new FileFilter() {
//                @Override
//                public boolean accept(File f) {
//                    if(f.getName().endsWith("gif")){  // отображение только гифок
//                        return true;
//                    }
//                    return false;
//                }
//
//                @Override
//                public String getDescription() {
//                    return "ONlY GIF";
//                }
//
//            });


//            TextField textField = new TextField("2424424", 1);
//            fileChooser.add(textField, BorderLayout.SOUTH);  //добавить свой объект
//
//            fileChooser.addPropertyChangeListener(new PropertyChangeListener() {
//                @Override
//                public void propertyChange(PropertyChangeEvent evt) {
//                    textField.setText(evt.getNewValue().toString());
//                }
//            });


            //fileChooser.showDialog(jPanel, "New Text");  Перепсать кнопку(её имя)
     //   });

    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }
}