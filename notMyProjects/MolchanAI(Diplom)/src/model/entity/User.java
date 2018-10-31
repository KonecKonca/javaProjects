package model.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User   extends  AppEntity{
    private String login;
    private IntegerProperty id=new SimpleIntegerProperty();
    private StringProperty password=new SimpleStringProperty();
    private StringProperty name=new SimpleStringProperty();
    private StringProperty  surname=new SimpleStringProperty();
    private StringProperty  role=new SimpleStringProperty();

    public void setId(int id) {
        this.id.set(id);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public int getId() {

        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public String getRole() {
        return role.get();
    }

    public StringProperty roleProperty() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
