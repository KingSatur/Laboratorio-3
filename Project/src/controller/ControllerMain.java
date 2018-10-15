package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Equipo;

public class ControllerMain implements Initializable {
	
    @FXML
    private TableView<?> tablePlayer;

    @FXML
    private Button toSearch;

    @FXML
    void searchPressed(ActionEvent event) throws IOException {
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/SearchWindow.fxml"));
		ControllerMain m = new ControllerMain();
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bascketball");
		primaryStage.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
