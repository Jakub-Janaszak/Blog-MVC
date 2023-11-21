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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.polsl.lab3_v8.model.Post;
import pl.polsl.lab3_v8.model.Posts;
import pl.polsl.lab3_v8.model.User;
import java.util.List;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.polsl.lab3_v8.model.Users;

/**
 * FXML Controller class
 *
 * @author jakub
 */
public class ViewBlogController implements Initializable {

    Users users = new Users();
    User loggedUser = new User(999,"","");
    
    Posts posts = new Posts();
    
    
    
    @FXML
    private Label blog;
    @FXML
    private Button buttonBack;
    @FXML
    private TableView<Post> table;
    @FXML
    private TableColumn<Post, String> username;
    @FXML
    private TableColumn<Post, String> title;
    @FXML
    private TableColumn<Post, String> content;
    @FXML
    private Button button;
    /**
     * Initializes the controller class.
     */
    
    List<String> getUsenamesFromPosts(Posts p){
        List <String> usernames = null;
        for(int i=0; i<p.getListOfPosts().size(); i++){
            usernames.add(p.getListOfPosts().get(i).getUsernameOfAuthor());
        }
        return usernames;
    }
    
    ObservableList<Post> list = FXCollections.observableArrayList(
            new Post("eh","meh",new User(44,"gageweg","ewew"))
    );
    
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        posts.setListOfPosts(users, "posts.txt");
        ObservableList<Post> observableListOfPosts = FXCollections.observableArrayList(posts.getListOfPosts());
        //Post post = new Post("ew","fuj",loggedUser);
        //posts.addNewPost(post);
        //username.setCellValueFactory(new PropertyValueFactory<Post, String>("usernameOfAuthor"));
        username.setCellValueFactory(new PropertyValueFactory<Post, String>("usernameOfAuthor"));
     title.setCellValueFactory(new PropertyValueFactory<Post, String>("title"));
     content.setCellValueFactory(new PropertyValueFactory<Post, String>("content"));
     table.setItems(observableListOfPosts);
        
    }    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    @FXML
 public void click(ActionEvent event) throws IOException{
     
     
 }
 
    @FXML
 public void switchToSideMenu(ActionEvent event) throws IOException{
     
     
     
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/pl/polsl/lab3_v8/widok/sideMenu.fxml"));
     root = loader.load();
     
     SideMenuController sideMenuController = loader.getController();
     sideMenuController.getLoggedUser(loggedUser);
     sideMenuController.getPosts(posts);
     sideMenuController.getUsers(users);

     
      //root = FXMLLoader.load(getClass().getResource("register.fxml"));
      stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
       
 }
 
 public void getLoggedUser(User u){
        loggedUser = u;
    }
    
    public void getPosts(Posts p){
        posts = p;
    }
    
    public void getUsers(Users u){
        users = u;
    }

}
