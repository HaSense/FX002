package application.menu;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MenubarController implements Initializable {

  @FXML private TextArea textArea; 
  
  private Stage primaryStage;
    
  @Override
  public void initialize(URL location, ResourceBundle resources) {
        
  }

  //새로만들기
  public void handleNew(ActionEvent e){
    textArea.appendText("New\n");
  }
  //파일열기
  public void handleFileOpen(ActionEvent e){
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().addAll(
        new ExtensionFilter("Text Files", "*.txt"),
        new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
        new ExtensionFilter("Audio Files", "*.mp3", "*.wav", "*.aac"),
        new ExtensionFilter("All Files", "*.*")
        );
    File selectedFile = fileChooser.showOpenDialog(primaryStage);
    String selectedFilePath = selectedFile.getPath();
  }
  
  //primaryStage 가져오기
  public void setPrimaryStage(Stage primaryStage){
    this.primaryStage = primaryStage;
  }
}
