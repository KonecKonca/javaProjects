package main;

import main.GuiClass;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args){
        GuiClass grafon = new GuiClass();
        grafon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // крестик закрытия работает
        grafon.setResizable(false);
        grafon.setSize(406,458);
        grafon.setVisible(true);
    }
}
