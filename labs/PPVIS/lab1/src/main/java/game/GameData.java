package game;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

@Data
public class GameData {
    private int level;
    private int nomberOfFields;

    private ActionEvent pressed1;
    private ActionEvent pressed2;

    private ArrayList<ArrayList<String>> nombers = new ArrayList<ArrayList<String>>();
    public String getNomber(int i, int j){
        return nombers.get(i).get(j);
    }
    private ArrayList<ArrayList<JButton>> fields;
    public JButton getField(int i, int j){
        return fields.get(i).get(j);
    }

    public GameData() {
        nombers.add(new ArrayList<>(Arrays.asList("1", "2", "3", "4")));
        nombers.add(new ArrayList<>(Arrays.asList("5", "6", "7", "8")));
        nombers.add(new ArrayList<>(Arrays.asList("9", "10", "11", "12")));
        nombers.add(new ArrayList<>(Arrays.asList("13", "14", "15", "?")));
    }

    public GameData(int level) {
        this.level = level;
    }


}
