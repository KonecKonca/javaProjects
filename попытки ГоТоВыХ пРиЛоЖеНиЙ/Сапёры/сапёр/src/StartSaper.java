import javax.swing.JFrame;

public class StartSaper {
    public static void main(String[] args){
        Saper grafon = new Saper();
        grafon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // крестик закрытия работает
        grafon.setResizable(false);
        grafon.setSize(385,446);
        grafon.setVisible(true);
    }
}