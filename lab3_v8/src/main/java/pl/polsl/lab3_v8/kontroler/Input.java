package pl.polsl.lab3_v8.kontroler;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Handles user input for the blog application.
 * 
 * @author Jakub Janaszak
 * @version 1.0
 */
public class Input {

    /**
     * Default constructor for the Input class.
     */
    public Input() {
    }
    
    /**
     * Reads a line of text from the console.
     * 
     * @return The input text.
     */
    public String inputConsole(){
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        return text;
    }
    
    /**
     * Reads an integer from the console.
     * 
     * @return The input integer.
     */
    public int inputIntConsole(){
        Scanner scan = new Scanner(System.in);
        int number=0;
        try{
        number = scan.nextInt();
        scan.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Błąd: Wprowadzono nieprawidłowe dane. Wprowadź liczbę całkowitą.");
            scan.nextLine(); // Konsumuj resztę wiersza, aby uniknąć pętli nieskończonej
        }
        return number;
    }
}