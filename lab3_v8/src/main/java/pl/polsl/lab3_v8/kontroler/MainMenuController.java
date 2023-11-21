/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.lab3_v8.kontroler;

import pl.polsl.lab3_v8.kontroler.LoginController;
import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.polsl.lab3_v8.model.Post;

import pl.polsl.lab3_v8.model.User;
import pl.polsl.lab3_v8.model.Users;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;


/**
 * FXML Controller class
 *
 * @author jakub
 */
public class MainMenuController implements Initializable {

    @FXML
    private Button buttonRegister;
    @FXML
    private TextField textFiled1;
    @FXML
    private Label blog;
    
    Users users = new Users();
    @FXML
    private Button buttonLogin;
    
    
    ObservableList<User> list = FXCollections.observableArrayList(
            new User(2,"fwe","342")
    );
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //if(!users.getListOfUsers().isEmpty())
        //blog.setText(users.getListOfUsers().get(0).getUsername());
        
       
    }    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
 
    @FXML
 public void switchToRegister(ActionEvent event) throws IOException{
     
     
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/lab3_v8/widok/register.fxml"));
     root = loader.load();
     
     
     
     RegisterController registerController = loader.getController();
     registerController.getUsers(users);
     
      //root = FXMLLoader.load(getClass().getResource("register.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
      
        
 }
 
 @FXML
 public void switchToLogin(ActionEvent event) throws IOException{
     
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/lab3_v8/widok/login.fxml"));
     root = loader.load();
     
     LoginController loginController = loader.getController();
     loginController.getUsers(users);
     
      //root = FXMLLoader.load(getClass().getResource("register.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
      
 }
 
 
    public void getUsers(Users u){
        users = u;
    }
}
