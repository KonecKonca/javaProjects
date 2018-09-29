import javax.swing.*;

public class Jara {
    public static void main(String[] args) {
        XX3 xx3 = new XX3();

        X1 x1 = new X1();
        x1.start();

        X2 x2 = new X2();
        x2.start();

    }

    static void start(){

    }
}

class XX3 extends JFrame{
    public XX3(){
        super("333333333333333333");
        setSize(70, 70);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}