/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package final_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CustomerSceneController implements Initializable {

    @FXML
    private Menu shoppingMenu;
    @FXML
    private MenuItem searchProductOnClick;
    @FXML
    private Menu returnAndExchange;
    @FXML
    private Menu customerSupport;
    @FXML
    private Menu customerSupport1;
    @FXML
    private Menu customerSupport11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //if (shoppingMenu.isSelected()
        // TODO
    }    

    @FXML
    private void logOutOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("UserLogin.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);
        
        
        
        Stage someStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
       
    }

    @FXML
    private void SearchProductOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("Product.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);
        
        
        
        Stage someStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
        
    }
    
}
