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
import java.awt.image.ImageObserver;

public class Gui extends JFrame {
    private JList Left;
    private JList Right;
    private JButton Move;

    private static String[] heroes = {"Персонаж1", "Персонаж2", "Перснонаж3", "Персонаж4", "Персонаж5", "Персонаж6"};

    public Gui(){
        super("Jlist");
        setLayout(new FlowLayout());
        Left = new JList(heroes);
        Left.setVisibleRowCount(3);
        Left.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // возможность одновременного выбора
        add(new JScrollPane(Left)); // добавление списка с возможностью его прокрутки
        Move = new JButton("------->");

        Move.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Right.setListData(Left.getSelectedValues()); // перенос элемента в правый список
                    }
                }
        );
        add(Move);
        Right = new JList();
        Right.setVisibleRowCount(3);
        Right.setFixedCellHeight(15);  // размеры списка
        Right.setFixedCellWidth(100);
        Right.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(Right));
    }
}
