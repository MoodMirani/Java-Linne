package ms226yt_assign3;

import java.util.Random;
/** 
 * @version 01-09-2021
 * filename: Dices.java
 * @author Mahmoud Sherzad
 * 
 * This class creates a table of the frequency of diceresults
 */
public class Dices {
    
    public static void main(String[] args) {
        int dice1;
        int dice2;
        Random random = new Random();
        int[] frequency = new int[11];

        // starting each frequency with zero
        for (int i : frequency) {
            frequency[i] = 0;
        }

        for (int i = 0; i < 10000; i++) {
            // generates random numbers 0-5 and adds 1 to it so we get numbers 1-6
            dice1 = random.nextInt(6) + 1;
            dice2 = random.nextInt(6) + 1;

            // calculate sum of dices and add 1 to its frequency
            frequency[dice1+dice2-2]++; 
        }

        // display the table
        System.out.println("Frequency table (sum, count) for rolling two dices 10000 times is:");
        for (int i = 0; i < frequency.length; i++) {

            if(i+2<10){
                System.out.print(i+2 + "     ");
            }
            else{
                System.out.print(i+2 + "    ");
            }
            
            System.out.println(frequency[i]);
        }
        
    }
}
