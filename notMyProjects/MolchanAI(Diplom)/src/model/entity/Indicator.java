package model.entity;

import javafx.beans.property.*;

public class Indicator extends  AppEntity{
    private IntegerProperty id=new SimpleIntegerProperty();

    private StringProperty name=new SimpleStringProperty();
    private StringProperty type=new SimpleStringProperty();

    private DoubleProperty value=new SimpleDoubleProperty();
    private DoubleProperty upperLimit=new SimpleDoubleProperty();
    private DoubleProperty lowerLimit=new SimpleDoubleProperty();
    private DoubleProperty plan=new SimpleDoubleProperty();
    private StringProperty deviation=new SimpleStringProperty();

    private StringProperty own=new SimpleStringProperty();

    private ObjectProperty<Process> owner=new SimpleObjectProperty<>();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public double getValue() {
        return value.get();
    }

    public DoubleProperty valueProperty() {
        return value;
    }

    public void setValue(double value) {
        this.value.set(value);
    }

    public double getUpperLimit() {
        return upperLimit.get();
    }

    public DoubleProperty upperLimitProperty() {
        return upperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit.set(upperLimit);
    }

    public double getLowerLimit() {
        return lowerLimit.get();
    }

    public DoubleProperty lowerLimitProperty() {
        return lowerLimit;
    }

    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit.set(lowerLimit);
    }

    public double getPlan() {
        return plan.get();
    }

    public DoubleProperty planProperty() {
        return plan;
    }

    public void setPlan(double plan) {
        this.plan.set(plan);
    }

    public Process getOwner() {
        return owner.get();
    }

    public ObjectProperty<Process> ownerProperty() {
        return owner;
    }

    public void setOwner(Process owner) {
        this.owner.set(owner);
    }

    public String getOwn() {
        return own.get();
    }

    public StringProperty ownProperty() {
        return own;
    }

    public void setOwn(String own) {
        this.own.set(own);
    }

    public void setDeviation(String deviation) {
        this.deviation.set(deviation);
    }

    public String getDeviation() {
        return deviation.get();
    }

    public StringProperty deviationProperty() {
        return deviation;
    }
}
