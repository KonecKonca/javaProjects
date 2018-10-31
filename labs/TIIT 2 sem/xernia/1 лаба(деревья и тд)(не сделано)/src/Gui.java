/**
 * Created by Андрей on 04.01.2018.
 */
import java.awt.*;
import java.awt.event.ActionListener; // для прослушивани событий
import java.awt.event.ActionEvent;// для обработки, прослушанных сообщений
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import javax.crypto.spec.DESedeKeySpec;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Gui extends JFrame {
    private JButton sozdatDerevo;
    private JButton vstavitElement;
    private JButton ydalElement;
    private JButton poiskPoID;
    private JButton poiskBlijMin;
    private JButton poiskBlijMax;
    private JButton poiskMin;
    private JButton poiskMax;
    private JButton polnoePerestroenie;
    private JButton redBlack;
    private JButton showDerevo;
    private JLabel fon;

    public Gui(){
        super("Красно-чёрное дерево");
        FlowLayout f = new FlowLayout(FlowLayout.CENTER);
        ImageIcon image1 = new ImageIcon(getClass().getResource("1.JPG"));
        //Font font = new Font("Verdana", Font.BOLD, 24);

        fon = new JLabel("");
        fon.setIcon(image1);
        fon.setLayout(f);
        add(fon);

        sozdatDerevo = new JButton("       Создать дерево        ");
        sozdatDerevo.setForeground(Color.darkGray);
        fon.add(sozdatDerevo);
        vstavitElement = new JButton("Добавить элемент  ");
        vstavitElement.setForeground(Color.darkGray);
        fon.add(vstavitElement);
        ydalElement = new JButton("Удалить элемент");
        ydalElement.setForeground(Color.darkGray);
        fon.add(ydalElement);

        polnoePerestroenie = new JButton(" Полная балансировка ");
        polnoePerestroenie.setForeground(Color.red);
        fon.add(polnoePerestroenie);
        redBlack = new JButton("кр-ч балансировка");
        redBlack.setForeground(Color.red);
        fon.add(redBlack);
        showDerevo = new JButton("   вывод дерева  ");
        showDerevo.setForeground(Color.red);
        fon.add(showDerevo);

        poiskPoID = new JButton("Поиск");
        poiskPoID.setForeground(Color.BLUE);
        fon.add(poiskPoID);
        poiskMin = new JButton("Поиски минимума");
        poiskMin.setForeground(Color.BLUE);
        fon.add(poiskMin);
        poiskMax = new JButton("поиск максимума");
        poiskMax.setForeground(Color.BLUE);
        fon.add(poiskMax);
        poiskBlijMin = new JButton("поиск ближайшего меньшего");
        poiskBlijMin.setForeground(Color.BLUE);
        fon.add(poiskBlijMin);
        poiskBlijMax = new JButton("поиск ближайшего большего");
        poiskBlijMax.setForeground(Color.BLUE);
        fon.add(poiskBlijMax);

        Classobrabotka obrabotka = new Classobrabotka();
        sozdatDerevo.addActionListener(obrabotka);
        vstavitElement.addActionListener(obrabotka);
        ydalElement.addActionListener(obrabotka);
        polnoePerestroenie.addActionListener(obrabotka);
        redBlack.addActionListener(obrabotka);
        showDerevo.addActionListener(obrabotka);
        poiskPoID.addActionListener(obrabotka);
        poiskMin.addActionListener(obrabotka);
        poiskMax.addActionListener(obrabotka);
        poiskBlijMin.addActionListener(obrabotka);
        poiskBlijMax.addActionListener(obrabotka);
    }

    private class Classobrabotka implements ActionListener{
        private boolean canWork = false;
        private int nomber = 0;
        private int[] zn;
        private int[] id;
        Tree derevo;

        private void failChit(){
            FileReader reader;
            Scanner chit;
            try {
                reader = new FileReader("text.txt");
                chit = new Scanner(reader);
                int i = 0;
                int dop;
                while (chit.hasNext()){
                    dop = chit.nextInt();
                    dop = chit.nextInt();
                    i++;
                }
                nomber = i;
                reader.close();
                reader = new FileReader("text.txt");
                chit = new Scanner(reader);
                zn = new int[nomber];
                id = new int[nomber];
                i = 0;
                while (chit.hasNext()){
                    id[i] = chit.nextInt();
                    zn[i] = chit.nextInt();
                    i++;
                }
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null,
                        "Файл не существует, или ввод не верный", "Ошибка", JOptionPane.PLAIN_MESSAGE);
            }
        }

        public void actionPerformed(ActionEvent event){
            failChit();
            QuickSort.quickSort(id, 0, id.length - 1);
            QuickSort.quickSort(zn, 0, zn.length - 1);

            if(event.getSource() == sozdatDerevo){
                derevo = new Tree();
                int sred = nomber/2;
                for(int i = sred; i < nomber; i++){
                    derevo.insert(id[i], zn[i]);
                }
                for(int i = 0; i < sred; i++){
                    derevo.insert(id[i], zn[i]);
                }
                canWork = true;
            }

            if(event.getSource() == showDerevo){
                if(canWork) {
                    //derevo.displayTree();
                    NN N = new NN();
                    N.n = 0;
                    derevo.show(N.n);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Сначала дерево создай","Ошибка",JOptionPane.PLAIN_MESSAGE);
                }
            }

            if(event.getSource() == vstavitElement){
                if(canWork) {
                    Scanner vvod = new Scanner(System.in);
                    String str = JOptionPane.showInputDialog("Введите ID");
                    int id = Integer.parseInt(str);
                    str = JOptionPane.showInputDialog("Введите значение");
                    int znach = Integer.parseInt(str);
                    derevo.insert(id, znach);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Сначала дерево создай","Ошибка",JOptionPane.PLAIN_MESSAGE);
                }
            }

            if(event.getSource() == ydalElement){
                if(canWork) {
                    String str = JOptionPane.showInputDialog("Введите ID удаляемого элемента");
                    derevo.delete(Integer.parseInt(str));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Сначала дерево создай","Ошибка",JOptionPane.PLAIN_MESSAGE);
                }
            }

            if(event.getSource() == poiskPoID){
                if(canWork) {
                    String str = JOptionPane.showInputDialog("Введите ID нужного элемента");
                    derevo.find(Integer.parseInt(str));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Сначала дерево создай","Ошибка",JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }

    class NN{
        int n;
    }
}
