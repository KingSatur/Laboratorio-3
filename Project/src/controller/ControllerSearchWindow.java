package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerSearchWindow implements Initializable {

	private Stage myStage;
	private ControllerMain m;
	
	public ControllerSearchWindow(Stage stage, ControllerMain m) {
		this.myStage = stage;
		this.m = m;
	}
	
	public void setMainStage(Stage stageOne) {
		myStage.initOwner(stageOne);
	}
	
    @FXML
    private ComboBox<String> staticOne;
    
    @FXML
    private ComboBox<String> staticTwo;

    @FXML
    private CheckBox checkTwoStatic;

    @FXML
    private Button searchFinally;

    @FXML
    private TextField valueOfStaticTwo;

    @FXML
    private TextField valueOfStaticOne;
	
    
    @FXML
    void isPressed(ActionEvent event) {
    	if(checkTwoStatic.isSelected()) {
    		staticTwo.setVisible(true);
    		valueOfStaticTwo.setVisible(true);
    	}
    	else {
    		staticTwo.setVisible(false);
    		valueOfStaticTwo.setVisible(false);
    	}
    }

    @FXML
    void staticOnePressed(ActionEvent event) {
    	
    }

    @FXML
    void staticTwoPressed(ActionEvent event) {

    }
    
    @FXML
    void searcPressed(ActionEvent event) {
    	
    	if((staticOne.getValue() != null) && !(staticOne.getValue().equals("Value of Static")) && (!(staticOne.getValue().equals(""))) && (!(valueOfStaticOne.getText().equals("Value of Static")) && (!(valueOfStaticOne.getText().equals(""))))){
    		m.setStaticOne(staticOne.getValue());
    		m.setValueOfStaticOne(Integer.parseInt(valueOfStaticOne.getText()));
    		m.chargueStaticsOne();
    	}
    	if(checkTwoStatic.isSelected() == true) {
    		if((staticTwo.getValue() != null) && !(staticTwo.getValue().equals("Value of Static")) && (!(staticTwo.getValue().equals(""))) && (!(valueOfStaticTwo.getText().equals("Value of Static")) && (!(valueOfStaticTwo.getText().equals(""))))){
    			m.setStaticTwo(staticTwo.getValue());
    			m.setValueOfStaticTwo(Integer.parseInt(valueOfStaticTwo.getText()));
    			m.chargueStaticsTwo();
    		}
    	}
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<String> items = FXCollections.observableArrayList("pointsForMatch", "rebounds", "assistences", "ballThefts", "locks");
		staticOne.setItems(items);
		staticTwo.setItems(items);
	}
    
	
	
}
