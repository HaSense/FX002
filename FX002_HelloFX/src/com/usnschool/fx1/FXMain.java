package com.usnschool.fx1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMain extends Application implements Initializable {
  
  @FXML private Button btn1;
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    
      Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
      Scene scene = new Scene(root);
      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.setTitle("FXApp Test");
      primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    btn1.setOnAction(new EventHandler<ActionEvent>() {      
      @Override
      public void handle(ActionEvent event) {
        handleBtn1Action(event);        
      }
    });
    btn1.setOnAction(event->handleBtn1Action(event));
  }
  public void handleBtn1Action(ActionEvent event){
    System.out.println("버튼1 클릭");
  }
}
