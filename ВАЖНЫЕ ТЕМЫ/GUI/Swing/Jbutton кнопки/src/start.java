/**
 * Created by Андрей on 31.12.2017.
 */
import javax.swing.JFrame;

public class start {
    public static void main(String[] args){
        Gui grafon = new Gui();
        grafon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // крестик закрытия работает
        //grafon.setSize(1000,800);
        grafon.pack(); // подго размера
        grafon.setVisible(true);
    }
}
