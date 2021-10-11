import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;
/**
 * @version 20-08-2021
 * filename: SweID.java
 *  @author Mahmoud Sherzad
 * 
 * This class verifies swedish ID numbers.
 */

public class SweID {
    public static void main(String[] args) {
        String gender;
        boolean correct;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome, this program verifies swedish personal registration numbers, ex. 640123-8826");
        System.out.println("Enter a 10 digit number, last four digits should be separated by '-': ");
        String ID = input.next();

        correct = isCorrect(ID);

        if(correct){
            if(isFemaleNumber(ID)){
                gender = "female";
            }
            else{
                gender = "male";
            }
            System.out.println(ID + " is a correct " + gender + " number");
        }
    }

    // extract first 6 numbers from ID
    public static String getFirstPart(String sweID){
        String firstPart = sweID.substring(0, 6);
        return firstPart;
    }

    // extract last 4 numbers from ID
    public static String getSecondPart(String sweID){
        String secondPart = sweID.substring(7, 11);
        return secondPart;
    }

    // check if its a female
    public static boolean isFemaleNumber(String sweID){
        int gender = Integer.parseInt(sweID.substring(9, 10));
        if ( gender % 2 == 0 ){
            return true;
        }
        else{
            return false;     
        }
    }

    // compares 2 ID's and checking if they are the same ID
    public static boolean areEqual(String id1, String id2){
        boolean equal = id1.equals(id2);
        return equal;
    }

    // calculating the checksum, based on Luhn's algorithm
    public static int calculateChecksum(String sweID){
        sweID = sweID.replaceAll("-", "");
        int result = 0;
        int turn = 1; // the variable turn is used to double the value of every second digit 
        for (int i = 8; i >=0; i--) {
            if(turn == 1){
                int number = Integer.parseInt(sweID.substring(i, i+1))*2;
                int sum = 0; // sum of the digits in the new value at this position
                int digit;
                while(number > 0){  // calulationg the sum of digits in the new value
                    digit = number % 10;  
                    sum = sum + digit;  
                    number = number / 10;  
                    }
                result = result + sum;
                turn = turn * -1;
            }
            else if(turn == -1){
                result = result + Integer.parseInt(sweID.substring(i, i+1));
                turn = turn * -1;
            }
        }
        int checksum = 10 - (result % 10);
        return checksum;
    }

    // checking if an ID is correct
    public static boolean isCorrect(String sweID){
    
        // check if the date is valid
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuMMdd");
        try {
             formatter.parse(getFirstPart(sweID));
        } catch (Exception e) {
            System.out.println(sweID + " is not a correct number (unvalid date)");
            return false;
        }

        // check if length of ID is correct
        if(sweID.length() != 11){
            System.out.println(sweID + " is not a correct number (unvalid length)");
            return false;
        }

        // calculating the checksum
        int checksum = calculateChecksum(sweID);
  
        // comparing the checksum with the last digit in the ID
        if (checksum != Integer.parseInt(sweID.substring(10, 11))) {
            System.out.println(sweID + " is not a correct number (unvalid last digit)");
            return false;
        }
        return true;
    }
}
