/**
 * Created by Андрей on 04.01.2018.
 */
import java.awt.FlowLayout;  // для разметки окна
        import java.awt.event.ActionListener; // для прослушивани событий
        import java.awt.event.ActionEvent;// для обработки, прослушанных сообщений
        import javax.swing.*;

public class Gui extends JFrame {
    private JButton regBut;
    private JButton cusBut;

    public Gui(){
        super("Кпопки");
        setLayout(new FlowLayout());

        regBut = new JButton("просто кнопка");
        add(regBut);

        Icon image1 = new ImageIcon(getClass().getResource("1.png"));
        Icon image2 = new ImageIcon(getClass().getResource("2.png"));

        cusBut = new JButton("Кнопка с картинкой", image2); // сразу будет фоном кнопки
        cusBut.setRolloverIcon(image1);  // картинка меняется принаведении мышки
        add(cusBut);

        Classobrabotka obrabotka = new Classobrabotka();
        regBut.addActionListener(obrabotka);
        cusBut.addActionListener(obrabotka);
    }

    private class Classobrabotka implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
        }
    }
}
