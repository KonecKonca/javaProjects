package lib;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClickListener implements ActionListener {
    private int[][] numbers;
    private SystemLogic logic;

    ClickListener(SystemLogic logic) {
        this.logic = logic;
        this.numbers = logic.getNumbers();
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setVisible(false);
        String name = button.getText();
        change(Integer.parseInt(name));
    }
    private void change(int num) {
        int i = 0, j = 0;
        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < 4; l++) {
                if (numbers[k][l] == num) {
                    i = k;
                    j = l;
                }
            }
        }
        if (i > 0) {
            if (numbers[i - 1][j] == 0) {
                numbers[i - 1][j] = num;
                numbers[i][j] = 0;
            }
        }
        if (i < 3) {
            if (numbers[i + 1][j] == 0) {
                numbers[i + 1][j] = num;
                numbers[i][j] = 0;
            }
        }
        if (j > 0) {
            if (numbers[i][j - 1] == 0) {
                numbers[i][j - 1] = num;
                numbers[i][j] = 0;
            }
        }
        if (j < 3) {
            if (numbers[i][j + 1] == 0) {
                numbers[i][j + 1] = num;
                numbers[i][j] = 0;
            }
        }

        logic.repaintField();

        if (logic.checkWin()) {
            JOptionPane.showMessageDialog(null, "YOU WIN!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            logic.generate();
            logic.repaintField();
        }
    }

}