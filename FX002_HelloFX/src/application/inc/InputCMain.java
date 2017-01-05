package application.inc;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InputCMain extends Application {

	@Override
	public void start(Stage primaryStage) {
	  try {
      Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
      Scene scene = new Scene(root);
      
      primaryStage.setTitle("입력 컨트롤 연습");
      primaryStage.setScene(scene);
      primaryStage.show();
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
	}

	public static void main(String[] args) {
		launch(args);
	}
}
