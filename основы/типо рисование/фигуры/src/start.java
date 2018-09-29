/**
 * Created by Андрей on 31.12.2017.
 */
import javax.swing.*;

public class start {
    public static void main(String[] args){
        Gui grafon = new Gui();

        JFrame frame = new JFrame("Рисование");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // крестик закрытия работает
        frame.add(grafon);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
