package application.inc;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class InputController implements Initializable {

  @FXML private ComboBox<String> comboPublic;
  
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    comboPublic.getItems().removeAll(comboPublic.getItems());
    comboPublic.getItems().addAll("공개", "비공개");
    comboPublic.getSelectionModel().select("공개");
  }
  
  public void handleBtnRegAction(ActionEvent e){
    
  }
  public void handleBtnCancelAction(ActionEvent e){
    
  }
  
}
