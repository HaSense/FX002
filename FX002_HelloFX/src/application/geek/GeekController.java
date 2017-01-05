package application.geek;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GeekController implements Initializable {

  @FXML private Button btn1;
  @FXML private ImageView imgView;
  @FXML private CheckBox chk1, chk2;
  
  static int count = 1;
  
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    
  }
  
  public void handleBtnShowAction(ActionEvent e){
    
    Image img;
    
    if(count%2==1){
      img = new Image("http://docs.oracle.com/javafx/"
          + "javafx/images/javafx-documentation.png");  
    }else{
      img = new Image("file:geek.gif");  
    }
    count++;
    
    imgView.setImage(img);
  }
  
  public void handleChkAction(ActionEvent e){
    if(chk1.isSelected() && chk2.isSelected()){
      imgView.setImage(new Image("file:image/geek--gh-.gif"));
    }else if(chk2.isSelected()){
      imgView.setImage(new Image("file:image/geek---h-.gif"));
    }else if(chk1.isSelected()){
      imgView.setImage(new Image("file:image/geek--g--.gif"));
    }else if(!chk1.isSelected() && !chk2.isSelected()){
      imgView.setImage(new Image("file:image/geek-----.gif"));
    }
  }
  
}

