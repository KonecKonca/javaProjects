import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.EventHandler;
import java.net.URL;
import java.util.concurrent.Exchanger;

// Можно будет юзать в всплывающих меню
public class Main{
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception{
        jFrame.add(jPanel);
        AbstractAction myAction = new MyAction();
        JButton button = new JButton(myAction);
        button.setText("submit");
        jPanel.add(button);

        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl B");  // создание сочетания клавиш
        InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);  // связь сочетания клавиш с действием в скобках указана зона видимости(в др окнах сочетание не сработает)
        inputMap.put(keyStroke, "changeColor");
        // WhenFocused -- онли на объекте
        // WHEN_ANCESTOR_OF_FOCUSED_COMPONENT -- когда на панельке
        // Whem+Focused_Window  -- везде
        ActionMap actionMap = jPanel.getActionMap();
        actionMap.put("changeColor", myAction);
}

    static class MyAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
            jPanel.setBackground(Color.BLUE);
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