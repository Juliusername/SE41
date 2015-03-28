/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuelsaver;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class OverviewGUIController implements Initializable {
    private MainGUIController mainGUI;
    private String beginPosition;
    private String endPosition;
    private boolean ov;

    @FXML Button btnBack;
    @FXML Button btnMaps;
    @FXML Button btnOV;
    @FXML AnchorPane apOV;
    @FXML Label lblANB;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void setValues(MainGUIController mainGUI, String beginPosition, String endPosition, boolean ov) {
        this.mainGUI = mainGUI;
        this.mainGUI.resizeHeight(850);
        this.beginPosition = beginPosition;
        this.endPosition = endPosition;
        
        lblANB.setText(this.beginPosition+" "+mainGUI.getMessage("to")+" "+this.endPosition);
        this.ov = ov;
        apOV.setVisible(this.ov);
        if(!this.ov)
        {
            this.btnBack.setLayoutY(400);
            this.mainGUI.resizeHeight(500);
        }
        else
        {
            this.mainGUI.resizeHeight(850);
        }
    }
    
    public void back()
    {
        this.mainGUI.resizeHeight(500);
        this.mainGUI.goToTabs();
    }
    
    public void clickMaps()
    {
        System.out.println("map");
        try {
            Desktop.getDesktop().browse(new URI("https://www.google.nl/maps"));
        } catch (IOException ex) {
            Logger.getLogger(OverviewGUIController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(OverviewGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clickOV()
    {
        System.out.println("map");
        try {
            Desktop.getDesktop().browse(new URI("http://www.9292ov.nl"));
        } catch (IOException ex) {
            Logger.getLogger(OverviewGUIController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(OverviewGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
