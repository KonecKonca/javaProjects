package model.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Resource  extends  AppEntity {
    private IntegerProperty id;
    private StringProperty name;
    //выборка из энам
    private StringProperty type;
}
