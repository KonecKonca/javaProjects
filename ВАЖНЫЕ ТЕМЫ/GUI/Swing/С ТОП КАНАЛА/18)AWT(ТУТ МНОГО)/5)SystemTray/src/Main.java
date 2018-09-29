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

// БУДЕТ ОКРЫВАТЬСЯ ЯРЛЫЧЁК В ПЕСОЧНИЦЕ
public class Main{
    public static void main(String[] args) throws Exception {
        if(SystemTray.isSupported()){  // если поддерживается(т.к это св-во операционки)
            SystemTray tray = SystemTray.getSystemTray();
            Image image = new ImageIcon("2.jpg").getImage();
            PopupMenu popupMenu = new PopupMenu();
            popupMenu.add(new MenuItem("one"));
            popupMenu.add(new MenuItem("two"));
            MenuItem menuItem = new MenuItem("three");
            menuItem.addActionListener(e -> System.out.println("XxXxXxXxXxX"));
            popupMenu.add(menuItem);
            tray.add(new TrayIcon(image, "tray description", popupMenu));
        }
    }
}