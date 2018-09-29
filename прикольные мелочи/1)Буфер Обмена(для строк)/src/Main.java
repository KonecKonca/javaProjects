import com.sun.javafx.charts.ChartLayoutAnimator;

import javax.print.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
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

public class Main{
    public static void main(String[] args) throws Exception {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  //  буфер обмена
        StringSelection stringSelection = new StringSelection("Any text");
        clipboard.setContents(stringSelection, null);  // Посде этого текст выше окажется в буфере обмена

        DataFlavor flavor = DataFlavor.stringFlavor;  // указание типа данных
        if(clipboard.isDataFlavorAvailable(flavor)){
            System.out.println(clipboard.getData(flavor));  // вывод даных из буфера обена
        }

    }
}


// в буфер можно кидать не только текск, а всё что угодно
// для этого нужно реализовать интерфейс Transferable