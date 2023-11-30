/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package final_project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ProductController implements Initializable {

    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, Integer> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Float> productPriceColumn;
    @FXML
    private ComboBox<String> filteringCombo;
    private ObservableList<Product> productArr= FXCollections.observableArrayList();
    private ObservableList<Product> cartList= FXCollections.observableArrayList();
    private ObservableList<Product> wishList= FXCollections.observableArrayList();

    public ObservableList<Product> getCartList() {
        return cartList;
    }

    public void setCartList(ObservableList<Product> cartList) {
        this.cartList = cartList;
    }
    
    

    @FXML
    private TableColumn<Product,Integer > quantityColumn;

    public ObservableList<Product> getProductArr() {
        return productArr;
    }

    public void setProductArr(ObservableList<Product> productArr) {
        this.productArr = productArr;
    }
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         productIdColumn.setCellValueFactory(new PropertyValueFactory<Product,Integer>("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
            ObjectInputStream ois = null;
            try {
                Product p;
                ois = new ObjectInputStream(new FileInputStream("ProductObjects.bin"));
                while (true) {
                    p = (Product) ois.readObject();
                   // productArr.add(p);
                   productTableView.getItems().add(p);
                    }
                }   catch(RuntimeException e){
            e.printStackTrace();
             //
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
                   
        }
        // TODO
       
       // productTableView.setItems(productArr);
    }    

    @FXML
    private void addCartOnClick(ActionEvent event) {
        ObservableList<Product> selectedRows;
        //allProduct = productTableView.getItems();
        selectedRows = productTableView.getSelectionModel().getSelectedItems();
        
        for(Product p: selectedRows){
            cartList.add(p);
        }
        
    }

    @FXML
    private void showCartItemsOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("CartItems.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);
        
        CartItemsController c = someLoader.getController();
        c.setCartList(this.cartList);
        
        Stage someStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void addToWishListOnClick(ActionEvent event) {
        ObservableList<Product> selectedRows;
        //allProduct = productTableView.getItems();
        selectedRows = productTableView.getSelectionModel().getSelectedItems();
        
        for(Product p: selectedRows){
            wishList.add(p);
        }
    }

    private void removeOnClick(ActionEvent event) {
        ObservableList<Product> selectedRows, allProduct;
        allProduct = productTableView.getItems();
        selectedRows = productTableView.getSelectionModel().getSelectedItems();
        
        for(Product p: selectedRows){
            allProduct.remove(p);
        }
        
        
    }
    
    
}
