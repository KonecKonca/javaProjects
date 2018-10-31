import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JPanel{
    public void paintComponent(Graphics g){  // метод для рисования(именно такое названия)
        super.paintComponents(g);  // мудак не пояснил(обязательно для ичспользования)
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLUE);
        g.fillRect(25, 25, 100, 20);
        g.setColor(new Color(234, 120, 137));  // задать свой цвет
        g.fillRect(25,65,100,20);
        g.setColor(Color.MAGENTA);
        g.drawString("Any text", 95, 120);
    }
}
