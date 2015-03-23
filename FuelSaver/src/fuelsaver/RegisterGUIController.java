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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class RegisterGUIController implements Initializable {
    @FXML TextField tfUsername;
    @FXML PasswordField pwPassword;
    @FXML PasswordField pwRepeatPassword;
    
    private MainGUIController mainGUI;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void setValues(MainGUIController mainGUI) {
        this.mainGUI = mainGUI;
    }
    
    public void goToLogin()
    {
        this.mainGUI.goToLogin();
    }
    
    public void register()
    {
        try {
            if(tfUsername.getText() == null || pwPassword.getText() == null || pwRepeatPassword.getText() == null) {
                throw new IllegalArgumentException("%incomplete");
            }
            if(!pwPassword.getText().equals(pwRepeatPassword.getText())) {
                throw new IllegalArgumentException("%passwordsEx");
            }
        } catch(IllegalArgumentException iaEx) {
            JOptionPane.showMessageDialog(null, iaEx.getMessage());
        }
        mainGUI.setPerson(new Person(tfUsername.getText(), pwPassword.getText()));
        this.mainGUI.goToLogin();;
    }
}
