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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

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
    
    private GasStation GasStation;
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
        this.RefreshListview();
    }
    
    public void AddGasStation()
    {
        
        if(!"".equals(TFtankstationname.getText()))
        {
            if(!"".equals(TFtanksationlocation.getText()))
            {
                if(!"".equals(TFtankstationprice.getText()))
                {
                   this.mainGUI.getPerson().getGasstations().add(GasStation = new GasStation(this.TFtankstationname.getText(),this.TFtanksationlocation.getText(),Integer.parseInt(this.TFtankstationprice.getText())));               
                   this.TFtankstationname.setText("");
                   this.TFtanksationlocation.setText("");
                   this.TFtankstationprice.setText("");
                   this.RefreshListview();
                   this.LVgasstations.getSelectionModel().clearSelection(0);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, this.mainGUI.getMessage("nogasstationprice"));
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, this.mainGUI.getMessage("nogasstationlocation"));
            }        
        }
        else
        {
            JOptionPane.showMessageDialog(null, this.mainGUI.getMessage("nogasstationname"));
        }
    }
    
    public void RemoveGasStation()
    {
       GasStation oldGasStation = null;
       for(GasStation temp: this.mainGUI.getPerson().getGasstations())
       {
           if(temp == this.LVgasstations.getSelectionModel().getSelectedItem())
           {
               oldGasStation = temp;
           }
       }
       
       if(oldGasStation != null)
       {
           this.mainGUI.getPerson().getGasstations().remove(oldGasStation);
           this.RefreshListview();
       }
    }
    
    public void UpdateGasStation()
    {
        if(!this.TFtankstationname.getText().equals("") && !this.TFtanksationlocation.getText().equals("") && !this.TFtankstationprice.getText().equals(""))
        {    

        for(GasStation temp : this.mainGUI.getPerson().getGasstations())
        {
            if(temp == this.LVgasstations.getSelectionModel().getSelectedItem())
            {
            this.RemoveGasStation();
            this.AddGasStation();
            }
        }
        this.RefreshListview(); 
        }
    }
    
    private void RefreshListview()
    {
        if(this.mainGUI.getPerson().getGasstations()!= null)
        {
            this.LVgasstations.setItems(FXCollections.observableList(this.mainGUI.getPerson().getGasstations()));
            
        }
        this.LVgasstations.getSelectionModel().clearSelection();
        
    }
    
    public void Setfields()
    {
       GasStation oldGasStation = null;
       for(GasStation temp: this.mainGUI.getPerson().getGasstations())
       {
           if(temp == this.LVgasstations.getSelectionModel().getSelectedItem())
           {
               oldGasStation = temp;
           }
       }
        if(oldGasStation != null)
        {
        this.TFtankstationname.setText(oldGasStation.getGasStationname());
        this.TFtanksationlocation.setText(oldGasStation.getGasStationlocation());
        this.TFtankstationprice.setText(oldGasStation.getGasStationprice() + "");
        }
    }
}
