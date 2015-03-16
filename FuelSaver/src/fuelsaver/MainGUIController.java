/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuelsaver;

import fuelsaver.LoginGUIController;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Julius / Alexander
 */
public class MainGUIController implements Initializable {
    @FXML
    private AnchorPane apContent;
    
    private Locale language;
    private Scenes currentScene;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.language = Locale.KOREAN;
        goToLogin();
    }   
    
    public void changeDutch() {
        this.language = Locale.KOREAN;
        refreshLanguage();
    }
    
    public void changeEnglish() {
        this.language = Locale.ENGLISH;
        refreshLanguage();
    }
    
    private void refreshLanguage() {
        switch(currentScene) {
            case WACHTWOORDWIJZIGEN:
                goToWachtwoordWijzigen();
                break;
            default:
                goToLogin();
                break;
        }
    }
    
    private FXMLLoader replaceContent(String fxml) {
        try {
            URL location = getClass().getResource(fxml);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            fxmlLoader.setResources(ResourceBundle.getBundle("resources.lang", language));
            Parent root = (Parent) fxmlLoader.load(location.openStream());
            apContent.getChildren().setAll(root);
            return fxmlLoader;
        } catch (IOException ex) {
            Logger.getLogger(MainGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void goToLogin() {
        this.currentScene = Scenes.LOGIN;
        FXMLLoader fxmlLoader = this.replaceContent("LoginGUI.fxml");
        ((LoginGUIController)fxmlLoader.getController()).setValues(this);
    }
    
    public void goToWachtwoordWijzigen() {
        this.currentScene = Scenes.WACHTWOORDWIJZIGEN;
        FXMLLoader fxmlLoader = this.replaceContent("WachtwoordWijzigenGUI.fxml");
        ((WachtwoordWijzigenController)fxmlLoader.getController()).setValues(this);
    }
}
