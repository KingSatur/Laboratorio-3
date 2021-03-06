package view;

import java.io.IOException;
import java.net.URL;

import controller.ControllerMain;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		ControllerMain controller =  new ControllerMain(primaryStage);
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource(
			        "Main.fxml"
			    )
			);
			loader.setController(controller);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bascketball");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	
}
