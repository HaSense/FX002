package application.menu;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMenubarTest extends Application {
  
	@Override
	public void start(Stage primaryStage) {
	  
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("root.fxml"));
      Parent root = loader.load();
      
      MenubarController controller = loader.getController();
      controller.setPrimaryStage(primaryStage);
      
      Scene scene = new Scene(root);
    
      primaryStage.setTitle("AppMain");
      primaryStage.setScene(scene);
      primaryStage.show();
        
    } catch (IOException e) {
      e.printStackTrace();
    }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


