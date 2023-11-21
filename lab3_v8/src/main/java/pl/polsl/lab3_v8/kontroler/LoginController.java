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
import javafx.stage.Stage;
import pl.polsl.lab3_v8.model.BlogException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import pl.polsl.lab3_v8.model.User;
import pl.polsl.lab3_v8.model.Users;
/**
 * FXML Controller class
 *
 * @author jakub
 */
public class LoginController implements Initializable {


    @FXML
    private Label blog;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private TextField textFieldPassword;
    @FXML
    private Button buttonLogin;
    
    Users users = new Users();
    @FXML
    private Label labelError;
    @FXML
    private Button backToMenu;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*textFieldPassword.setTextFormatter(new TextFormatter<>(change ->
            new TextFormatter.Change(change.getStart(), change.getEnd(),
                    change.getText().replaceAll(".", "•")))); */
    }    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
 public void switchToSideMenu(ActionEvent event) throws IOException{
     
     
     
     if(!(users.findUserByUsername(textFieldUsername.getText()) == null)){
         User loggedUser = users.findUserByUsername(textFieldUsername.getText());
     if(loggedUser.getPassword().equals(textFieldPassword.getText()))
     {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/lab3_v8/widok/sideMenu.fxml"));
     root = loader.load();
     
     SideMenuController sideMenuController = loader.getController();
     sideMenuController.getUsers(users);
     sideMenuController.getLoggedUser(loggedUser);
     
      //root = FXMLLoader.load(getClass().getResource("register.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
     }
     else{
         labelError.setText("Wrong password.");
     }
     }
     else{
         labelError.setText("Wrong username.");
     }
      
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
    
    
    public void getUsers(Users u){
        users = u;
    }
}
