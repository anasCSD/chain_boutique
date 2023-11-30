/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package final_project;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class UpdateProductController implements Initializable {

    @FXML
    private TextField productIdTextField;
    @FXML
    private TextField productNameTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, Integer> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Float> productPriceColumn;
    @FXML
    private TableColumn<Product, Integer> quantityColumn;
    private ObservableList<Product> productList= FXCollections.observableArrayList();

    public ObservableList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ObservableList<Product> productList) {
        this.productList = productList;
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
        
       // tableView.setItems(productList);
        // TODO
    }    

    @FXML
    private void addNewProduct(ActionEvent event) {
        int productId=Integer.parseInt(productIdTextField.getText());
        String productName= productNameTextField.getText();
        float productPrice= Float.parseFloat(priceTextField.getText());
        int quantity= Integer.parseInt(quantityTextField.getText());
        
        Product temp= new Product(productId,productName,productPrice,quantity);
        productList.add(temp);
        
    }

    @FXML
    private void updateProductInformation(ActionEvent event) {
    }

    @FXML
    private void addProductsToBinaryFile(ActionEvent event) {
        
      
            try{
                FileOutputStream fos = new FileOutputStream("ProductObjects.bin",true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                for(Product p: productList)
                    oos.writeObject(p);
                  //  tableView.setItems(p);
                    
                oos.close();
            }
            catch(Exception e){
                //SHOW e.toString() IN AN ALERT
            }
        }

    @FXML
    private void backHomePageOnClick(ActionEvent event) throws IOException {
        
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("customerScene.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);
        
        
        
        Stage someStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void removeProductOnClick(ActionEvent event) {
        ObservableList<Product> selectedRows, allProduct;
        allProduct = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(Product p: selectedRows){
            allProduct.remove(p);
        }
        
        
    }

    @FXML
    private void showProductOnClick(ActionEvent event) {
        ObjectInputStream ois = null;
            try {
                Product p;
                ois = new ObjectInputStream(new FileInputStream("ProductObjects.bin"));
                while (true) {
                    p = (Product) ois.readObject();
                   // productArr.add(p);
                   tableView.getItems().add(p);
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
    }
    }
    

