package view;

import javafx.scene.control.TableRow;
import model.entity.Indicator;

public class ColorRow extends TableRow<Indicator> {


    @Override
    protected void updateItem(Indicator item, boolean empty) {
        super.updateItem(item, empty);
        if(item.getOwn().contains("+")){
            this.getStyleClass().add("greenRow");
        } else this.getStyleClass().add("redRow");
    }
}
