package ms226yt_assign3;
import java.util.Scanner;
import javax.swing.JOptionPane;
/** 
 * @version 10-09-2021
 * filename: NoDuplicates.java
 * @author Mahmoud Sherzad
 * 
 * This class lets you input 5 unique numbers and then sorts them in ascending order
 */
public class NoDuplicates {
    public static void main(String[] args) {
        int userInput=0;
        int position = 0; // which position in the list are we inputing
        boolean unique;
        boolean inInterval; // keeps track if the number is in the correct intervall
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5]; // array of 5 integers
        System.out.println("Please enter five unique numbers between 10 and 100.");

        // entering the numbers
        for (int i = 0; i < numbers.length; i++) {
            position = i +1; 
            while(true){
                unique = true;
                inInterval = true;
                try {
                    System.out.println("Enter number "+(position)+": ");
                    userInput = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Failed, please try entering number again");
                }

                for (int k : numbers) {
                    if(userInput == k){
                        System.out.println(userInput + " has already been entered, try another number between 10 and 100");
                        unique = false;
                        display(numbers);
                    }
                }

                if(userInput<10 || userInput>100){
                    inInterval = false;
                    System.out.println(userInput + " is not in the correct interval, please enter a number between 10 and 100");
                }

                if(unique && inInterval){
                    numbers[i]=userInput;
                    display(numbers);
                    break;
                }
            }
        }

        // display the results in the end
        System.out.println("Numbers in the Entered Order: ");
        display(numbers);
        System.out.println("Numbers in the Sorted Order: ");
        display(sortArray(numbers));
    }

    /**
     * @param numbers an unsorted array of ints with the size 5
     * @return a sorted array of ints
     */
    public static int[] sortArray(int[] numbers) {
        int[] sortedArray = new int[5];
        int max=0; // highest value in current array
        int maxIndex=0; // used to remove the highest value in the current array, after the value has been sorted

        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(max < numbers[j]){
                    max = numbers[j];
                    maxIndex = j;
                }
            }
            sortedArray[i] = max;
            numbers[maxIndex] = 0;
            max = 0;
        }

        return sortedArray;
    }

    // display the array
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0){
                System.out.print(array[i]+" ");
            }
        }
        System.out.println("");
    }
}
