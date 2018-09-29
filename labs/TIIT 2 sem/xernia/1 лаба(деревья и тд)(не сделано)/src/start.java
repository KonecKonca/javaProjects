/**
 * Created by Андрей on 31.12.2017.
 */
import javax.swing.JFrame;
import java.awt.*;

public class start {
    public static void main(String[] args){
        Gui grafon = new Gui();
        grafon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grafon.setResizable(false);
        grafon.setSize(482,158);
        grafon.setVisible(true);
    }
}
