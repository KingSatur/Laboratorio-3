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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Player;


public class ControllerMain implements Initializable {
	
	private String staticOne;
	private int valueOfStaticOne;
	private String staticTwo;
	private int valueOfStaticTwo;
	private Stage myStage;
	
	@FXML
	private TableView<Player> tablePlayer;
	
	@FXML
	private Button toSearch;
	
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
    void searchPressed(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
		ControllerSearchWindow controller =  new ControllerSearchWindow(stage, this);
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
		
		
		//VOLVER A ELIMINAR LAS STATICS

		for(int i = tablePlayer.getColumns().size() - 1; i > 2 ; i --) {
			tablePlayer.getColumns().remove(i);
		}
		
		
		
    }
        
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
//    	TableColumn name = new TableColumn("Name");
//    	name.setResizable(false);
//    	name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
//    	TableColumn team = new TableColumn("Team");
//    	team.setResizable(false);
//    	team.setCellValueFactory(new PropertyValueFactory<Player, String>("team"));
//    	TableColumn age = new TableColumn("age");
//    	age.setResizable(false);
//    	age.setCellValueFactory(new PropertyValueFactory<Player, String>("age"));
//    	tablePlayer.getColumns().addAll(name, team, age);

		
	}
	
	public void chargueStaticsOne() {
		
//    	if(staticOne != null) {
//        	TableColumn static1 = new TableColumn(staticOne);
//        	static1.setCellValueFactory(new PropertyValueFactory<Player, String>(staticOne));
//        	tablePlayer.getColumns().addAll(static1);
//    	}
  
	}
	
	public void chargueStaticsTwo() {

//    	if(staticTwo != null) {
//    		TableColumn static2 = new TableColumn(staticTwo);
//        	static2.setCellValueFactory(new PropertyValueFactory<Player, String>(staticTwo));
//        	tablePlayer.getColumns().addAll(static2);
//    	}
    			
	}

	public String getStaticOne() {
		return staticOne;
	}

	public void setStaticOne(String staticOne) {
		this.staticOne = staticOne;
	}

	public int getValueOfStaticOne() {
		return valueOfStaticOne;
	}

	public void setValueOfStaticOne(int valueOfStaticOne) {
		this.valueOfStaticOne = valueOfStaticOne;
	}

	public String getStaticTwo() {
		return staticTwo;
	}

	public void setStaticTwo(String staticTwo) {
		this.staticTwo = staticTwo;
	}

	public int getValueOfStaticTwo() {
		return valueOfStaticTwo;
	}

	public void setValueOfStaticTwo(int valueOfStaticTwo) {
		this.valueOfStaticTwo = valueOfStaticTwo;
	}

	public TableView<Player> getTablePlayer() {
		return tablePlayer;
	}

	public void setTablePlayer(TableView<Player> tablePlayer) {
		this.tablePlayer = tablePlayer;
	}

	public Button getToSearch() {
		return toSearch;
	}

	public void setToSearch(Button toSearch) {
		this.toSearch = toSearch;
	}
	
	
	
}
