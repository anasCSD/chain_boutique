/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package final_project;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class PurchaseSceneController implements Initializable {

    
    private float totalPrice;
    private ObservableList<Product> cartList = FXCollections.observableArrayList();
    @FXML
    private TextArea checkOutTextArea;
    
    public ObservableList<Product> getCartList() {
        return cartList;
    }

    public void setCartList(ObservableList<Product> cartList) {
        this.cartList = cartList;
    }
    
    

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        for (Product p : cartList){
            checkOutTextArea.setText(p.toString());
            
        }
        
        checkOutTextArea.setText("Total Price: " + this.getTotalPrice());
        
        
        
    }    

    @FXML
    private void confirmPurchaseOnClick(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
         a.setHeaderText("Confirm your opinion");
         a.setContentText("Are you sure to confirm order?");
         
          Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
             
            // show bill
            
            
            showCustomInformationAlert("The task is performed.");
        }
        else{
            
            showCustomInformationAlert("The task is cancelled!"); 
        }
        
    }

    private void showCustomInformationAlert(String the_task_is_performed) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}

