/**
 * Created by Андрей on 31.12.2017.
 */
import javax.swing.*;

public class start {
    public static void main(String[] args){
        JFrame frame = new JFrame("Окно с вкладками");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Gui tablo = new Gui();
        tablo.addComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
}
