/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelsaver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Alexander
 */
public class LoginGUIController implements Initializable {
    
   
    private MainGUIController mainGUI;
    
    @FXML Label lblLogin;
    @FXML Label lblUsername;
    @FXML Label lblPassword;
    @FXML TextField tfUsername;
    @FXML PasswordField tfPassword;
    @FXML Button btnRegister;
    @FXML Button btnLogin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    public void setValues(MainGUIController mainGUI) {
        this.mainGUI = mainGUI;
    }
    
    public void login() {
        this.mainGUI.goToTabs();
    }
    
    public void goToRegister()
    {
        this.mainGUI.goToRegister();
    }
}
