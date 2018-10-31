package main;

import game.GameData;
import game.GameLogic;
import lombok.Setter;
import time.Timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class GuiClass extends JFrame{
    private FlowLayout layout;
    private ArrayList<ArrayList<JButton>> fields;
    private List<String> nombers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "11", "12", "13", "14", "15"));
    private List<String> allowedNombers;
    private static GameData gameData;
    public static GameData getGameData(){
        return gameData;
    }
    private static time.Timer timer;

    public GuiClass(){
        super("Piatniashki");
        getContentPane().setBackground(Color.getHSBColor(0, 0, 255));
        layout = new FlowLayout(1, 0, 0);
        setLayout(layout);

        timer = new time.Timer();
        JLabel time = new JLabel();
        time.setFont(new Font("Corsiva",Font.BOLD, 26));
        add(time);

        fields = new ArrayList<ArrayList<JButton>>();
        Randomiser randomiser = new Randomiser(nombers);
        int counter = 0;

        gameData = new GameData();
        gameData.setLevel(4);
        gameData.setNomberOfFields(16);
        gameData.setFields(fields);

        Handler handler = new Handler();
        handler.setTimer(timer);
        for(int i = 0; i < 4; i++ ){
            ArrayList<JButton> arrayList = new ArrayList<>();
            for(int j = 0; j< 4; j++){
                JButton jButton = new JButton(randomiser.getUnic());
                jButton.setPreferredSize(new Dimension(100,100));
                add(jButton);
                arrayList.add(jButton);
                jButton.addActionListener(handler);
                jButton.setBackground(Color.green);
                jButton.setFont(new Font("Verdana", Font.BOLD, 19));
                counter++;
                if(counter == 15){
                    JButton jButton1 = new JButton("?");
                    jButton1.setPreferredSize(new Dimension(100,100));
                    add(jButton1);
                    arrayList.add(jButton1);
                    arrayList.add(jButton1);
                    jButton1.setBackground(Color.white);
                    jButton1.setFont(new Font("Verdana", Font.BOLD, 19));
                    jButton1.addActionListener(handler);
                    break;
                }
            }
            fields.add(arrayList);
        }


        timer.start();
        timer.setLabel(time);
    }
}

class Randomiser{
    private List<String> list;
    public Randomiser(List<String> list) {
        this.list = list;
    }

    public String getUnic(){
        boolean flag = true;
        String str = "";
        while (flag){
            str = "";
            Random random = new Random();
            str += (random.nextInt(16));

            flag = !list.contains(str);
            list.remove(str);
        }
        return str;
    }
}

class Handler implements ActionListener{
    private static int counter = 0;
    private GameData gameData;
    private GameLogic gameLogic;
    @Setter
    private Timer timer;

    public Handler() {
        gameData = GuiClass.getGameData();
        gameLogic.setGameData(gameData);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(counter == 2){
            counter = 0;
        }
        if(counter == 0){
            gameData.setPressed1(e);
        }
        else if(counter == 1){
            gameData.setPressed2(e);
            logic();
        }
        counter++;
    }

    public void logic(){
        GameLogic.change();
        if(GameLogic.checkWin()){
            System.out.println("You is winner!!!!");
            timer.end();
            JOptionPane.showMessageDialog(null, "Your time is " + timer.getTime()/1000,
                    "Result of game", JOptionPane.PLAIN_MESSAGE);
        }
    }
}