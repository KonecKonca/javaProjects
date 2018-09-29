/**
 * Created by Андрей on 04.01.2018.
 */
import java.awt.FlowLayout;  // для разметки окна
import java.awt.event.ActionListener; // для прослушивани событий
import java.awt.event.ActionEvent;// для обработки, прослушанных сообщений
import javax.swing.JFrame;   //для работы с окнами
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class Gui extends JFrame {
    private JTextField pole1;
    private JTextField pole2;
    private JTextField pole3;
    private JPasswordField pass;

    public Gui(){
        super("Наш заголовок");
        setLayout(new FlowLayout());
        pole1 = new JTextField(10); // длинна 10 символов
        add(pole1);
        pole2 = new JTextField("Тут может быть твой текст");
        add(pole2);
        pole3 = new JTextField("Нельзя  изменять", 20); // неизмен поле, длинна 20
        pole3.setEditable(false);
        add(pole3);
        pass = new JPasswordField("Тут пароль"); // будут просто точки
        add(pass);

        Obrabotchik obrabotka = new Obrabotchik();
        pole1.addActionListener(obrabotka);
        pole2.addActionListener(obrabotka);
        pole3.addActionListener(obrabotka);
        pass.addActionListener(obrabotka);

    }

    private class Obrabotchik implements ActionListener{
        public void actionPerformed(ActionEvent event){  //метод базового класса, работу которого мы переопределяем
            String string = "";
            if(event.getSource() == pole1){  // если нажат enter на pole1
                string = String.format("pole 1: %s", event.getActionCommand()); // getActionCommand() - забирает данные из поля
            }
            else if(event.getSource() == pole2) {
                string = String.format("pole 2: %s", event.getActionCommand());
            }
            else if(event.getSource() == pole3){
                string = String.format("pole 3: %s", event.getActionCommand());
            }
            else if(event.getSource() == pass){
                string = String.format("pole s parolem)) %s", event.getActionCommand());
            }
            JOptionPane.showMessageDialog(null, string); // показать всплыв окно по центру с сообщ(string)
        }
    }
}
