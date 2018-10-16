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
	
	private Stage myStage;
	
	public ControllerMain(Stage stage) {
		myStage = stage;
	}
	
    public Stage getMyStage() {
		return myStage;
	}

	public void setMyStage(Stage myStage) {
		this.myStage = myStage;
	}

	@FXML
    private TableView<?> tablePlayer;

    @FXML
    private Button toSearch;

    @FXML
    void searchPressed(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
		ControllerSearchWindow controller =  new ControllerSearchWindow(stage);
		FXMLLoader loader = new FXMLLoader(
			    getClass().getResource(
			        "/view/SearchWindow.fxml"
			    )
			);
		controller.setMainStage(myStage);
		loader.setController(controller);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Bascketball");
		stage.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
