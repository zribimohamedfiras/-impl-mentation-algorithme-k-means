/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class BubbleChartSample extends Application {
    public static ArrayList<cluster> t=new ArrayList<cluster>();
    private ArrayList<XYChart.Series> k;
 public BubbleChartSample()
 {
     k=new ArrayList<XYChart.Series>();
 }
    @Override public void start(Stage stage) {
        stage.setTitle("k-means");
        final NumberAxis xAxis = new NumberAxis(0, 30, 2);
        final NumberAxis yAxis = new NumberAxis(0, 30, 2);
        final BubbleChart<Number,Number> blc = new BubbleChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("critère 1");
        yAxis.setLabel("critère 2");
        blc.setTitle("classification");
       
        for (int i = 0; i < t.size(); i++) {
            k.add(new XYChart.Series());
        }
        
        for (int i = 0; i < t.size(); i++) {
            k.get(i).setName("cluster"+(i+1));
            for (int j = 0; j < t.get(i).getClusters().size(); j++) {
                k.get(i).getData().add(new XYChart.Data(t.get(i).getClusters().get(j).getPoint().get(0),t.get(i).getClusters().get(j).getPoint().get(1)));
            }
            
        }
        
        
                       
        Scene scene  = new Scene(blc);
        for (int i = 0; i < k.size(); i++) {
            blc.getData().add(k.get(i));
        }
        
        //blc.getData().addAll(series1, series2,series3);           
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}

