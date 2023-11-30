/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package final_project;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author hp
 */
public class CartItemsController implements Initializable {

    @FXML
    private TableView<Product> cartTableView;
    @FXML
    private TableColumn<Product, Integer> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNamecolumn;
    @FXML
    private TableColumn<Product, Float> priceColumn;
    @FXML
    private TableColumn<Product, Integer> quantityColumn;
    private ObservableList<Product> cartList = FXCollections.observableArrayList();
    @FXML
    private Label totalPriceOutputLabel;
    private float totalPrice;

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    

    public ObservableList<Product> getCartList() {
        return cartList;
    }

    public void setCartList(ObservableList<Product> cartList) {
        this.cartList = cartList;
    }
    
    public float CalculatePrice() {
             float totalPrice=0f;
             
             for (Product e: cartList){
            
                totalPrice += e.getProductPrice();
                
            }
             this.setTotalPrice(totalPrice);
            return totalPrice;
    }
            
    
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        productIdColumn.setCellValueFactory(new PropertyValueFactory<Product,Integer>("productId"));
        productNamecolumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        cartTableView.setItems(cartList);
        // TODO
        float v = CalculatePrice();
        totalPriceOutputLabel.setText(Float.toString(v) );
    }    

    @FXML
    private void removeItemsOnClick(ActionEvent event) {
        ObservableList<Product> selectedRows, allProduct;
        allProduct = cartTableView.getItems();
        selectedRows = cartTableView.getSelectionModel().getSelectedItems();
        
        for(Product p: selectedRows){
            allProduct.remove(p);
        }
    }

    

    private void showCustomInformationAlert(String the_task_is_performed) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void proceedOrderOnclick(ActionEvent event) throws IOException {
        
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("PurchaseScene.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);
        
        PurchaseSceneController c = someLoader.getController();
        c.setCartList(this.cartList);
        c.setTotalPrice(this.totalPrice);
        
        Stage someStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
        
        
    }

   
    
}
