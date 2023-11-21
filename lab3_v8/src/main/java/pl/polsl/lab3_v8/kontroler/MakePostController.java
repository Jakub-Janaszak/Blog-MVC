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
import pl.polsl.lab3_v8.model.User;
import pl.polsl.lab3_v8.model.Users;
import pl.polsl.lab3_v8.model.Post;
import pl.polsl.lab3_v8.model.Posts;
/**
 * FXML Controller class
 *
 * @author jakub
 */
public class MakePostController implements Initializable {


    @FXML
    private Label blog;
    @FXML
    private Button buttonPublish;
    @FXML
    private Button buttonBack;
    
    User loggedUser = new User(999,"","");
    @FXML
    private TextField textFieldTitle;
    @FXML
    private TextField textFieldContent;
    @FXML
    private Label labelError;
    
    Posts posts = new Posts();
    
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
 public void switchToSideMenu(ActionEvent event) throws IOException{
     
     
     
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/lab3_v8/widok/sideMenu.fxml"));
     root = loader.load();
     
     SideMenuController sideMenuController = loader.getController();
     sideMenuController.getLoggedUser(loggedUser);
     sideMenuController.getPosts(posts);

     
      //root = FXMLLoader.load(getClass().getResource("register.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
      
        
 }
 
 public void makePost(ActionEvent event) throws IOException{
     
     if(!textFieldTitle.getText().isEmpty() && !textFieldContent.getText().isEmpty()){
         
     Post post = new Post(textFieldTitle.getText(),textFieldContent.getText(),loggedUser);
     posts.addNewPost(post);
         
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/lab3_v8/widok/sideMenu.fxml"));
     root = loader.load();
     
     SideMenuController sideMenuController = loader.getController();
     sideMenuController.getLoggedUser(loggedUser);
     sideMenuController.getPosts(posts);
     
      //root = FXMLLoader.load(getClass().getResource("register.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
     }
     else{
         labelError.setText("Title and content can't be empty.");
     }
      
        
 }
    
    
    public void getLoggedUser(User u){
        loggedUser = u;
    }
    
    public void getPosts(Posts p){
        posts = p;
    }
    
}
