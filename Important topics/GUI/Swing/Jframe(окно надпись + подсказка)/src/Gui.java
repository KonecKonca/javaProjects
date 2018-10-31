/**
 * Created by Андрей on 04.01.2018.
 */
import javax.swing.JOptionPane;
import java.awt.FlowLayout;   //размещение по умолчанию
import javax.swing.JFrame;   //для работы с окнами
import javax.swing.JLabel;  //текст и картинки в окне

public class Gui extends JFrame {
    private JLabel text1;

    public Gui(){
        super("Заголовок");
        setLayout(new FlowLayout());
        text1 = new JLabel("Какая-то надпись");
        text1.setToolTipText("Подсказка");
        add(text1);
    }
}
