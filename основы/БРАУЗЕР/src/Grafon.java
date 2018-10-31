import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 03.02.2018.
 */
public class Grafon extends JFrame{
    private JTextField adressBar;
    private JEditorPane browserPage;

    public Grafon(){
        super("SUPER БРАУЗЕР");
        adressBar = new JTextField("Введи адрес");

        adressBar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        loadData(e.getActionCommand());  // getACIOnComand получает введённые данные
                    }
                }
        );
        add(adressBar, BorderLayout.NORTH);

        browserPage = new JEditorPane();
        browserPage.setEditable(false); // нередактируемый
        browserPage.addHyperlinkListener(
                new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent e) {
                        if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){ // если ссылка нажата(клик ЛКМ)
                            loadData(e.getURL().toString());
                        }
                    }
                }
        );
        add(new JScrollPane(browserPage), BorderLayout.CENTER);
        setSize(800, 576);
        setVisible(true);
    }
    // загрузка данных в окно браузера
    private  void loadData(String userText){
        try{
            browserPage.setPage(userText);
            adressBar.setText(userText);
        }
        catch (Exception e){
            browserPage.setText("КАкого-то хуя не работает сайт\n\t" + userText + "\n хер знает почему");
        }
    }
}
