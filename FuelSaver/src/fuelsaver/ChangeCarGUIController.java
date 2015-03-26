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
    @FXML Button BTupdatecar;
    @FXML TextField TFbrand;
    @FXML TextField TFtype;
    @FXML TextField TFfuealusage;
    
    private Car car;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
    }    
    
    public void Gotoinstellingen()
    {
        this.mainGUI.goToTabs();
    }
    
    public void setValues(MainGUIController mainGUI) {
        this.mainGUI = mainGUI;
        RefreshListview();
    }
    
    public void AddCar()
    {
        
        if(!"".equals(TFbrand.getText()))
        {
            if(!"".equals(TFtype.getText()))
            {
                if(!"".equals(TFfuealusage.getText()))
                {
                   this.mainGUI.getCars().add(car = new Car(this.TFbrand.getText(),this.TFtype.getText(),Integer.parseInt(this.TFfuealusage.getText())));
                   this.mainGUI.getPerson().setCar(car);
                   this.TFbrand.setText("");
                   this.TFtype.setText("");
                   this.TFfuealusage.setText("");
                   this.RefreshListview();
                   this.LVcarlist.getSelectionModel().clearSelection(0);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, this.mainGUI.getMessage("nocarfuelusage"));
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, this.mainGUI.getMessage("nocartype"));
            }        
        }
        else
        {
            JOptionPane.showMessageDialog(null, this.mainGUI.getMessage("nocarbrand"));
        }
    }
    
    public void RemoveCar()
    {
       Car oldcar = null;
       for(Car temp: this.mainGUI.getCars())
       {
           if(temp == this.LVcarlist.getSelectionModel().getSelectedItem())
           {
               oldcar = temp;
           }
       }
       
       if(oldcar != null)
       {
           this.mainGUI.getCars().remove(oldcar);
           this.mainGUI.getPerson().setCar(null);
           this.RefreshListview();
       }
    }
    
    public void UpdateCar()
    {
        if(!this.TFbrand.getText().equals("") && !this.TFtype.getText().equals("") && !this.TFfuealusage.getText().equals(""))
        {    

        for(Car temp : this.mainGUI.getCars())
        {
            if(temp == this.LVcarlist.getSelectionModel().getSelectedItem())
            {
            this.RemoveCar();
            this.AddCar();
            }
        }
        this.RefreshListview(); 
        }
    }
    
    private void RefreshListview()
    {
        if(this.mainGUI.getCars() != null)
        {
            this.LVcarlist.setItems(FXCollections.observableList(this.mainGUI.getCars()));
            if (this.mainGUI.getCars().size() > 0) {
                this.Btaddcar.setDisable(true);
                this.Btremovecar.setDisable(false);
                this.BTupdatecar.setDisable(false);
            }
            else
            {
                this.Btaddcar.setDisable(false);
                this.Btremovecar.setDisable(true);
                this.BTupdatecar.setDisable(true);
            }
        }
        this.LVcarlist.getSelectionModel().clearSelection();
        
    }
    
    public void Setfields()
    {
       Car oldcar = null;
       for(Car temp: this.mainGUI.getCars())
       {
           if(temp == this.LVcarlist.getSelectionModel().getSelectedItem())
           {
               oldcar = temp;
           }
       }
        if(oldcar != null)
        {
        this.TFbrand.setText(oldcar.getBrand());
        this.TFtype.setText(oldcar.getType());
        this.TFfuealusage.setText(oldcar.getFuelusage() + "");
        }
    }
}
