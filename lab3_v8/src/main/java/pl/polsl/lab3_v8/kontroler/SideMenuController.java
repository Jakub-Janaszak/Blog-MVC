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
public class SideMenuController implements Initializable {

    @FXML
    private Button buttonMakePost;
    @FXML
    private Label blog;
    @FXML
    private Button buttonViewBlog;
    @FXML
    private Button buttonLogout;
    
    Users users = new Users();
    User loggedUser = new User(999,"ouu","blad");
    
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
 public void switchToMakePost(ActionEvent event) throws IOException{
     
     
     
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/lab3_v8/widok/makePost.fxml"));
     root = loader.load();
     
     MakePostController makePostController = loader.getController();
     makePostController.getLoggedUser(loggedUser);
     makePostController.getPosts(posts);
     
      //root = FXMLLoader.load(getClass().getResource("register.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
      
        
 }
 
 @FXML
 public void switchToViewBlog(ActionEvent event) throws IOException{
     
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/lab3_v8/widok/viewBlog.fxml"));
     root = loader.load();
     
     ViewBlogController viewBlogController = loader.getController();
     viewBlogController.getLoggedUser(loggedUser);
     viewBlogController.getPosts(posts);
     viewBlogController.getUsers(users);
     
      //root = FXMLLoader.load(getClass().getResource("register.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
      
        
 }
 
 
 @FXML
 public void switchToMainMenu(ActionEvent event) throws IOException{
     
     
     
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
    
    public void getLoggedUser(User u){
        loggedUser = u;
    }
    
    public void getPosts(Posts p){
        posts = p;
    }
    
}
