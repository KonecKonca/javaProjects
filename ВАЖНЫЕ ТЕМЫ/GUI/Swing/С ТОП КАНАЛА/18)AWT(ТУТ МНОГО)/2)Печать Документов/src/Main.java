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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Exchanger;

// Сохранится в формате xps уже готово дял печати
public class Main{
    public static void main(String[] args) throws Exception {
        DocFlavor flavor = DocFlavor.INPUT_STREAM.JPEG;  // указываем формат, печатываемого документа
        PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);  // можно указывать параметры печати
        InputStream inputStream = new FileInputStream("1.jpg");
        Doc doc = new SimpleDoc(inputStream, flavor, null);
        if(services.length > 0){
            DocPrintJob job = services[0].createPrintJob();  // проверка на налисие принтака
            job.print(doc, null);
        }
    }
}