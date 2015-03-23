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
import javax.swing.JOptionPane;

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
        Person p = mainGUI.getPerson();
        if(p.getUsername().equals(tfUsername.getText()) && p.getPassword().equals(tfPassword.getText())) {
            this.mainGUI = mainGUI;
        } else {
            JOptionPane.showMessageDialog(null, "Uw inloggegevens zijn onjuist.");
        }
    }
    
    public void login() {
        this.mainGUI.goToTabs();
    }
    
    public void goToRegister()
    {
        this.mainGUI.goToRegister();
    }
}
