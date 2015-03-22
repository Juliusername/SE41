/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelsaver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class RegisterGUIController implements Initializable {
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
        this.mainGUI.goToLogin();;
    }
}
