import javax.swing.JFrame;

public class PyskSaperr {
    public static void main(String[] args){
        Saperr grafon = new Saperr();
        grafon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // крестик закрытия работает
        grafon.setResizable(false);
        grafon.setSize(385,446);
        grafon.setVisible(true);
    }
}
