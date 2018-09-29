import com.sun.javafx.charts.ChartLayoutAnimator;

import javax.print.*;
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
import java.io.*;
import java.net.URL;
import java.util.concurrent.Exchanger;

// -splash:smile.jpg  -- что-то, что открывается до запуска приложения (указать в настройках(VM options))
public class Main{
    public static void main(String[] args) throws Exception {
        // всё ниже для полосы прогрузки
        SplashScreen splashScreen = SplashScreen.getSplashScreen();
        Rectangle bounds = splashScreen.getBounds();
        Graphics2D g2 = splashScreen.createGraphics();
        g2.setColor(Color.blue);
        for(int i = 0; i < 100; i++){
            g2.fillRect(0, 0, bounds.width*i/100,20 );
            splashScreen.update();
            Thread.sleep(100);
        }
    }
}