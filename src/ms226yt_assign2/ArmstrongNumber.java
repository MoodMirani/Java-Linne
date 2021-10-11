import java.util.Scanner;

import javax.swing.JOptionPane;
/**
 * @version 19-08-2021
 * filename: ArmstrongNumber.java
 * @author Mahmoud Sherzad
 * 
 * This class calculates the armstrong numbers within a given intervall
 */

public class ArmstrongNumber {
   public static void main(String args[]){
      boolean running = true;
      while(running){

         // initialize variables
         int number1;
         int number2;
         int check = 0;
         int remaining = 0;
         int sum = 0;
         Scanner input = new Scanner(System.in); 


         // receive input from user
         System.out.println("Hello, this program calculates the armstrong numbers within a given range");
         System.out.println("Enter the starting number of the range: ");
         int input1 = input.nextInt();
         System.out.println("Enter the ending number of the range: ");
         int input2 = input.nextInt();

         // print the armstrong numbers
         System.out.println("The Armstrong numbers between the given range are: ");
         for (int i = input1; i<input2; i++){
            remaining = 0; 
            sum = 0;
            check = i;
            while(check != 0) {
               remaining = check % 10;
               sum = sum + (remaining * remaining * remaining);
               check = check / 10;
            }
            if(sum == i){
               System.out.println(i);
            }
         }
         
         // asking the user if they want to continue
         System.out.println("Do you want to repeat? (Y/N) ");
         String repeat = input.next();
         if(!repeat.equals("Y") && !repeat.equals("y")){
            running = false;
         }
      }
   }
}