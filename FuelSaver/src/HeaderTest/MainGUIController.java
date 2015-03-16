/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HeaderTest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Julius
 */
public class MainGUIController {
    
    @FXML
    private AnchorPane apContent;
    
    @FXML
    private void BtnWachtwoordWijzigenClick(ActionEvent event)
    {
        try {
            apContent.getChildren().setAll((AnchorPane)FXMLLoader.load(getClass().getResource("WachtwoordWijzigenGUI.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(MainGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
