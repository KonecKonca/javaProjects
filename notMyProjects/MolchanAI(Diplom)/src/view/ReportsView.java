package view;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class ReportsView {
    @FXML
    LineChart <?,?> lineChart;
    @FXML
    public void initialize(){
       // lineChart.setTitle("Average salary per age");

       XYChart.Series data = new XYChart.Series<>();

        //Defining X axis
       /* NumberAxis xAxis = new NumberAxis(1960, 2020, 10) ;
        xAxis.setLabel("Дни") ;

//Defining y axis
        NumberAxis yAxis = new NumberAxis(0, 350, 50) ;
        yAxis.setLabel("Значение") ;*/

       // lineChart=new LineChart(xAxis,yAxis);

        data.getData().add(new XYChart.Data(1, 54));
        data.getData().add(new XYChart.Data(2, 66));
        data.getData().add(new XYChart.Data(3, 72));
        data.getData().add(new XYChart.Data(4, 91));
        data.getData().add(new XYChart.Data(5, 72));
        data.getData().add(new XYChart.Data(6, 56));

       lineChart.getData().add(data);

    }
}
