/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import pl.polsl.lab3_v8.model.User;
import pl.polsl.lab3_v8.model.Users;
import pl.polsl.lab3_v8.model.BlogException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pl.polsl.lab3_v8.kontroler.FileHandler;


/**
 * Unit tests for the User class and Users class.
 * These tests cover various scenarios for adding users and finding users by username or ID.
 * All tests are based on JUnit 5.
 * 
 * @version 1.0
 * @author Jakub Janaszak
 */

public class UserTest {
    
    private User user;
    private Users users;
    
    /**
     * Set up before each test.
     */
    @BeforeEach
    public void setUp(){
        user = new User(100,"TEST","1234");
        users = new Users();
    }
    
    /**
     * Test adding a new user to the Users list.
     */
    @Test
    public void testAddNewUser(){
        try{
            users.addNewUser(user);
            assertEquals(users.getListOfUsers().get(users.getListOfUsers().size()-1), user);
        }
        catch (BlogException e) {
            fail("Error: " + e.getMessage());
        }
    } 
    
    /**
     * Test adding a null user, expecting a BlogException.
     */
    @Test
    public void testAddNullUser(){
        try {
            users.addNewUser(null);
            fail("Expected BlogException for null user");
        } catch (BlogException e) {
            assertEquals("User cannot be null", e.getMessage());
        }
    } 
    
    /**
     * Test adding a user with a null username, expecting a BlogException.
     */
    @Test
    public void testAddUserWithNullUsername(){
        try{
            user = new User(100,null,"1234");
            users.addNewUser(user);
            fail("Expected BlogException for empty username");
        }
        catch (BlogException e) {
            assertEquals("Username and password cannot be empty", e.getMessage());
        }
    } 
    
    /**
     * Test adding a user with an empty username, expecting a BlogException.
     */
    @Test
    public void testAddUserWithEmptyUsername(){
        try{
            user = new User(100,"","1234");
            users.addNewUser(user);
            fail("Expected BlogException for empty username");
        }
        catch (BlogException e) {
            assertEquals("Username and password cannot be empty", e.getMessage());
        }
    } 
    
    /**
     * Tests the {@link Users#findUserByUsername(String)} method with various scenarios.
     *
     * @param inputUsername   The input username for the test.
     * @param expectedResult  The expected result indicating whether the user should be found or not.
     */    
    @ParameterizedTest
    @CsvSource({"username1, true", "nonexistentUsername, false", "Username1, false"})
    public void testFindUserByUsername(String inputUsername, boolean expectedResult) {
        User user1 = new User(1, "username1", "password1");
        users.getListOfUsers().add(user1);

        // Parametrization
        User foundUser = users.findUserByUsername(inputUsername);

        // Check the result
        if (expectedResult) {
            assertNotNull(foundUser);
            assertEquals(user1, foundUser);
        } else {
            assertNull(foundUser);
        }
    }
    
    /**
     * Tests the {@link Users#findUserById(int)} method with various scenarios.
     *
     * @param inputId          The input ID for the test.
     * @param expectedResult  The expected result indicating whether the user should be found or not.
     */
    @ParameterizedTest
    @CsvSource({"99, true", "98, false", "2147483647, false"})
    public void testFindUserById(int inputId, boolean expectedResult) {
        User user1 = new User(99, "username1", "password1");
        users.getListOfUsers().add(user1);

        // Parametrization
        User foundUser = users.findUserById(inputId);

        // Check the result
        if (expectedResult) {
            assertNotNull(foundUser);
            assertEquals(user1, foundUser);
        } else {
            assertNull(foundUser);
        }
    }
}
