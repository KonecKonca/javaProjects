package lib;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SystemLogic {
    private JPanel panel;
    private int[][] numbers;
    private ClickListener listener;

    public SystemLogic(int[][] numbers, JPanel panel) {
        this.numbers = numbers;
        this.panel = panel;
        listener = new ClickListener(this);
    }

    public void repaintField() {
        panel.removeAll();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton button = new JButton(Integer.toString(numbers[i][j]));
                button.setFocusable(false);
                panel.add(button);
                if (numbers[i][j] == 0) {
                    button.setVisible(false);
                } else
                    button.addActionListener(listener);
            }
        }

        panel.validate();
        panel.repaint();
    }
    public void generate() {
        Random generator = new Random();
//        int[] invariants = new int[16];
        int count=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                numbers[i][j] = 0;
//                invariants[i * 4 + j] = 0;
            }
        }

        for (int i = 1; i < 16; i++) {
            int k, l;
            do {
                count++;
                k = generator.nextInt(4);
                l = generator.nextInt(4);
            }
            while (numbers[k][l] != 0);
            numbers[k][l] = i;
//            invariants[k * 4 + l] = i;
        }
        System.out.println(count);
    }
    boolean checkWin() {
        boolean status = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j > 2)
                    break;
                if (numbers[i][j] != i * 4 + j + 1) {
                    status = false;
                }
            }
        }
        return status;
    }

    int[][] getNumbers() {
        return numbers;
    }

}
