import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame{
    private JPanel mousepanel;
    private JLabel statusbar;

    public Gui(){
        super("Мышка");
        mousepanel = new JPanel();
        mousepanel.setBackground(Color.WHITE);
        add(mousepanel, BorderLayout.CENTER);  // белая панель на всё окно(без неё дествия с мышкой не отслеживаются)
        statusbar = new JLabel("Строка состояния");  // вернее JPanel просто упрощает работу с мышкой
        add(statusbar, BorderLayout.SOUTH);

        Obrabotchik obrabotka = new Obrabotchik();
        mousepanel.addMouseListener(obrabotka);  // прослушиватель неподжижной мышки
        mousepanel.addMouseMotionListener(obrabotka); // подвижной

    }

    private class Obrabotchik implements MouseListener, MouseMotionListener{
        public void mouseClicked(MouseEvent event){  // нажал на мышку
            statusbar.setText(String.format("Ты нажалу тут %d, %d", event.getX(), event.getY()));
        }

        public void mousePressed(MouseEvent event){  // нажаты и удерживается
            statusbar.setText("Ты нажал кнопку мыши");
        }

        public void mouseReleased(MouseEvent event){   // отпустил мышь после удержания
            statusbar.setText("Ты отпустил кнопку мыши");
        }

        public void mouseEntered(MouseEvent event){  // завел в окно
            statusbar.setText("Ты завел мышь в окно");
            mousepanel.setBackground(Color.YELLOW);
        }

        public void mouseExited(MouseEvent event){  // вывел из зоны онка
            statusbar.setText("Ты убрал мышь из окна");
            mousepanel.setBackground(Color.WHITE);
        }

        public void mouseDragged(MouseEvent event){  // тыскать нажатую мышь
            statusbar.setText("Ты таскаешь мышь");
        }

        public void mouseMoved(MouseEvent event){
            statusbar.setText("Ты двигаешь мышкой");
        }
    }
}
