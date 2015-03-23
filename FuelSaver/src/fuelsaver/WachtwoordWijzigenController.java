/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuelsaver;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Julius
 */
public class WachtwoordWijzigenController {
    @FXML PasswordField pwOldPassword;
    @FXML PasswordField pwNewPassword;
    @FXML PasswordField pwRepeatPassword;
    
    private MainGUIController mainGUI;
    
    public void setValues(MainGUIController mainGUI) {
        this.mainGUI = mainGUI;
    }
    
    public void backToTabs() {
        this.mainGUI.goToTabs();
    }
    
    public void savePassword()
    {
        try {
            if(pwOldPassword.getText().isEmpty() || pwNewPassword.getText().isEmpty() || pwRepeatPassword.getText().isEmpty()) {
                throw new IllegalArgumentException("%incomplete");
            }
            if(!pwOldPassword.getText().equals(mainGUI.getPerson().getPassword())) {
                throw new IllegalArgumentException("%incorrectPassword");
            }
            if(!pwNewPassword.getText().equals(pwRepeatPassword.getText())) {
                throw new IllegalArgumentException("%passwordEx");
            }
            
            mainGUI.getPerson().setPassword(pwNewPassword.getText());
            this.backToTabs();
        } catch (IllegalArgumentException iaEx) {
            JOptionPane.showMessageDialog(null, iaEx.getMessage());
        }
    }
}
