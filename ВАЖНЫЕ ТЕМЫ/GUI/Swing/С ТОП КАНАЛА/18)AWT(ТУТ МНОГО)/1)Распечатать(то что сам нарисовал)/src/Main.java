import com.sun.javafx.charts.ChartLayoutAnimator;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.EventHandler;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;
import java.util.concurrent.Exchanger;


public class Main{
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);

        Printable printable = new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex == 0){
                    Graphics2D graphics2D = (Graphics2D) graphics;
                    Line2D line2D = new Line2D.Double(0, 0, 100, 100);
                    graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());  // дял случаю если линия выходит за границу
                    graphics2D.draw(line2D);
                    return PAGE_EXISTS;
                }
                return NO_SUCH_PAGE;
            }
        };
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(printable);
        if(job.printDialog()){
            job.print();
        }

    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }
}