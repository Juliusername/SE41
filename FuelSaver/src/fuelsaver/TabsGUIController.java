/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelsaver;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class TabsGUIController implements Initializable {
    @FXML TabPane tabPane;
    
    // Settings
    @FXML Tab tabSettings;
    @FXML Label lblUsername;
    @FXML TextField tfCurrentCar;
    @FXML ListView lvCurrentGasStations;
    
    // Calculate
    @FXML Tab tabCalculate;
    @FXML TextField tfStartPosition;
    @FXML TextField tfEndPosition;
    @FXML CheckBox chbCompare;
    
    private MainGUIController mainGUI;
    private static Tabs selectedTab = Tabs.NONE;
    private boolean initialized = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setValues(MainGUIController mainGUI) {
        this.mainGUI = mainGUI;
        switch(selectedTab) {
            case CALCULATE:
                tabPane.getSelectionModel().select(tabCalculate);
                break;
            case SETTINGS:
                tabPane.getSelectionModel().select(tabSettings);
                break;
            default:
                //TODO
                break;
        }
        initialized = true;
        lblUsername.setText("Henkie94");
        tfCurrentCar.setText("Chevrolet Kalos");
        lvCurrentGasStations.getItems().add("Texaco Eindhoven");
        lvCurrentGasStations.getItems().add("Shell Eindhoven");
    }
    
    public void selectTab() {
        if(this.initialized) {
            if(tabCalculate.isSelected()) {
                selectedTab = Tabs.CALCULATE;
            } else if (tabSettings.isSelected()) {
                selectedTab = Tabs.SETTINGS;
            }
        }
    }
    
    public void changePassword() {
        this.mainGUI.goToWachtwoordWijzigen();
    }
    
    public void changeCar() {
        this.mainGUI.goToChangeCar();
    }
    
    public void changeGasStations() {
        this.mainGUI.goToChangeGasStations();
    }
    
    public void signOut() {
        selectedTab = Tabs.NONE;
        this.mainGUI.goToLogin();
    }
    
    public void calculate() {
        this.mainGUI.goToOverview();
    }
}
