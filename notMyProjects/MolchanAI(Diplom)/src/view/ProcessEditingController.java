package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.IParentWindow;
import model.IProsessModel;
import model.ProcessModel;
import model.methodology.CobitPhase;
import model.methodology.CobitSubType;
import model.entity.User;
import model.methodology.ItilSubType;
import model.repository.UserRepository;
import model.specification.user.AllUsersSpecification;

import java.util.List;


public class ProcessEditingController {
    private String typeValue;
    private String subTypeValue;
    private String phaseValue;
    private String ownerValue;
    private String statusValue;

   private  ObservableList<String> phaseList=FXCollections.observableArrayList();

   private IProsessModel model;

   private IParentWindow parent;
    @FXML
    private TextField name;
    @FXML
    private TextField duration;
    @FXML
    private TextField period;
    @FXML
    private CheckBox itilCheckBox;
    @FXML
    private CheckBox cobitCheckBox;
    @FXML
    private ComboBox subType;
    @FXML
    private ComboBox phase;
    @FXML
    private ComboBox status;
    @FXML
    private TextField objective;
    @FXML
    private ComboBox owner;
    @FXML
    private BorderPane layout;

    @FXML
    private void initialize() {
        initTypes();
        initSubTypes();
        initOwner();
        initPhase();
        initStatusValue();
    }

    private void initTypes(){
        ObservableList<String> list=FXCollections.observableArrayList();

        itilCheckBox.setOnAction((ActionEvent ev) -> {
            if(!list.isEmpty()){
                list.clear();
            }
            for (ItilSubType t : ItilSubType.values()) {
                list.add(t.getName());
            }
            typeValue="itil";
        });

        cobitCheckBox.setOnAction((ActionEvent ev) -> {
            if(!list.isEmpty()){
                list.clear();
            }
            for (CobitSubType t : CobitSubType.values()) {
                list.add(t.getName());
            }
            typeValue="cobit";
        });

        subType.setItems(list);
    }

    private void initSubTypes(){
        subType.setOnAction((Event ev) -> {
            subTypeValue =  subType.getSelectionModel().getSelectedItem().toString();
            phase.setEditable(true);
            if(!phaseList.isEmpty()){
                phaseList.clear();
            }
            if(subTypeValue.equals(CobitSubType.PlanOrganise.getName())){
                for (CobitPhase ph : CobitPhase.values()) {
                    phaseList.add(ph.getName());
                }
                phase.setItems(phaseList);
            }
        });
    }

    private void initOwner(){
        ObservableList<String> owners=FXCollections.observableArrayList();
        UserRepository uRepo=new UserRepository();
        List<User> users=uRepo.query(new AllUsersSpecification());
        for(User u:users){
            owners.add(u.getName());
        }
        owner.setItems(owners);
        owner.setOnAction((Event ev) -> {
            ownerValue =  owner.getSelectionModel().getSelectedItem().toString();
        });
    }

    private void initPhase(){
        phase.setEditable(false);
        phase.setOnAction((Event ev) -> {
            phaseValue =  phase.getSelectionModel().getSelectedItem().toString();
        });
    }

    private void initStatusValue(){
        ObservableList<String> statuses=FXCollections.observableArrayList();
        statuses.add("На исполнении");
        statuses.add("Выполнен");
        status.setItems(statuses);
        status.setOnAction((Event ev) -> {
            statusValue =   status.getSelectionModel().getSelectedItem().toString();
        });
    }


    public void handleSaveButtonClick(){
        model=new ProcessModel(typeValue,name.getText(),phaseValue,statusValue,
                objective.getText(), ownerValue, period.getText(),duration.getText(),
                subTypeValue);
        model.pushProcess();
       handleCancelButtonClick();
    }


    public void handleCancelButtonClick(){
        Stage stage = (Stage)layout.getScene().getWindow();
        stage.close();
    }
}
