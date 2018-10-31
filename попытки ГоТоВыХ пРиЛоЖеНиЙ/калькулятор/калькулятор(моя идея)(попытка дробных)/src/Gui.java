/**
 * Created by Андрей on 04.01.2018.
 */
import java.awt.*;
import java.awt.event.ActionListener; // для прослушивани событий
import java.awt.event.ActionEvent;// для обработки, прослушанных сообщений
import javax.swing.*;

public class Gui extends JFrame {
    private JButton start;
    private JButton b0;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton ravno;
    private JButton plus;
    private JButton minus;
    private JButton del;
    private JButton ymnoj;
    private JButton zapiatiaja;
    private JButton smenaZnaka;
    private JButton bonus;
    private JButton koren;
    private JButton sbros;

    private JLabel vivod;
    private JLabel num1;
    private JLabel num2;
    private JLabel forZnak;
    private Font font;

    public Gui(){
        super("Калькулятор");
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.CYAN);

        Icon image = new ImageIcon(getClass().getResource("start.png"));
        font = new Font("Verdana", Font.BOLD, 11);
        start = new JButton(image);
        add(start);
        b1 = new JButton("1");
        add(b1);
        b2 = new JButton("2");
        add(b2);
        b3 = new JButton("3");
        add(b3);
        b4 = new JButton("4");
        add(b4);
        b5 = new JButton("5");
        add(b5);
        b6 = new JButton("6");
        add(b6);
        b7 = new JButton("7");
        add(b7);
        b8 = new JButton("8");
        add(b8);
        b9 = new JButton("9");
        add(b9);
        b0 = new JButton("0");
        add(b0);

        plus = new JButton("+");
        add(plus);
        minus = new JButton("-");
        add(minus);
        zapiatiaja = new JButton(",");
        add(zapiatiaja);
        smenaZnaka = new JButton("+-");
        add(smenaZnaka);
        ymnoj = new JButton("*");
        add(ymnoj);
        del = new JButton("/");
        add(del);
        koren = new JButton("√");
        add(koren);
        ravno = new JButton("      =      ");
        //ravno.setPreferredSize(new Dimension(40,40)); //можно задать размер кнопки
        add(ravno);
        sbros = new JButton("C");
        add(sbros);

        num1 = new JLabel(" 1-ое    ");
        add(num1);
        forZnak = new JLabel("      ?      ");
        add(forZnak);
        num2 = new JLabel("    2-ое ");
        add(num2);
        vivod = new JLabel("Тут будет результат");
        vivod.setFont(font);
        num1.setFont(font);
        num2.setFont(font);
        forZnak.setFont(font);
        add(vivod);
        bonus = new JButton("/\\/\\/\\--НЕ ДЛЯ ЛОХОВ--/\\/\\/\\");
        add(bonus);

        Classobrabotka1 obrabotka1 = new Classobrabotka1();
        b0.addActionListener(obrabotka1);
        b1.addActionListener(obrabotka1);
        b2.addActionListener(obrabotka1);
        b3.addActionListener(obrabotka1);
        b4.addActionListener(obrabotka1);
        b5.addActionListener(obrabotka1);
        b6.addActionListener(obrabotka1);
        b7.addActionListener(obrabotka1);
        b8.addActionListener(obrabotka1);
        b9.addActionListener(obrabotka1);
        zapiatiaja.addActionListener(obrabotka1);
        smenaZnaka.addActionListener(obrabotka1);

        ravno.addActionListener(obrabotka1);
        plus.addActionListener(obrabotka1);
        minus.addActionListener(obrabotka1);
        ymnoj.addActionListener(obrabotka1);
        del.addActionListener(obrabotka1);
        start.addActionListener(obrabotka1);
        bonus.addActionListener(obrabotka1);
        sbros.addActionListener(obrabotka1);
        koren.addActionListener(obrabotka1);
    }

    private class Classobrabotka1 implements ActionListener {
        boolean check = false;
        boolean pluS = false;
        boolean minuS = false;
        boolean ymnoJ = false;
        boolean deL = false;
        boolean znakN1 = true;

        double[] mass1 = {11,11,11,11,11,11,11,11,11,11};
        double[] mass2 = {11,11,11,11,11,11,11,11,11,11};
        int len1 = 0;
        int len2 = 0;
        double n1 = 0;
        double n2 = 0;

        double[] mass1Drob = {11,11,11,11,11,11,11,11,11,11};
        double[] mass2Drob = {11,11,11,11,11,11,11,11,11,11};
        int len1Drob = 0;
        int len2Drob = 0;
        boolean drob = false;

        public void help1(){
            for(int i = 0; i < 10; i++){
                if(mass1[i] == 11){
                    len1 = i;
                    break;
                }
            }
        }
        public void help2(){
            for(int i = 0; i < 10; i++){
                if(mass2[i] == 11){
                    len2 = i;
                    break;
                }
            }
        }
        public void help11(){
            int coef = 1;
            double n1 = 0;
            for(int i = len1; i >=0; i--){
                n1 += coef*mass1[i];
                coef *=10;
            }
            coef = 1;
            if(!znakN1){
                num1.setText("-" + n1);
            }
            if(znakN1) {
                num1.setText("" + n1);
            }
            n1 = 0;
        }
        public void help22(){
            int coef = 1;
            double n2 = 0;
            for(int i = len2; i >=0; i--){
                n2 += coef*mass2[i];
                coef *=10;
            }
            coef = 1;
            num2.setText("" +n2);
            n2 = 0;
        }

        public void help1Drob(){
            for(int i = 0; i < 10; i++){
                if(mass1Drob[i] == 11){
                    len1Drob = i;
                    break;
                }
            }
        }
        public void help2Drob(){
            for(int i = 0; i < 10; i++){
                if(mass2Drob[i] == 11){
                    len2Drob = i;
                    break;
                }
            }
        }
        public void help11Drob(){
            int coef = 1;
            double n1 = 0;
            for(int i = len1; i >=0; i--){
                n1 += coef*mass1[i];
                coef *=10;
            }
            coef = 1;
            double c = 0.1;
            for(int i = 0; i<len1Drob; i++){
                n1 += c*mass1Drob[i];
            }
            if(!znakN1){
                num1.setText("-" + n1);
            }
            if(znakN1) {
                num1.setText("" + n1);
            }
            n1 = 0;
        }
        public void help22Drob(){
            int coef = 1;
            double n2 = 0;
            for(int i = len2; i >=0; i--){
                n2 += coef*mass2[i];
                coef *=10;
            }
            coef = 1;
            double c = 0.1;
            for(int i = 0; i<len2Drob; i++){
                n2 += c*mass2Drob[i];
                c *= 0.1;
            }
            if(!znakN1){
                num2.setText("-" + n2);
            }
            if(znakN1) {
                num2.setText("" + n2);
            }
            n2 = 0;
        }

        public void actionPerformed(ActionEvent event) {

            if(event.getSource() == zapiatiaja){
                drob = true;
            }

            if(event.getSource() == plus){
                if(check){
                    check = false;
                }
                if(!check){
                    check = true;
                }
                pluS = true;
                if(mass1[0] != 11) {
                    forZnak.setText("      +      ");
                }
                drob = false;
            }

            if(event.getSource() == minus){
                if(check){
                    check = false;
                }
                if(!check){
                    check = true;
                }
                minuS = true;
                if(mass1[0] != 11) {
                    forZnak.setText("      -      ");
                }
                drob = false;
            }

            if(event.getSource() == ymnoj){
                if(check){
                    check = false;
                }
                if(!check){
                    check = true;
                }
                ymnoJ = true;
                if(mass1[0] != 11) {
                    forZnak.setText("      *      ");
                }
                drob = false;
            }

            if(event.getSource() == del){
                if(check){
                    check = false;
                }
                if(!check){
                    check = true;
                }
                deL = true;
                if(mass1[0] != 11) {
                    forZnak.setText("      /      ");
                }
                drob = false;
            }

            if((event.getSource() == smenaZnaka) && !pluS && !minuS && !ymnoJ && !deL && mass1[0]==11){
                if(!znakN1){
                    znakN1 = true;
                }
                if(znakN1){
                    znakN1 = false;
                }
            }

            if(event.getSource() == sbros){
                n1 = 0;
                n2 = 0;
                for (int i = 0; i<10; i++){
                    mass1[i] = 11;
                    mass2[i] = 11;
                }
                len1 = 0;
                len2 = 0;
                pluS = false;
                minuS = false;
                ymnoJ = false;
                deL = false;
                check = false;
                znakN1 = true;
                num1.setText(" 1-ое    ");
                forZnak.setText("      ?      ");
                num2.setText("    2-ое ");
                vivod.setText("Сначала данные введи");
            }
////////////////////////////////////////////////////////\
            if(!check && drob) {
                if (event.getSource() == b0) {
                    help1Drob();
                    mass1Drob[len1Drob] = 0;
                    help11Drob();
                }
                if (event.getSource() == b1) {
                    help1Drob();
                    mass1Drob[len1Drob] = 1;
                    help11Drob();
                }
                if (event.getSource() == b2) {
                    help1Drob();
                    mass1Drob[len1Drob] = 2;
                    help11Drob();
                }
                if (event.getSource() == b3) {
                    help1Drob();
                    mass1Drob[len1Drob] = 3;
                    help11Drob();
                }
                if (event.getSource() == b4) {
                    help1Drob();
                    mass1Drob[len1Drob] = 4;
                    help11Drob();
                }
                if (event.getSource() == b5) {
                    help1Drob();
                    mass1Drob[len1Drob] = 5;
                    help11Drob();
                }
                if (event.getSource() == b6) {
                    help1Drob();
                    mass1Drob[len1Drob] = 6;
                    help11Drob();
                }
                if (event.getSource() == b7) {
                    help1Drob();
                    mass1Drob[len1Drob] = 7;
                    help11Drob();
                }
                if (event.getSource() == b8) {
                    help1Drob();
                    mass1Drob[len1Drob] = 8;
                    help11Drob();
                }
                if (event.getSource() == b9) {
                    help1Drob();
                    mass1Drob[len1Drob] = 9;
                    help11Drob();
                }
            }
/////////////////////////////////////////////////////////
            if(check && drob) {
                if (event.getSource() == b0) {
                    help2Drob();
                    mass2Drob[len2Drob] = 0;
                    help22Drob();
                }
                if (event.getSource() == b1) {
                    help2Drob();
                    mass2Drob[len2Drob] = 1;
                    help22Drob();
                }
                if (event.getSource() == b2) {
                    help2Drob();
                    mass2Drob[len2Drob] = 2;
                    help22Drob();
                }
                if (event.getSource() == b3) {
                    help2Drob();
                    mass2Drob[len2Drob] = 3;
                    help22Drob();
                }
                if (event.getSource() == b4) {
                    help2Drob();
                    mass2Drob[len2Drob] = 4;
                    help22Drob();
                }
                if (event.getSource() == b5) {
                    help2Drob();
                    mass2Drob[len2Drob] = 5;
                    help22Drob();
                }
                if (event.getSource() == b6) {
                    help2Drob();
                    mass2Drob[len2Drob] = 6;
                    help22Drob();
                }
                if (event.getSource() == b7) {
                    help2Drob();
                    mass2Drob[len2Drob] = 7;
                    help22Drob();
                }
                if (event.getSource() == b8) {
                    help2Drob();
                    mass2Drob[len2Drob] = 8;
                    help22Drob();
                }
                if (event.getSource() == b9) {
                    help2Drob();
                    mass2Drob[len2Drob] = 9;
                    help22Drob();
                }
            }
/////////////////////////////////////////////////////////
            if(!check && !drob) {
                if (event.getSource() == b0) {
                    help1();
                    mass1[len1] = 0;
                    help11();
                }
                if (event.getSource() == b1) {
                    help1();
                    mass1[len1] = 1;
                    help11();
                }
                if (event.getSource() == b2) {
                    help1();
                    mass1[len1] = 2;
                    help11();
                }
                if (event.getSource() == b3) {
                    help1();
                    mass1[len1] = 3;
                    help11();
                }
                if (event.getSource() == b4) {
                    help1();
                    mass1[len1] = 4;
                    help11();
                }
                if (event.getSource() == b5) {
                    help1();
                    mass1[len1] = 5;
                    help11();
                }
                if (event.getSource() == b6) {
                    help1();
                    mass1[len1] = 6;
                    help11();
                }
                if (event.getSource() == b7) {
                    help1();
                    mass1[len1] = 7;
                    help11();
                }
                if (event.getSource() == b8) {
                    help1();
                    mass1[len1] = 8;
                    help11();
                }
                if (event.getSource() == b9) {
                    help1();
                    mass1[len1] = 9;
                    help11();
                }
            }
   //////////////////////////////////////////////////////////////
            if(check && !drob) {
                if (event.getSource() == b0) {
                    help2();
                    mass2[len2] = 0;
                    help22();
                }
                if (event.getSource() == b1) {
                    help2();
                    mass2[len2] = 1;
                    help22();
                }
                if (event.getSource() == b2) {
                    help2();
                    mass2[len2] = 2;
                    help22();
                }
                if (event.getSource() == b3) {
                    help2();
                    mass2[len2] = 3;
                    help22();
                }
                if (event.getSource() == b4) {
                    help2();
                    mass2[len2] = 4;
                    help22();
                }
                if (event.getSource() == b5) {
                    help2();
                    mass2[len2] = 5;
                    help22();
                }
                if (event.getSource() == b6) {
                    help2();
                    mass2[len2] = 6;
                    help22();
                }
                if (event.getSource() == b7) {
                    help2();
                    mass2[len2] = 7;
                    help22();
                }
                if (event.getSource() == b8) {
                    help2();
                    mass2[len2] = 8;
                    help22();
                }
                if (event.getSource() == b9) {
                    help2();
                    mass2[len2] = 9;
                    help22();
                }
            }
////////////////////////////////////////////////////////
            if(event.getSource() == start){
                int coef = 1;
                for(int i = len1; i >=0; i--){
                    n1 += coef*mass1[i];
                    coef *=10;
                }
                if(!znakN1){
                    n1 = -n1;
                }
                coef = 1;
                for(int i = len2; i >=0; i--){
                    n2 += coef*mass2[i];
                    coef *=10;
                }
                if(pluS && mass1[0]!=11 && mass2[0]!=11){
                    vivod.setText("           =   " + (n1 + n2));
                }
                else if(minuS && mass1[0]!=11 && mass2[0]!=11){
                    vivod.setText("           =   " + (n1 - n2));
                }
                else if(ymnoJ && mass1[0]!=11 && mass2[0]!=11){
                    vivod.setText("           =   " + (n1 * n2));
                }
                else if(deL && mass1[0]!=11 && mass2[0]!=11){
                    vivod.setText("           =   " + (n1 / n2));
                }
                else{
                    num1.setText(" 1-ое    ");
                    forZnak.setText("      ?      ");
                    num2.setText("    2-ое ");
                    vivod.setText("Тупые юзеры)");
                    JOptionPane.showMessageDialog(null,"ЭТО МЕГААХУЕННЫЙ КАЛЬКУЛЬТОР");
                }

                n1 = 0;
                n2 = 0;
               for (int i = 0; i<10; i++){
                    mass1[i] = 11;
                    mass2[i] = 11;
               }
                len1 = 0;
                len2 = 0;
                pluS = false;
                minuS = false;
                ymnoJ = false;
                deL = false;
                check = false;
                znakN1 = true;

                for(int i = 0; i<10; i++){
                    mass1Drob[i] = 11;
                    mass2Drob[i] = 11;
                }
                len1Drob = 0;
                len2Drob = 0;
                drob = false;
            }

            if(event.getSource() == ravno){
                int coef = 1;
                for(int i = len1; i >=0; i--){
                    n1 += coef*mass1[i];
                    coef *=10;
                }
                if(!znakN1){
                    n1 = -n1;
                }
                coef = 1;
                for(int i = len2; i >=0; i--){
                    n2 += coef*mass2[i];
                    coef *=10;
                }
                if(pluS && mass1[0]!=11 && mass2[0]!=11){
                    vivod.setText("           =   " + (n1 + n2));
                }
                else if(minuS && mass1[0]!=11 && mass2[0]!=11){
                    vivod.setText("           =   " + (n1 - n2));
                }
                else if(ymnoJ && mass1[0]!=11 && mass2[0]!=11){
                    vivod.setText("           =   " + (n1 * n2));
                }
                else if(deL && mass1[0]!=11 && mass2[0]!=11){
                    vivod.setText("           =   " + (n1 / n2));
                }
                else{
                    num1.setText(" 1-ое    ");
                    forZnak.setText("      ?      ");
                    num2.setText("    2-ое ");
                    vivod.setText("Сначала данные введи");
                }

                n1 = 0;
                n2 = 0;
                for (int i = 0; i<10; i++){
                    mass1[i] = 11;
                    mass2[i] = 11;
                }
                len1 = 0;
                len2 = 0;
                pluS = false;
                minuS = false;
                ymnoJ = false;
                deL = false;
                check = false;
                znakN1 = true;

                for(int i = 0; i<10; i++){
                    mass1Drob[i] = 11;
                    mass2Drob[i] = 11;
                }
                len1Drob = 0;
                len2Drob = 0;
                drob = false;
            }
            if(event.getSource() == koren){
                int coef = 1;
                for(int i = len1; i >=0; i--){
                    n1 += coef*mass1[i];
                    coef *=10;
                }
                if(!znakN1){
                    n1 = -n1;
                }
                if(mass1[0] != 11){
                    vivod.setText("           =   " + Math.sqrt(n1));
                    forZnak.setText("      √      ");
                    num2.setText("    xXxX");
                }
                else{
                    num1.setText(" 1-ое    ");
                    forZnak.setText("      √      ");
                    num2.setText("    xXxX");
                    vivod.setText("Сначала данные введи");
                }
                n1 = 0;
                n2 = 0;
                for (int i = 0; i<10; i++){
                    mass1[i] = 11;
                    mass2[i] = 11;
                }
                len1 = 0;
                len2 = 0;
                pluS = false;
                minuS = false;
                ymnoJ = false;
                deL = false;
                check = false;
                znakN1 = true;

                for(int i = 0; i<10; i++){
                    mass1Drob[i] = 11;
                    mass2Drob[i] = 11;
                }
                len1Drob = 0;
                len2Drob = 0;
                drob = false;
            }
        }
    }

}
//string = String.format("pole 1: %s", event.getActionCommand()); // getActionCommand() - забирает данные из поля
