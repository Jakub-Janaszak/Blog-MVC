/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.lab3_v8.kontroler;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.polsl.lab3_v8.model.BlogException;

import pl.polsl.lab3_v8.model.User;
import pl.polsl.lab3_v8.model.Users;

/**
 * FXML Controller class
 *
 * @author jakub
 */
public class RegisterController implements Initializable {

    @FXML
    private Button buttonCreateAccount;
   @FXML
    private TextField textFieldUsername;
    @FXML
    private TextField textFieldPassword;
    
    Users users = new Users();
    @FXML
    private Button backToMenu;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    public void switchToMainMenu(ActionEvent event) throws IOException, BlogException{
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/lab3_v8/widok/mainMenu.fxml"));
     root = loader.load();
     
     String username = textFieldUsername.getText();
     String password = textFieldPassword.getText();
     
     if(!username.isEmpty() && !password.isEmpty())
     users.addNewUser(new User(users.getListOfUsers().size(), username, password));     
     
     MainMenuController mainMenuController = loader.getController();
     mainMenuController.getUsers(users);
     mainMenuController.initialize(null, null);
       
      //root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
 }
    
 public void backToMainMenu(ActionEvent event) throws IOException{
     
     
     
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/lab3_v8/widok/mainMenu.fxml"));
     root = loader.load();
     
     //MainMenuController mainMenuController = loader.getController();
     
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
      
        
 }
    
    
    
    public void displayName(String username){
       //text1.setText("Hello: "+ username);
    }
    
    public void getUsers(Users u){
        users = u;
    }
    
}
