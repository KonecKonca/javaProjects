import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame{
        private JButton button;
        private Color color = (Color.WHITE);
        private  JPanel panel;

        public Gui(){
            super("Выбор цветов");
            panel = new JPanel();
            panel.setBackground(color);
            button = new JButton("Для выбора цвета");
            button.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            color = JColorChooser.showDialog(null, "выбери цвет", color); // вызов окна выбора цвета
                            if(color == null){
                                color = (Color.WHITE);
                            }
                            panel.setBackground(color);
                        }
                    }
            );
            add(panel, BorderLayout.CENTER);
            add(button, BorderLayout.SOUTH);
            setSize(400, 150);
            setVisible(true);
        }

}
