/**
 * Created by Андрей on 31.12.2017.
 */
import javax.swing.*;

public class start {
    public static void main(String[] args){
        JFrame frame = new JFrame("Рисование");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // крестик закрытия работает

        Gui grafon = new Gui();
        frame.add(grafon);
        frame.setSize(300, 200);
        frame.setVisible(true);

    }
}
