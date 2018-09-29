package model.entity;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Process  extends  AppEntity{

    private IntegerProperty id=new SimpleIntegerProperty();
    private IntegerProperty period=new SimpleIntegerProperty();
    private StringProperty name=new SimpleStringProperty();
    private StringProperty type=new SimpleStringProperty();
    private StringProperty subType=new SimpleStringProperty();
    private StringProperty phase=new SimpleStringProperty();
    private StringProperty status=new SimpleStringProperty();
    private StringProperty objective=new SimpleStringProperty();
    private ObjectProperty<LocalDate> duration=new SimpleObjectProperty<>();
    private ObjectProperty<User> owner=new SimpleObjectProperty<>();
    private ListProperty<Indicator> indicators=new SimpleListProperty<>();
    private ListProperty<Report> reports=new SimpleListProperty<>();
    private ListProperty<Resource> resources=new SimpleListProperty<>();

    public void setId(int id) {
        this.id.set(id);
    }

    public void setPeriod(int period) {
        this.period.set(period);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSubType() {
        return subType.get();
    }

    public StringProperty subTypeProperty() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType.set(subType);
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setPhase(String phase) {
        this.phase.set(phase);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public void setObjective(String objective) {
        this.objective.set(objective);
    }

    public void setDuration(LocalDate duration) {
        this.duration.set(duration);
    }

    public void setOwner(User owner) {
        this.owner.set(owner);
    }

    public void setIndicators(ObservableList<Indicator> indicators) {
        this.indicators.set(indicators);
    }

    public void setReports(ObservableList<Report> reports) {
        this.reports.set(reports);
    }

    public void setResources(ObservableList<Resource> resources) {
        this.resources.set(resources);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public int getPeriod() {
        return period.get();
    }

    public IntegerProperty periodProperty() {
        return period;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public String getPhase() {
        return phase.get();
    }

    public StringProperty phaseProperty() {
        return phase;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public String getObjective() {
        return objective.get();
    }

    public StringProperty objectiveProperty() {
        return objective;
    }

    public LocalDate getDuration() {
        return duration.get();
    }

    public ObjectProperty<LocalDate> durationProperty() {
        return duration;
    }

    public User getOwner() {
        return owner.get();
    }

    public ObjectProperty<User> ownerProperty() {
        return owner;
    }

    public ObservableList<Indicator> getIndicators() {
        return indicators.get();
    }

    public ListProperty<Indicator> indicatorsProperty() {
        return indicators;
    }

    public ObservableList<Report> getReports() {
        return reports.get();
    }

    public ListProperty<Report> reportsProperty() {
        return reports;
    }

    public ObservableList<Resource> getResources() {
        return resources.get();
    }

    public ListProperty<Resource> resourcesProperty() {
        return resources;
    }
}
