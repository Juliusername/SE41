/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuelsaver;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Julius / Alexander
 */
public class FuelSaver extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {        
        URL location = getClass().getResource("MainGUI.fxml");  
        FXMLLoader fxmlLoader = new FXMLLoader();  
        fxmlLoader.setLocation(location);  
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());  
        fxmlLoader.setResources(ResourceBundle.getBundle("resources.lang", Locale.KOREAN));
        Parent root = (Parent) fxmlLoader.load(location.openStream());
        
        Scene scene = new Scene(root);
        
        stage.setTitle("FuelSaver");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
