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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Alexander
 */
public class OverviewGUIController implements Initializable {
    private MainGUIController mainGUI;

    @FXML Button btnBack;
    @FXML Button btnMaps;
    @FXML Button btnOV;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setValues(MainGUIController mainGUI) {
        this.mainGUI = mainGUI;
        this.mainGUI.resizeHeight(850);
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
