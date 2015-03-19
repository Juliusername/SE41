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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class ChangeGasStationsGUIController implements Initializable {
    private MainGUIController mainGUI;

    
    @FXML ListView LVgasstations;
    @FXML Button BTupdategasstation;
    @FXML Button BTaddgasstation;
    @FXML Button BTremovegasstation;
    @FXML TextField TFtankstationname;
    @FXML TextField TFtanksationlocation;
    @FXML TextField TFtankstationprice;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.LVgasstations.getItems().add("Texaco Eindhoven");
        this.LVgasstations.getItems().add("Shell Eindhoven");
    }    
    
    public void Gotoinstellingen()
    {
        this.mainGUI.goToTabs();
    }
    
    public void setValues(MainGUIController mainGUI) {
        this.mainGUI = mainGUI;
    }
}
