
import java.awt.*;
import java.awt.event.ActionListener; // для прослушивани событий
import java.awt.event.ActionEvent;// для обработки, прослушанных сообщений
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.io.*;

public class Saperr extends JFrame {
    private JLabel kolMin;
    private JButton start;
    private JLabel time;
    private JButton[][] mina;
    private FlowLayout razmetka;
    private Font font;
    private Font font1;
    private JButton Liders;

    private final int kolTheBest = 10;
    private double bestTime[] = new double[kolTheBest];
    private String bestName[] = new String[kolTheBest];
    private Icon flag = new ImageIcon(getClass().getResource("res\\флажок.JPG"));
    private Icon bomba = new ImageIcon(getClass().getResource("res\\бомба.JPG"));
    private Icon question = new ImageIcon(getClass().getResource("res\\вопрос.JPG"));
    private Icon[] numbers = new Icon[8];


    private int str = 9;
    private int stlb = 9;

    boolean cheakerRight = false;

    public Saperr(){
        super("Сапёрыч)");
        for(int i = 0; i < 10; i++){
            bestTime[i] = 0;
        }
        razmetka = new FlowLayout(1,0,0);
        setLayout(razmetka);
        getContentPane().setBackground(Color.getHSBColor(0, 0, 255));
        font = new Font("Verdana", Font.BOLD, 9);
        font1 = new Font("Corsiva",Font.BOLD, 16);

        numbers[0] = new ImageIcon(getClass().getResource("res\\1.JPG"));
        numbers[1] = new ImageIcon(getClass().getResource("res\\2.JPG"));
        numbers[2] = new ImageIcon(getClass().getResource("res\\3.JPG"));
        numbers[3] = new ImageIcon(getClass().getResource("res\\4.JPG"));
        numbers[4] = new ImageIcon(getClass().getResource("res\\5.JPG"));
        numbers[5] = new ImageIcon(getClass().getResource("res\\6.JPG"));
        numbers[6] = new ImageIcon(getClass().getResource("res\\7.JPG"));
        numbers[7] = new ImageIcon(getClass().getResource("res\\8.JPG"));

        kolMin = new JLabel("      10         ");
        kolMin.setFont(font1);
        add(kolMin);
        start = new JButton("                  start                  ");
        start.setFont(font1);
        add(start);
        time = new JLabel("       0         ");
        time.setFont(font1);
        add(time);
        mina = new JButton[9][9];

        obrabotka obrabotchik = new obrabotka();
        mishka mish = new mishka();

        for(int i =0; i<9; i++){
            for(int j =0; j<9; j++){
                mina[i][j] = new JButton("");
                mina[i][j].setFont(font);
                mina[i][j].setPreferredSize(new Dimension(40,40));
                mina[i][j].setBackground(Color.green);
                add(mina[i][j]);
                mina[i][j].addActionListener(obrabotchik);
                mina[i][j].addMouseListener(mish);
            }
        }
        Liders = new JButton("                                        К списку лидеров!!!!!!                                    ");
        add(Liders);

        Liders.addActionListener(obrabotchik);
        start.addActionListener(obrabotchik);
    }

    private class obrabotka implements ActionListener{
        private boolean cheak = false;
        private boolean cheakEnd = true;
        private boolean[][] mini = new boolean[9][9];
        private int numMins = 0;
        private int numFlajoks = 10;
        private boolean[][] setFlag = new boolean[9][9];
        private int[][] surrroundMins = new int[9][9];

        private boolean cheakTime = false;
        private double startTime;
        private double endTime;
        private double resultTime;

        private boolean[][] checkFlag = new boolean[str][stlb];

        private void zapoln(){
            kolMin.setText("      " + numFlajoks + "         ");
            for(int i = 0; i<9; i++){
                for(int j = 0; j<9; j++){
                    setFlag[i][j] = false;
                    surrroundMins[i][j] = 0;
                }
            }
            Random random = new Random();
            for(int i = 0; i<9; i++){
                for(int j =0 ; j<9; j++){
                    mina[i][j].setIcon(new ImageIcon()); // затирание картинки
                    mini[i][j] = false;
                    mina[i][j].setBackground(Color.ORANGE);
                }
            }
            while(numMins < 10) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        int dop = random.nextInt(7);
                        if(numMins >= 10){
                            break;
                        }
                        if (dop == 5 && !mini[i][j]) {
                            mini[i][j] = true;
                            numMins++;
                        }
                    }
                }
            }
            podchet();
            startTime = System.currentTimeMillis();
            cheakTime = false;
        }

        private void end(){
            cheakEnd = true;
            cheak = false;
            for(int i = 0; i<9; i++){
                for(int j = 0; j<9; j++){
                    mina[i][j].setBackground(Color.green);
                    if(mini[i][j] && !setFlag[i][j]){
                        mina[i][j].setIcon(bomba);
                    }
                    else if(mini[i][j] && setFlag[i][j]){
                        mina[i][j].setBackground(Color.RED);
                        mina[i][j].setIcon(bomba);
                    }
                    mini[i][j] = false;
                }
            }
            numMins = 0;
            numFlajoks = 10;
        }

        private void podchet(){ // подсчёт кол-ва мин вокруг клетки
            // сначала идёт подсчёт для углов
            // левый верхний
            if(mini[0][1]){
                surrroundMins[0][0]++;
            }
            if(mini[1][1]){
                surrroundMins[0][0]++;
            }
            if(mini[1][0]){
                surrroundMins[0][0]++;
            }
            // правый нижний
            if(mini[str - 2][stlb - 1]){
                surrroundMins[str - 1][stlb - 1]++;
            }
            if(mini[str - 2][stlb - 2]){
                surrroundMins[str - 1][stlb - 1]++;
            }
            if(mini[str - 1][stlb - 2]){
                surrroundMins[str - 1][stlb - 1]++;
            }
            // правый верхний
            if(mini[0][stlb - 2]){
                surrroundMins[0][stlb - 1]++;
            }
            if(mini[1][stlb - 1]){
                surrroundMins[0][stlb - 1]++;
            }
            if(mini[1][stlb - 2]){
                surrroundMins[0][stlb - 1]++;
            }
            //левый нижний
            if(mini[str - 2][0]){
                surrroundMins[str - 1][0]++;
            }
            if(mini[str - 2][1]){
                surrroundMins[str - 1][0]++;
            }
            if(mini[str - 1 ][1]){
                surrroundMins[str - 1][0]++;
            }
            //центральная часть
            for(int i = 1; i < (str - 1); i++){
                for(int j = 1; j < (stlb - 1); j++){
                    if(mini[i - 1][j - 1]){
                        surrroundMins[i][j]++;
                    }
                    if(mini[i - 1][j]){
                        surrroundMins[i][j]++;
                    }
                    if(mini[i - 1][j + 1]){
                        surrroundMins[i][j]++;
                    }
                    if(mini[i][j - 1]){
                        surrroundMins[i][j]++;
                    }
                    if(mini[i][j + 1]){
                        surrroundMins[i][j]++;
                    }
                    if(mini[i + 1][j - 1]){
                        surrroundMins[i][j]++;
                    }
                    if(mini[i + 1][j]){
                        surrroundMins[i][j]++;
                    }
                    if(mini[i + 1][j + 1]){
                        surrroundMins[i][j]++;
                    }
                }
            }
            //боковые полоски
            // верхняя
            for(int i = 1; i < (stlb - 1); i++){
                if(mini[0][i - 1]){
                    surrroundMins[0][i]++;
                }
                if(mini[0][i + 1]){
                    surrroundMins[0][i]++;
                }
                if(mini[1][i]){
                    surrroundMins[0][i]++;
                }
                if(mini[1][i  - 1]){
                    surrroundMins[0][i]++;
                }
                if(mini[1][i + 1]){
                    surrroundMins[0][i]++;
                }
            }
            // нижняя
            for(int i = 1; i < (stlb - 1); i++){
                if(mini[str - 1][i - 1]){
                    surrroundMins[str - 1][i]++;
                }
                if(mini[str - 1][i + 1]){
                    surrroundMins[str - 1][i]++;
                }
                if(mini[str - 2][i]){
                    surrroundMins[str - 1][i]++;
                }
                if(mini[str - 2][i  - 1]){
                    surrroundMins[str - 1][i]++;
                }
                if(mini[str - 2][i + 1]){
                    surrroundMins[str - 1][i]++;
                }
            }
            // левая
            for(int i = 1; i < (str - 1); i++){
                if(mini[i - 1][0]){
                    surrroundMins[i][0]++;
                }
                if(mini[i - 1][1]){
                    surrroundMins[i][0]++;
                }
                if(mini[i][1]){
                    surrroundMins[i][0]++;
                }
                if(mini[i + 1][0]){
                    surrroundMins[i][0]++;
                }
                if(mini[i + 1][1]){
                    surrroundMins[i][0]++;
                }
            }
            // правая
            for(int i = 1; i < (str - 1); i++){
                if(mini[i - 1][stlb - 1]){
                    surrroundMins[i][stlb - 1]++;
                }
                if(mini[i - 1][stlb - 2]){
                    surrroundMins[i][stlb - 1]++;
                }
                if(mini[i][stlb - 2]){
                    surrroundMins[i][stlb - 1]++;
                }
                if(mini[i + 1][stlb - 1]){
                    surrroundMins[i][stlb - 1]++;
                }
                if(mini[i + 1][stlb - 2]){
                    surrroundMins[i][stlb - 1]++;
                }
            }
        }

        private void opener(int stroch, int stolb){
            if(surrroundMins[stroch][stolb] == 0){
                mina[stroch][stolb].setBackground(Color.WHITE);
                mina[stroch][stolb].setIcon(new ImageIcon());
            }
            else if(surrroundMins[stroch][stolb] == 1){
                surrroundMins[stroch][stolb] = 11;
                mina[stroch][stolb].setBackground(Color.WHITE);
                mina[stroch][stolb].setIcon(numbers[0]);
            }
            else if(surrroundMins[stroch][stolb] == 2){
                surrroundMins[stroch][stolb] = 11;
                mina[stroch][stolb].setBackground(Color.WHITE);
                mina[stroch][stolb].setIcon(numbers[1]);
            }
            else if(surrroundMins[stroch][stolb] == 3){
                surrroundMins[stroch][stolb] = 11;
                mina[stroch][stolb].setBackground(Color.WHITE);
                mina[stroch][stolb].setIcon(numbers[2]);
            }
            else if(surrroundMins[stroch][stolb] == 4){
                surrroundMins[stroch][stolb] = 11;
                mina[stroch][stolb].setBackground(Color.WHITE);
                mina[stroch][stolb].setIcon(numbers[3]);
            }
            else if(surrroundMins[stroch][stolb] == 5){
                surrroundMins[stroch][stolb] = 11;
                mina[stroch][stolb].setBackground(Color.WHITE);
                mina[stroch][stolb].setIcon(numbers[4]);
            }
            else if(surrroundMins[stroch][stolb] == 6){
                surrroundMins[stroch][stolb] = 11;
                mina[stroch][stolb].setBackground(Color.WHITE);
                mina[stroch][stolb].setIcon(numbers[5]);
            }
            else if(surrroundMins[stroch][stolb] == 7){
                surrroundMins[stroch][stolb] = 11;
                mina[stroch][stolb].setBackground(Color.WHITE);
                mina[stroch][stolb].setIcon(numbers[6]);
            }
            else if(surrroundMins[stroch][stolb] == 8){
                surrroundMins[stroch][stolb] = 11;
                mina[stroch][stolb].setBackground(Color.WHITE);
                mina[stroch][stolb].setIcon(numbers[7]);
            }
            /////////////////////////////////////////////////////////////////////
            //  для центральных
            if(stroch >= 1 && stroch <= (str - 2) && stolb >= 1 && stolb <= (stlb - 2) && surrroundMins[stroch][stolb] == 0) {
                surrroundMins[stroch][stolb] = 11;
                opener(stroch - 1, stolb -1);
                opener(stroch - 1, stolb);
                opener(stroch-1, stolb + 1);
                opener(stroch, stolb - 1);
                opener(stroch, stolb + 1);
                opener(stroch + 1, stolb - 1);
                opener(stroch + 1, stolb);
                opener(stroch + 1, stolb + 1);
            }
            // углы
            // левый верхний
            if(surrroundMins[stroch][stolb] == 0 && stroch == 0 && stolb == 0){
                surrroundMins[stroch][stolb] = 11;
                opener(stroch, stolb + 1);
                opener(stroch + 1, stolb);
                opener(stroch + 1, stolb + 1);
            }
            // правый верхний
            if(surrroundMins[stroch][stolb] == 0 && stroch == 0 && stolb == (stlb - 1)){
                surrroundMins[stroch][stolb] = 11;
                opener(stroch, stolb - 1);
                opener(stroch + 1, stolb);
                opener(stroch + 1, stolb - 1);
            }
            // левый нижний
            if(surrroundMins[stroch][stolb] == 0 && stroch == (str - 1) && stolb == 0){
                surrroundMins[stroch][stolb] = 11;
                opener(stroch - 1, stolb);
                opener(stroch - 1, stolb + 1);
                opener(stroch, stolb + 1);
            }
            // правый нижний
            if(surrroundMins[stroch][stolb] == 0 && stroch == (str - 1) && stolb == (stlb - 1)){
                surrroundMins[stroch][stolb] = 11;
                opener(stroch - 1, stolb);
                opener(stroch - 1, stolb - 1);
                opener(stroch, stolb - 1);
            }
            // боковые грани
            // левая
            if(surrroundMins[stroch][stolb] == 0 && stroch >= 1 && stroch <= (str - 2) && stolb == 0){
                surrroundMins[stroch][stolb] = 11;
                opener(stroch - 1, stolb);
                opener(stroch - 1, stolb + 1);
                opener(stroch, stolb + 1);
                opener(stroch + 1, stolb);
                opener(stroch + 1, stolb + 1);
            }
            // правая
            if(surrroundMins[stroch][stolb] == 0 && stroch >= 1 && stroch <= (str - 2) && stolb == (stlb - 1)){
                surrroundMins[stroch][stolb] = 11;
                opener(stroch - 1, stolb);
                opener(stroch - 1, stolb - 1);
                opener(stroch, stolb - 1);
                opener(stroch + 1, stolb);
                opener(stroch + 1, stolb - 1);
            }
            // верхняя
            if(surrroundMins[stroch][stolb] == 0 && stroch == 0 && stolb >= 1 && stolb <= (stlb - 2)){
                surrroundMins[stroch][stolb] = 11;
                opener(stroch, stolb - 1);
                opener(stroch, stolb + 1);
                opener(stroch + 1, stolb - 1);
                opener(stroch + 1, stolb);
                opener(stroch + 1, stolb + 1);
            }
            // нижняя
            if(surrroundMins[stroch][stolb] == 0 && stroch == (str - 1) && stolb >= 1 && stolb <= (stlb - 1)){ // surrroundMins[stroch][stolb] == 0 && stroch == (str - 2) && stolb >= 1 && stolb <= (stlb - 2) было
                surrroundMins[stroch][stolb] = 11;
                opener(stroch, stolb - 1);
                opener(stroch, stolb + 1);
                opener(stroch - 1, stolb - 1);
                opener(stroch - 1, stolb);
                opener(stroch - 1, stolb + 1);
            }
        }

        private boolean cheakWin(){
            int num = 0;
            for(int i =0; i<str; i++){
                for(int j = 0; j<stlb; j++){
                    if(mini[i][j] && setFlag[i][j]){
                        num++;
                    }
                }
            }
            if(num == 10){
                return true;
            }
            else{
                return false;
            }
        }

        private void record(double r){
            failChit();
            int index = 0;
            boolean ifNet = false;
            for(int i = 0; i<kolTheBest; i++){
                if(r < bestTime[i]){
                    index = i;
                    ifNet = true;
                    break;
                }
            }
            if(ifNet) {
                for (int i = (kolTheBest - 1); i > index; i--) {
                    bestTime[i] = bestTime[i - 1];
                    bestName[i] = bestName[i - 1];
                }
                bestTime[index] = r;
                try {
                    String name = JOptionPane.showInputDialog("Введи имя)) Ты в 10-ке лучших");
                    bestName[index] = name;
                } catch (Exception ex) {
                    bestName[index] = "Indefinite";
                }
                failZapis();
            }
            spisokLychix();
        }

        private void failChit() {
            FileReader reader;
            Scanner chit;
            try{
                reader = new FileReader("liders.txt");
                chit = new Scanner(reader);
                int i = 0;
                while (chit.hasNext()){
                    bestTime[i] = chit.nextDouble();
                    bestName[i] = chit.next();
                    i++;
                }
                reader.close();
            }
            catch (Exception ex){
            }
        }

        private void failZapis(){
            Formatter zapis;
            try{
                zapis = new Formatter("liders.txt");
                for(int i = 0; i < kolTheBest; i++){
                    zapis.format("%f %s\n", bestTime[i], bestName[i]);
                }
                zapis.close();
            }
            catch (Exception ex){
            }
        }

        private void showTime(){
            endTime = System.currentTimeMillis();
            resultTime = endTime - startTime;
            double res = resultTime/1000;
            time.setText("       " + resultTime/1000 + "  ");
        }

        private void spisokLychix(){
            JOptionPane.showMessageDialog(null,
                    "1) " + bestName[0] + " --- " + bestTime[0] + "\n" +
                            "2) " + bestName[1] + " --- " + bestTime[1] + "\n" +
                            "3) " + bestName[2] + " --- " + bestTime[2] + "\n" +
                            "4) " + bestName[3] + " --- " + bestTime[3] + "\n" +
                            "5) " + bestName[4] + " --- " + bestTime[4] + "\n" +
                            "6) " + bestName[5] + " --- " + bestTime[5] + "\n" +
                            "7) " + bestName[6] + " --- " + bestTime[6] + "\n" +
                            "8) " + bestName[7] + " --- " + bestTime[7] + "\n" +
                            "9) " + bestName[8] + " --- " + bestTime[8] + "\n" +
                            "10) " + bestName[9] + " --- " + bestTime[9] + "\n" +
                            "//////////////////////////////////////////////////////////////////////////////////////\n" +
                            "Если есть желание то можете кинуть рубчик\n мне на мобилку))" +
                            "+375259550317",
                    "ЛУЧШИЕ!!!", JOptionPane.PLAIN_MESSAGE);
        }

        public void actionPerformed(ActionEvent event){
            if(event.getSource() == Liders){
                failChit();
                spisokLychix();
            }

            if(event.getSource() == start){
                //JOptionPane.showMessageDialog(null, "Вы начали новую игру!!!", "Сапёрчик", JOptionPane.PLAIN_MESSAGE);  //доп. диалоговые меню при запуске новой игры
                if(!cheakEnd){
                    end();
                }
                cheak = true;
                cheakEnd = false;
                zapoln();
            }

            if(cheak && !cheakTime) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (event.getSource() == mina[i][j] && !cheakerRight) {
                            endTime = System.currentTimeMillis();
                            resultTime = endTime - startTime;
                            time.setText("       " + resultTime / 1000 + "  ");
                            if (setFlag[i][j]) {
                                mina[i][j].setIcon(question);
                                mina[i][j].setBackground(Color.ORANGE);
                                setFlag[i][j] = false;
                                numFlajoks++;
                                kolMin.setText("      " + numFlajoks + "         ");
                                showTime();
                            }
                            else {
                                if (mini[i][j] == true) {
                                    JOptionPane.showMessageDialog(null, "Кто-то проебал!!!", "Сапёрчик", JOptionPane.PLAIN_MESSAGE);
                                    end();

                                } else {
                                    opener(i, j);
                                }
                                if (cheakWin() && !cheakTime) {
                                    cheakTime = true;
                                    endTime = System.currentTimeMillis();
                                    resultTime = endTime - startTime;
                                    double res = resultTime / 1000;
                                    JOptionPane.showMessageDialog(null, "Молодец ты выйграл!!!  " + res + " - Твоё время ", "Сапёрчик", JOptionPane.PLAIN_MESSAGE);
                                    record(res);
                                }
                            }
                        }
                        if ((event.getSource() == mina[i][j]) && cheakerRight && numFlajoks > 0  && !setFlag[i][j]) {
                            mina[i][j].setIcon(flag);
                            mina[i][j].setBackground(Color.BLACK);
                            setFlag[i][j] = true;
                            numFlajoks--;
                            kolMin.setText("      " + numFlajoks + "         ");
                            showTime();
                        }
                        else if (event.getSource() == mina[i][j] && cheakerRight && numFlajoks >= 0 && setFlag[i][j]) {
                            mina[i][j].setIcon(new ImageIcon());
                            mina[i][j].setBackground(Color.ORANGE);
                            setFlag[i][j] = false;
                            numFlajoks++;
                            kolMin.setText("      " + numFlajoks + "         ");
                            showTime();
                        }
                    }
                }
            }
        }
    }

    private class mishka extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                cheakerRight = true;
                ((JButton) e.getSource()).doClick();
                //System.out.println("правой кнопкой мыши");  // проверка на нажатие правой клавиши без дейятвий для левой
                cheakerRight = false;
            }
        }
    }

}

