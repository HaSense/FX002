package application.graphic.draw;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class BasicOpsTest extends Application {

	@Override
	public void start(Stage primaryStage) {
	  primaryStage.setTitle("그리기 연습");
	  Group root = new Group();
	  Canvas canvas = new Canvas(300, 250);
	  GraphicsContext gc = canvas.getGraphicsContext2D();
	  
	  gc.strokeLine(10, 10, 200, 200);
	  gc.strokeRoundRect(10, 10, 200, 200, 30.0, 30.0);
	  
	  root.getChildren().add(canvas);
	  primaryStage.setScene(new Scene(root));
	  primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
