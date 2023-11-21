package pl.polsl.lab3_v8.model;

import java.util.ArrayList;
import java.util.List;

import pl.polsl.lab3_v8.model.Post;
import pl.polsl.lab3_v8.model.Users;
import pl.polsl.lab3_v8.kontroler.FileHandler;

/**
 * Manages a list of posts, allowing for adding new posts, getting a list of posts, and setting the list of posts.
 * 
 * @version 1.0
 * @author Jakub Janszak
 */
public class Posts {

    /**
     * List of posts.
     */
    private List<Post> postsList = new ArrayList<Post>();

    /**
     * Default constructor.
     */
    public Posts() {
    }

    /**
     * Adds a new post to the list and saves it to a file.
     * 
     * @param p The post to add.
     */
    public void addNewPost(Post p) {
        if(p!=null){
        postsList.add(p);
        FileHandler fh = new FileHandler();
        fh.saveToFile("posts.txt", p.getTitle());
        fh.saveToFile("posts.txt", p.getContent());
        fh.saveToFile("posts.txt", String.valueOf(p.getAuthor().getId_user()));
        }
    }

    /**
     * Gets the list of posts.
     * 
     * @return The list of posts.
     */
    public List<Post> getListOfPosts() {
        return postsList;
    }

    /**
     * Gets a post at a specified index.
     * 
     * @param index The index of the post.
     * @return The post at the specified index.
     */
    public Post getPost(int index) {
        return postsList.get(index);
    }

    /**
     * Sets the list of posts based on data read from a file.
     * 
     * @param users The user manager to find users by ID.
     */
    public void setListOfPosts(Users users, String fileName) {
    List<String> listOfLines = new ArrayList<String>();
    FileHandler fh = new FileHandler();
    
    // Dodaj warunek sprawdzający, czy ścieżka pliku nie jest null
    if (fileName != null && fh.readFromFile(fileName) != null) {
        listOfLines = fh.readFromFile(fileName);

        String title = "";
        String content = "";
        int id;

        for (int i = 0; i < listOfLines.size(); i++) {
            if (i % 3 == 0) {
                title = listOfLines.get(i);
            } else if (i % 3 == 1) {
                content = listOfLines.get(i);
            } else {
                id = Integer.parseInt(listOfLines.get(i));
                User author = users.findUserById(id);
                if (author != null) {
                    postsList.add(new Post(title, content, author));
                }
            }
        }
    }
}
    
    
    
    
}
