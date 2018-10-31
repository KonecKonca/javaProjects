import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame{
    private JButton left;
    private JButton center;
    private JButton right;
    private FlowLayout layout;
    private Container container;

    public Gui(){
        super("Разметка");
        layout = new FlowLayout();
        container = getContentPane(); // тут вся площадь рабочего окна(getContentPane())
        setLayout(layout);

        left = new JButton("левая");
        add(left);
        left.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        layout.setAlignment(FlowLayout.LEFT); // все двигаем влево
                        layout.layoutContainer(container); // для каких объектов(для всех)
                    }
                }
        );

        center = new JButton("центральная");
        add(center);
        center.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        layout.setAlignment(FlowLayout.CENTER); // все двигаем влево
                        layout.layoutContainer(container); // для каких объектов(для всех)
                    }
                }
        );

        right = new JButton("Правая");
        add(right);
        right.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        layout.setAlignment(FlowLayout.RIGHT); // все двигаем влево
                        layout.layoutContainer(container); // для каких объектов(для всех)
                    }
                }
        );
    }
}
