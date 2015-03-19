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
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class ChangeCarGUIController implements Initializable {
    
    private MainGUIController mainGUI;

    @FXML ListView LVcarlist;
    @FXML Button BTreturnmenu;
    @FXML Button Btaddcar;
    @FXML Button Btremovecar;
    @FXML Label configstation;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.LVcarlist.getItems().add("Chevrolet Kalos");
    }    
    
    public void Gotoinstellingen()
    {
        this.mainGUI.goToTabs();
    }
    
    public void setValues(MainGUIController mainGUI) {
        this.mainGUI = mainGUI;
    }
    
}
