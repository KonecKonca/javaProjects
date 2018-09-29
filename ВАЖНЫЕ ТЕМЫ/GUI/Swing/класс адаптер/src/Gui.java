import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;

public class Gui extends JFrame{
    private String details;
    private JLabel statusbar;

    public Gui(){
        super("Адаптер");
        statusbar = new JLabel("Строка состояния");
        add(statusbar, BorderLayout.SOUTH);

        addMouseListener(new MouseClass());
    }

    private class MouseClass extends MouseAdapter{ //чтоб не переопределять все остальные методы
        public void mouseClicked(MouseEvent event){
            details = String.format("Ты на жал на мышку %d раз", event.getClickCount());
            if(event.isMetaDown()){ // если нажили праву кнопку
                details += " правой";
            }
            else  if(event.isAltDown()){
                details += " колесиком";
            }
            else{
                details += " левой";
            }
            statusbar.setText(details);
        }
    }
}
