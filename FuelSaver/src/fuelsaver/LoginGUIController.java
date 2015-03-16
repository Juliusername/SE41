/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelsaver;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Alexander
 */
public class LoginGUIController implements Initializable {
    
    @FXML
    private Label label;
    
    private MainGUIController mainGUI;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    public void setValues(MainGUIController mainGUI) {
        this.mainGUI = mainGUI;
    }
    
    public void goToWachtwoordWijzigen() {
        this.mainGUI.goToWachtwoordWijzigen();
    }
}
