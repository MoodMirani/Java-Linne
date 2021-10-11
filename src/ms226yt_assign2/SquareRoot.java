import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @version 19-08-2021
 * filenamne: SquareRoot
 * @author Mahmoud Sherzad
 * 
 * This class calculates the squareroot of a number by using the 
 * babylonian algorithm
 */

public class SquareRoot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // message to user
        System.out.println("This program estimate square roots.");

        // input
        System.out.println("Enter an integer to estimate the square root of: ");
        int number = input.nextInt();

        // initial guess
        double guess = number / 2;

        double difference = 1; // just an initialvalue
        double previousGuess = guess;

        /**
         * iterates until guess is within 1 percent of the previous guess
         */
        while (Math.abs(difference) >= 1){                        
            double r = number / guess;
            guess = (guess + r) / 2;
            difference = ((guess-previousGuess)/previousGuess)*100;
            previousGuess = guess;
            System.out.println("Current guess: " + guess);
        }
    }
}
