/**
 * Created by Андрей on 04.01.2018.
 */
import java.awt.FlowLayout;  // для разметки окна
import java.awt.event.ActionListener; // для прослушивани событий
import java.awt.event.ActionEvent;// для обработки, прослушанных сообщений
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Gui extends JFrame {
    private JList list;
    private static String[] colourNames = {"белый", "синий", "зелёный", "красный"};
    private static Color[] colors = {Color.WHITE, Color.BLUE, Color.GREEN, Color.RED};  // Массив типа "цвет экрана"

    public Gui(){
        super("JList");
        setLayout(new FlowLayout());
        list = new JList(colourNames);
        list.setVisibleRowCount(4);  // видно 4 записи
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // запрет одновременного выбора
        add(list);
        list.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        getContentPane().setBackground(colors[list.getSelectedIndex()]); //установка цвета экрана
                    }
                }
        );
    }
}
