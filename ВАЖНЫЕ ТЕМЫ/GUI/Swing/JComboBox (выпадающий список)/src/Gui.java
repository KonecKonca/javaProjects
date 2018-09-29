/**
 * Created by Андрей on 04.01.2018.
 */
import java.awt.FlowLayout;  // для разметки окна
import java.awt.event.ActionListener; // для прослушивани событий
import java.awt.event.ActionEvent;// для обработки, прослушанных сообщений
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Gui extends JFrame {
    private JComboBox box;
    private JLabel picture;

    private static String[] filename = {"1.png","2.png"};
    private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])), new ImageIcon(getClass().getResource(filename[1]))};

    public Gui(){
        super("JComboBox");
        setLayout(new FlowLayout());
        box = new JComboBox(filename);
        box.addItemListener(
                new ItemListener() {  // анонимный класс
                    public void itemStateChanged(ItemEvent event) {         //места создания класса обработчика
                        if(event.getStateChange() == ItemEvent.SELECTED){ // если поменялось значение
                            picture.setIcon(pics[box.getSelectedIndex()]);
                        }
                    }
                }
        );
        add(box);
        picture = new JLabel(pics[0]);
        add(picture);
    }
}
