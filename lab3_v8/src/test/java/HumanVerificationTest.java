/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import pl.polsl.lab3_v8.model.HumanVerification;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import pl.polsl.lab3_v8.kontroler.Input;
//import pl.polsl.lab3_v8.widok.Output;

/**
 * Unit tests for the HumanVerification class.
 * These tests cover the addition, subtraction, and multiplication methods of the HumanVerification class.
 * All tests are based on JUnit 5.
 * 
 * @version 1.0
 * @author Jakub Janszak
 */
public class HumanVerificationTest {
    
    /**
     * Set up before each test.
     */
    @BeforeEach
    public void setUp() {
    }
    
    /**
     * Test the addition method.
     * @param a First operand
     * @param b Second operand
     * @param expectedResult Expected result of the addition
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException 
     */
    @ParameterizedTest
    @CsvSource({"3,5,8","-5,-6,-11","0,0,0"})
    public void testAddition(int a, int b, int expectedResult) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HumanVerification hv = new HumanVerification();
    
        Method addMethod = HumanVerification.class.getDeclaredMethod("addition", int.class, int.class);
        addMethod.setAccessible(true);
    
        int result = (int) addMethod.invoke(hv, a, b);
        assertEquals(expectedResult, result, "Wrong addition result");
    }
    
    /**
     * Test the subtraction method.
     * @param a First operand
     * @param b Second operand
     * @param expectedResult Expected result of the subtraction
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException 
     */
    @ParameterizedTest
    @CsvSource({"5,2,3","5,-6,11","0,0,0"})
    public void testSubtraction(int a, int b, int expectedResult) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HumanVerification hv = new HumanVerification();
    
        Method addMethod = HumanVerification.class.getDeclaredMethod("subtraction", int.class, int.class);
        addMethod.setAccessible(true);
    
        int result = (int) addMethod.invoke(hv, a, b);
        assertEquals(expectedResult, result, "Wrong subtraction result");
    }
    
    /**
     * Test the multiplication method.
     * @param a First operand
     * @param b Second operand
     * @param expectedResult Expected result of the multiplication
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException 
     */
    @ParameterizedTest
    @CsvSource({"3,2,6","2,-6,-12","5,0,0"})
    public void testMultiplication(int a, int b, int expectedResult) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HumanVerification hv = new HumanVerification();
    
        Method addMethod = HumanVerification.class.getDeclaredMethod("multiplication", int.class, int.class);
        addMethod.setAccessible(true);
    
        int result = (int) addMethod.invoke(hv, a, b);
        assertEquals(expectedResult, result, "Wrong multiplication result");
    }
}
