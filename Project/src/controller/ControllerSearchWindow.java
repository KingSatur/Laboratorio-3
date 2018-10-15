package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class ControllerSearchWindow {


    @FXML
    private ComboBox<?> staticOne;

    @FXML
    private ComboBox<?> staticTwo;

    @FXML
    private CheckBox checkTwoStatic;

    @FXML
    private Button searchFinally;

    @FXML
    private TextArea valueOfStaticTwo;

    @FXML
    private TextArea valueOfStaticOne;
	
    
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
    
	
}
