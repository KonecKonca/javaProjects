import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.concurrent.Exchanger;

public class Main{
    public static void main(String[] args) {
        //String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); // список фриштов
        JFrame jFrame = getFrame();
        jFrame.add(new MyComponent());
    }

    static class MyComponent extends JComponent{  // класс дял рисования
        @Override
        protected void paintComponent(Graphics g){
            Font font = new Font("Bitstream Charter", Font.BOLD, 20);
            Graphics2D g2 = (Graphics2D) g; //  преводим к типу более нового класса для рисования
            g2.setFont(font);
            g.drawString("Hello World", 50, 50);

            Line2D l2 = new Line2D.Double(70,70,90,90);
            g2.draw(l2);  // чтоб нарисовать, пренимает любой объект наследуемый от Graphics2D
            Point2D p1 = new Point2D.Double(157, 230);
            Point2D p2 = new Point2D.Double(170, 170);
            Line2D l3 = new Line2D.Double(p1, p2);
            g2.draw(l3);
            Ellipse2D ellipse2D = new Ellipse2D.Double(70, 70, 170, 170);
            g2.draw(ellipse2D);
            g2.setPaint(new Color(34,144,34));
            g2.fill(ellipse2D);
            Rectangle2D rectangle2D = new Rectangle2D.Double(70, 70, 170, 170);
            g2.draw(rectangle2D);

            try{
                URL url = new URL("https://img.fonwall.ru/o/95/most_doma_ulitsyi_kamni_okean.jpg");  // сначада нужно открыть в новой вкладке
                Image image = new ImageIcon(url).getImage();
                g2.drawImage(image, 0, 70,34,43, null);
            }catch(Exception ex){}
        }
    }

    static  JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setLocation(500, 400); // Место появления
//        jFrame.setSize(500, 300);
        jFrame.setTitle("Any text");
        Toolkit toolkit = Toolkit.getDefaultToolkit();  // своего рода помощь в работе
        Dimension dimension = toolkit.getScreenSize();  // получили размер экрана
        jFrame.setBounds(dimension.width/2 - 250, dimension.height/2 - 150, 500, 300);  // альтернатива 2-ум предыдущим Норм если не занем с каким разрешением работаем
        return jFrame;
    }
}