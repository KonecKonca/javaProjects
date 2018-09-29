/**
 * Created by Андрей on 04.01.2018.
 */
import javafx.scene.text.*;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener; // для прослушивани событий
import java.awt.event.ActionEvent;// для обработки, прослушанных сообщений
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.acl.Group;
import javax.swing.*;

public class Gui extends JFrame {
    private JTextField TF;
    private Font PF;
    private Font BF;
    private Font ITF;
    private Font BITF;
    private JRadioButton PB;
    private JRadioButton BB;
    private JRadioButton IB;
    private JRadioButton BIB;
    private ButtonGroup group; // без этого объекта элементы будут вести себя независимо друг от друга

    public Gui(){
        super("Radiobutton");
        setLayout(new FlowLayout());
        TF = new JTextField("Текст для изменения");
        add(TF);
        PB = new JRadioButton("Простой текс", true); // при запуске проги галочка уже стоит
        BB = new JRadioButton("Жирный", false);
        IB = new JRadioButton("Наклонный", false);
        BIB = new JRadioButton("Жирный и наклонный", false);
        add(PB);
        add(BB);
        add(IB);
        add(BIB);
        group = new ButtonGroup();
        group.add(PB);
        group.add(BB);
        group.add(IB);
        group.add(BIB);

        PF = new Font("Serif", Font.PLAIN, 14);
        BF = new Font("Serif", Font.BOLD, 14);
        ITF  = new Font("Serif", Font.ITALIC, 14);
        BITF = new Font("Serif", Font.ITALIC + Font.BOLD, 14);

        TF.setFont(PF); // установка вида текста по умолчанию
        PB.addItemListener(new Obrabotka(PF));
        BB.addItemListener(new Obrabotka(BF));
        IB.addItemListener(new Obrabotka(ITF));
        BIB.addItemListener(new Obrabotka(BITF));
    }

    private class Obrabotka implements ItemListener{
        private Font font;
        Obrabotka(Font font){
            this.font = font;
        }

        public void itemStateChanged(ItemEvent event){  // метод обязательный для переопределения(реагирует на юзера)
            TF.setFont(font);
        }
    }
}
