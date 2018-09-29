/**
 * Created by Андрей on 31.12.2017.
 */
import javax.swing.JOptionPane;

public class start {
    public static void main(String[] args){
        String first = JOptionPane.showInputDialog("Введи первое число:");
        String second = JOptionPane.showInputDialog("Введи первое число:");

        int num1 = Integer.parseInt(first);
        int num2 = Integer.parseInt(second);
        int sum = num1 + num2;

        JOptionPane.showMessageDialog(null,"Сумма = " + sum, "GUI", JOptionPane.PLAIN_MESSAGE); //(положение на экране, надпись, заголо, тип собщ)
    }
}
