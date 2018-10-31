import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JPanel{
    public void paintComponent(Graphics g){  // метод для рисования(именно такое названия)
        this.setBackground(Color.WHITE);

        g.setColor(Color.GREEN);
        g.drawLine(10, 20, 100, 50);

        g.setColor(Color.BLUE);
        g.drawRect(10, 50, 100, 50);

        g.setColor(Color.RED);
        g.fillOval(10, 90, 100, 50);

        g.setColor(Color.MAGENTA);
        g.fill3DRect(10, 150, 100, 50, true);

        g.setColor(Color.ORANGE);
        for(int i = 100; i <350; i+=7){
            g.drawLine(50, i, i, 50);
        }
    }
}
