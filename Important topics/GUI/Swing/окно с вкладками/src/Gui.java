import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui{
    public void addComponents(Container pane){
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel tab1 = new JPanel(){
            public Dimension getSize(){
                Dimension size = super.getSize();
                size.width += 100;
                return size;
            }
        };

        tab1.add(new JButton("кнопка1"));
        tab1.add(new JButton("кнопка2"));
        tab1.add(new JButton("кнопка3"));

        JPanel tab2 = new JPanel();
        tab2.add(new JTextField("Any text"));

        tabbedPane.addTab("Вкладка с кнопками", tab1);
        tabbedPane.addTab("Вкладка с текстом", tab2);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }
}
