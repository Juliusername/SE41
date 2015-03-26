/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuelsaver;

import fuelsaver.LoginGUIController;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.stage.Stage;

/**
 *
 * @author Julius / Alexander
 */
public class MainGUIController implements Initializable {
    @FXML
    public AnchorPane apContent;
    
    private Locale language;
    private Scenes currentScene;
    
    private Person person;
    private ArrayList<Car> Cars = new ArrayList<Car>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.language = Locale.KOREAN;
        goToLogin();
        this.person = new Person();
    }
    
    public ArrayList<Car> getCars()
    {
        return this.Cars;
    }
    
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public String getMessage(String key) {
        return ResourceBundle.getBundle("resources.lang", language).getString(key);
    }
    
    public void changeDutch() {
        language = Locale.KOREAN;
        refreshLanguage();
    }
    
    public void changeEnglish() {
        language = Locale.ENGLISH;
        refreshLanguage();
    }
    
    private void refreshLanguage() {
        switch(currentScene) {
            case WACHTWOORDWIJZIGEN:
                goToWachtwoordWijzigen();
                break;
            case TABS:
                goToTabs();
                break;
            case CHANGECAR:
                goToChangeCar();
                break;
            case CHANGEGASSTATIONS:
                goToChangeGasStations();
                break;
            case OVERVIEW:
                goToOverview();
                break;
            case REGISTER:
                goToRegister();
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
    
    public void goToTabs() {
        this.currentScene = Scenes.TABS;
        FXMLLoader fxmlLoader = this.replaceContent("TabsGUI.fxml");
        ((TabsGUIController) fxmlLoader.getController()).setValues(this);
    }
    
    public void goToChangeCar() {
        this.currentScene = Scenes.CHANGECAR;
        FXMLLoader fxmlLoader = this.replaceContent("ChangeCarGUI.fxml");
        ((ChangeCarGUIController) fxmlLoader.getController()).setValues(this);
    }
    
    public void goToChangeGasStations() {
        this.currentScene = Scenes.CHANGEGASSTATIONS;
        FXMLLoader fxmlLoader = this.replaceContent("ChangeGasStationsGUI.fxml");
        ((ChangeGasStationsGUIController) fxmlLoader.getController()).setValues(this);
    }
    
    public void goToOverview() {
        this.currentScene = Scenes.OVERVIEW;
        //this.apContent.getScene().
        FXMLLoader fxmlLoader = this.replaceContent("OverviewGUI.fxml");
        ((OverviewGUIController) fxmlLoader.getController()).setValues(this);
    }
    
    public void goToRegister() {
        this.currentScene = Scenes.REGISTER;
        FXMLLoader fxmlLoader = this.replaceContent("RegisterGUI.fxml");
        ((RegisterGUIController) fxmlLoader.getController()).setValues(this);
    }
    
    public void resizeHeight(int height)
    {
        Stage stage = (Stage) this.apContent.getScene().getWindow();
        stage.setHeight(height);
    }
}
