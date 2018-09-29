/**
 * Created by Андрей on 04.01.2018.
 */
import java.awt.*;
import java.awt.event.ActionListener; // для прослушивани событий
import java.awt.event.ActionEvent;// для обработки, прослушанных сообщений
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Gui extends JFrame {
    private JTextField textField;
    private JCheckBox boldBox;
    private JCheckBox italicBox;

    public Gui(){
        super("CheckBox");
        setLayout(new FlowLayout());

        textField = new JTextField("Текст для изменений");
        textField.setFont(new Font("serif", Font.PLAIN, 14)); // параметры текста
        add(textField);
        boldBox = new JCheckBox("Жирный");
        add(boldBox);
        italicBox = new JCheckBox("Наклонный");
        add(italicBox);

        Obrabotchik obrabotka = new Obrabotchik();
        boldBox.addItemListener(obrabotka);
        italicBox.addItemListener(obrabotka);

    }

    private class Obrabotchik implements ItemListener{
        public void itemStateChanged(ItemEvent event){
            Font font = null;
            if(boldBox.isSelected() && italicBox.isSelected()){
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            }
            else if(boldBox.isSelected() ){
                font = new Font("Serif", Font.BOLD, 14);
            }
            else if(italicBox.isSelected()){
                font = new Font("Serif", Font.ITALIC, 14);
            }
            textField.setFont(font);
        }
    }
}
