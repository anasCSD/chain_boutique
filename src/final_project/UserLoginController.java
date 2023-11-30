/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package final_project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class UserLoginController implements Initializable {

    @FXML
    private TextField userIdTextField;
    @FXML
    private ComboBox<String> userTypeCombo;
    @FXML
    private PasswordField passwordField;
    
    
    
        int v=0;
        void verify(){
            ArrayList<User> userArr = new ArrayList<>();
            ObjectInputStream ois = null;
            try {
                User u;
                ois = new ObjectInputStream(new FileInputStream("userObjects.bin"));
                while (true) {
                    u = (User) ois.readObject();
                    userArr.add(u);
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
            
            for(User w: userArr){
                if(Integer.parseInt(userIdTextField.getText())== w.getId() && passwordField.getText()==w.getPass())
                {
                    v=1;
                }
            }
        }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        String[] users={"Boutique Owner", "Customer","Supplier","Accountant","Store Manager","Inventory Manager","Sales Associate","Human ResourcesnPersonnel"};
        userTypeCombo.getItems().addAll(users);
        
                
       // User temp =new User(id,pass,userType);
        
        
        
        // TODO
    }    

    @FXML
    private void logInOnClick(ActionEvent event) throws IOException {
        if (v==1){
         if(userTypeCombo.getValue()=="Customer" )// && verify=="true" )
        {
            FXMLLoader loader = new FXMLLoader();
                    Parent nextSceneParent;
                    loader.setLocation(getClass().getResource("customerScene.fxml"));
                    nextSceneParent = loader.load();
                    
                    Scene nextScene = new Scene(nextSceneParent);
                    Stage sameStage = (Stage)((Node)event.getSource()).getScene().getWindow();       
                    sameStage.setScene(nextScene);
                    sameStage.show();
                    sameStage.setTitle("Customer");
        }
        else if(userTypeCombo.getValue()=="Supplier" )//&& verify=="true" )
        {
            FXMLLoader loader = new FXMLLoader();
                    Parent nextSceneParent;
                    loader.setLocation(getClass().getResource("SupplierScene.fxml"));
                    nextSceneParent = loader.load();
                    
                    Scene nextScene = new Scene(nextSceneParent);
                    Stage sameStage = (Stage)((Node)event.getSource()).getScene().getWindow();       
                    sameStage.setScene(nextScene);
                    sameStage.show();
                    sameStage.setTitle("Supplier");
        }
        else{
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Warning Alert");
        a.setContentText("Something Went Wrong!");
        a.setHeaderText(null);
        a.showAndWait();
        }
    }

    
    
    } 

    @FXML
    private void signUpOnclick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);
        
        
        
        Stage someStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }
}
   
   

    

        
    

   
    
