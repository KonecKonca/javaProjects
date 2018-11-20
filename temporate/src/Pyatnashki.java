import lib.SystemLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Pyatnashki extends JFrame {
    private static JPanel panel = new JPanel(new GridLayout(4, 4, 2, 2));
    private static int[][] numbers = new int[4][4];
    private static SystemLogic logic = new SystemLogic(numbers, panel);

    public static void main(String[] args) {
        logic.generate();
        JFrame app = new Pyatnashki();
        app.setVisible(true);
    }

    private Pyatnashki() {
        setTitle("Пятнашки");
        setBounds(200, 200, 300, 300);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        panel.setDoubleBuffered(true);
        container.add(panel);

        logic.generate();
        logic.repaintField();
    }

}
