/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelsaver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

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
    @FXML TextField TFbrand;
    @FXML TextField TFtype;
    @FXML TextField TFfuealusage;
    
    private Car car;
    
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
    
    public void AddCar()
    {
        
        if(TFbrand.getText() != null)
        {
            if(TFtype.getText() != null)
            {
                if(TFfuealusage.getText() != null)
                {
                   car = new Car(this.TFbrand.getText(),this.TFtype.getText(),Integer.parseInt(this.TFfuealusage.getText()));
                   this.LVcarlist.setItems(FXCollections.observableList(car.getCars()));
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "%No Fuealusage");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "%No type");
            }        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "%No brand");
        }
    }
    
    public void RemoveCar()
    {
        
    }
    
    public void UpdateCar()
    {
        
    }
    
}
