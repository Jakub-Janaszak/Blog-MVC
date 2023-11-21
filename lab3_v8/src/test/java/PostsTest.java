/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import pl.polsl.lab3_v8.model.HumanVerification;
import pl.polsl.lab3_v8.model.Posts;
import pl.polsl.lab3_v8.model.Post;
import pl.polsl.lab3_v8.model.User;
import pl.polsl.lab3_v8.model.Users;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import pl.polsl.lab3_v8.kontroler.Input;
//import pl.polsl.lab3_v8.widok.Output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @version 1.0
 * @author jakub
 */
public class PostsTest {
    
    private Posts posts;
    private Users users;

    @BeforeEach
    public void setUp() {
        posts = new Posts();
        users = new Users();
    }
    
    @ParameterizedTest
    @CsvSource({
            "Test Title, Test Content, 1",
            "Another Title, Another Content, 2",
            "Invalid Title, Valid Content, invalidUserId"
    })
    
    /**
     * Test adding new posts.
     * @param title Title of the post
     * @param content Content of the post
     * @param userId User ID
     */
    public void testAddNewPost(String title, String content, String userId) {
        // Given
        User user = new User(1, "testUser", "testPassword");
        users.getListOfUsers().add(user);
        Post post = new Post(title, content, user);

        // When
        posts.addNewPost(post);

        // Then
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of("poststest.txt"));
            assertEquals(3, lines.size());
            assertEquals(title, lines.get(0));
            assertEquals(content, lines.get(1));
            assertEquals(userId.equals("invalidUserId") ? "" : userId, lines.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
/**
     * Test setting the list of posts from a file.
     * @param title Title of the post
     * @param content Content of the post
     * @param userId User ID
     */    
@ParameterizedTest
@CsvSource({
        "Test Title, Test Content, 1",
        "Another Title, Another Content, 2",
        "Invalid Title, Valid Content, 3"
})
public void testSetListOfPosts(String title, String content, String userId) {
    // Given
    posts = new Posts();
    users = new Users();
    
    User user = new User(1, "testUser", "testPassword");
    users.getListOfUsers().add(user);
    
    // Clear the list of posts
    posts.getListOfPosts().clear();
    
    // Create a post and add it to the list of posts
    Post post = new Post(title, content, user);
    posts.getListOfPosts().add(post);

    // When
    posts.setListOfPosts(users, "poststest.txt");

    // Then
    List<Post> listOfPosts = posts.getListOfPosts();
    assertEquals(1, listOfPosts.size());
    
    Post retrievedPost = listOfPosts.get(0);
    assertEquals(title, retrievedPost.getTitle());
    assertEquals(content, retrievedPost.getContent());
    
    if (userId.equals("invalidUserId")) {
        assertNull(retrievedPost.getAuthor());
    } else {
        assertNotNull(retrievedPost.getAuthor());
    }
}

/**
     * Test if it is possible to add null to the list of posts.
     */
@Test
public void testSetListOfPostsNullArgument() {
    // Given
    posts = new Posts();
    users = new Users();

    // When
    posts.setListOfPosts(users, null);

    // Then
    List<Post> listOfPosts = posts.getListOfPosts();
    assertNotNull(listOfPosts);
    assertEquals(0, listOfPosts.size());
}


/**
 * Test adding a new post with a null post object.
 */
@Test
    public void testAddingNewPostWithNull() {
        Post post = null;
        try {
            List<String> lines;
            lines = Files.readAllLines(Path.of("posts.txt"));
            int linesBefore = lines.size();
            posts.addNewPost(post);
        
            assertEquals(linesBefore, lines.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
    @AfterEach
public void tearDown() {
    
    try {
        Files.deleteIfExists(Path.of("poststest.txt"));
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
