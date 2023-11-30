/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package final_project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField userContactTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private PasswordField createPassField;
    @FXML
    private PasswordField confirmPassField;
    @FXML
    private ComboBox<String> userTypeCombo;
    @FXML
    private DatePicker dobDatePicker;
    
   // ArrayList<User> userList = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] users={"Boutique Owner", "Customer","Supplier","Accountant","Store Manager","Inventory Manager","Sales Associate","Human ResourcesnPersonnel"};
        userTypeCombo.getItems().addAll(users);
        
        
    }    

    @FXML
    private void signUpSubOnClick(ActionEvent event) throws Exception {
        int id =Integer.parseInt(idTextField.getText());
        String name= userNameTextField.getText();
        int contact =Integer.parseInt(userContactTextField.getText());
        String address=addressTextField.getText();
        LocalDate dob =dobDatePicker.getValue();
        String pass=createPassField.getText();
        if(confirmPassField.getText().equals(pass)){
            pass=confirmPassField.getText();
            
        }
        else{
            Alert a= new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Alert");
            a.setHeaderText("Fatal Error");
            a.setContentText("Password doesn't match");
            a.showAndWait();
            
        }
        String userType=userTypeCombo.getValue();
        
        //User user= new User(id,name,contact,address,dob,pass,userType);
       // userList.add(user);
        
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("UserObjects.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
           
            
            User u= new User(id,name,contact,address,dob,pass,userType);
         
          
            
            oos.writeObject(u);
            

        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

   
    }

    @FXML
    private void backHomePageOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("UserLogin.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);
        
        
        
        Stage someStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
        
        
    }

    
}
