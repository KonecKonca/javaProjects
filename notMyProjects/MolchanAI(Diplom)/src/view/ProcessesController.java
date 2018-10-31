package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.IParentWindow;
import model.URLHolder;
import model.entity.Indicator;
import model.entity.Process;
import model.entity.User;
import model.repository.ProcessRepository;
import model.specification.process.AllProcessesSpecification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessesController  {
    private ObservableList<Process> processes = FXCollections.observableArrayList();
    @FXML
    private  TreeView processTreeView;
    @FXML
    private BorderPane processDetailsPane;
    @FXML
    private TableView table;
    @FXML
    private void initialize() {
        ObservableList<Indicator> list = FXCollections.observableArrayList();

        TableColumn<Indicator,String> c1 = new TableColumn<>("Название");
        TableColumn<Indicator,String> c2 = new TableColumn<>("Процесс");
        TableColumn<Indicator,String> c3 = new TableColumn<>("Значение");
        TableColumn<Indicator,String> c4 = new TableColumn<>("Минимум");
        TableColumn<Indicator,String> c5 = new TableColumn<>("Максимум");
        TableColumn<Indicator,String> c6 = new TableColumn<>("План");
        TableColumn<Indicator,String> c7 = new TableColumn<>("Отклонение");

        // Defines how to fill data for each cell.
        // Get value from property of UserAccount. .
        c1.setCellValueFactory(new PropertyValueFactory<Indicator,String>("name"));
        c2.setCellValueFactory(new PropertyValueFactory<Indicator,String>("own"));
        c3.setCellValueFactory(new PropertyValueFactory<Indicator,String>("value"));
        c4.setCellValueFactory(new PropertyValueFactory<Indicator,String>("lowerLimit"));
        c5.setCellValueFactory(new PropertyValueFactory<Indicator,String>("upperLimit"));
        c6.setCellValueFactory(new PropertyValueFactory<Indicator,String>("plan"));
        c7.setCellValueFactory(new PropertyValueFactory<Indicator,String>("deviation"));

        Indicator i=new Indicator();
        i.setName("Количество изменений");
        i.setOwn("Управление изменениями");
        i.setValue(4);
        i.setLowerLimit(0);
        i.setUpperLimit(10);
        i.setPlan(3);
        i.setDeviation("+1");
        list.add(i);

        Indicator it=new Indicator();
        it.setName("Затраты на производственные изменения");
        it.setOwn("Управление изменениями");
        it.setValue(250);
        it.setLowerLimit(210);
        it.setUpperLimit(270);
        it.setPlan(260);
        it.setDeviation("-10");
        list.add(it);

//        table.setRowFactory((param)->new ColorRow());
       // c1.setCellValueFactory(new PropertyValueFactory<Indicator,String>(""));

        /*emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));*/

        // Display row data
     /*   ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Количество изменений");
        list.add("Управление изменениями");
        list.add("4");
        list.add("0");
        list.add("10");
        list.add("3");
        list.add("+1");*/

        table.setItems(list);

        table.getColumns().addAll(c1, c2, c3, c4, c5, c6,c7);



        TreeItem<String> rootItem = new TreeItem<>("xx");
        rootItem.setExpanded(true);


        //String query="SELECT  FROM user, process WHERE process.owner=";

     /*  ProcessRepository repo=new ProcessRepository();
            List<Process> proc= repo.query(new AllProcessesSpecification());
            for(int i=0;i<proc.size();i++){
                processes.add(proc.get(i));
                TreeItem<String> item = new TreeItem<>(processes.get(i).getType());
                rootItem.getChildren().add(item);
            }

        processTreeView.setRoot(rootItem);*/
     /*   processTreeView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> processes.add((Process) newValue));*/
    }


    @FXML
    public void handleProcessTreeItemClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(URLHolder.processDetailsURL);
            try {
                BorderPane view=(BorderPane) loader.load();
                processDetailsPane.setCenter(view);
                ProcessDetailsController controller=loader.getController();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @FXML
    public void handleEditButtonClick() {
        StackPane secondaryLayout = new StackPane();
        Scene scene = new Scene(secondaryLayout,380.0, 350.0);

        Stage newWindow = new Stage();
        newWindow.setScene(scene);
        newWindow.show();

        showProcessEditor(secondaryLayout);
    }

    private void showProcessEditor(StackPane pane){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(URLHolder.processEditorURL);
        try {
            BorderPane view=(BorderPane) loader.load();
            pane.getChildren().add(view);
            // ProcessesController controller=loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleDeleteButtonClick() {}


   /* @Override
    public void updateProcess(Process process) {
        for(int i=0;i<processes.size();i++){
            if(processes.get(0).getId()==process.getId()){
                processes.add(processes.indexOf(processes.get(0)),process);
            }
        }
    }

    @Override
    public void deleteProcess(Process process) {
        for(Process p:processes){
            if(p.getId()==process.getId()){
                processes.remove(p);
            }
        }

    }

    @Override
    public void addProcess(Process process) {
        processes.add(process);
    }*/
}
