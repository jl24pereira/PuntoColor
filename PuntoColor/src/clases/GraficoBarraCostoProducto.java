
package clases;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.awt.BorderLayout;
import java.util.Set;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/* @author JL Desk */
public class GraficoBarraCostoProducto {
    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";
    
    
    private ObservableList<Data> data2d = FXCollections.observableArrayList();
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    
    String titulo;
    String xLabel;
    String yLabel;
    
    public GraficoBarraCostoProducto(String titulo, String xLabel, String yLabel){
        this.titulo = titulo;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        createScene();
    }

 
   public void createScene() {
        
        
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");       
        series1.getData().add(new XYChart.Data(austria, 25601.34));
        series1.getData().add(new XYChart.Data(brazil, 20148.82));
        series1.getData().add(new XYChart.Data(france, 10000));
        series1.getData().add(new XYChart.Data(italy, 35407.15));
        series1.getData().add(new XYChart.Data(usa, 12000));      
        
        /*XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(austria, 57401.85));
        series2.getData().add(new XYChart.Data(brazil, 41941.19));
        series2.getData().add(new XYChart.Data(france, 45263.37));
        series2.getData().add(new XYChart.Data(italy, 117320.16));
        series2.getData().add(new XYChart.Data(usa, 14845.27)); */ 
        
        /*XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(austria, 45000.65));
        series3.getData().add(new XYChart.Data(brazil, 44835.76));
        series3.getData().add(new XYChart.Data(france, 18722.18));
        series3.getData().add(new XYChart.Data(italy, 17557.31));
        series3.getData().add(new XYChart.Data(usa, 92633.68)); */ 
        
        /*Scene scene  = new Scene(bc,800,600);
        bc.getData().add(series1);
        jfxPanel.setScene(scene);*/
    }
   
   public void addSerie(String nombre,String valores[], Number numeros[]){
       XYChart.Series serie = new XYChart.Series();
       serie.setName(nombre);
       for(int i=0; i<valores.length; i++){
           serie.getData().add(new XYChart.Data(valores[i], numeros[i]));
       }       
       //bc.getData().add(serie);
   }
   
   /*public JFXPanel panel(){
       //return jfxPanel;
   }*/
}
