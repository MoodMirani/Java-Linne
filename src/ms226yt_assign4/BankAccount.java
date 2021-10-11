package ms226yt_assign4;

import java.util.Scanner;

/** 
 * @version 10-10-2021
 * filename: BankAccount.java
 * @author Mahmoud Sherzad
 * 
 * This class lets you open a bank account
 */
public class BankAccount {
    String CustomerID;
    String AccountNumber;
    int balance;

    // constructor
    public BankAccount(String CustomerIDVal, String AccountNumberVal, int balanceVal){
        this.CustomerID = CustomerIDVal;
        this.AccountNumber = AccountNumberVal;
        this.balance = balanceVal;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Bank of Students, By the Students, for the Students!");
        BankAccount account = new BankAccount(inputCustomerID(), inputAccountNumber(), initialBalance()); // create a bankaccount
        System.out.println(account);
        System.out.println("Congratulations, your account has been created successfully!");



    }

    public String toString() {
        return "Account: " + this.CustomerID + " " + this.AccountNumber + " " + this.balance;
    }

    // user inputs the initial balance
    public static int initialBalance() {
        Scanner input = new Scanner(System.in);
        int balance=0;
        while (true) {
            System.out.println("Enter balance: ");
            try {
                balance = input.nextInt();
            } catch (Exception e) {
                System.out.println("Failed to find a number, please try again");
            }

            if (balance>=1000) {
                return balance;
            }else{
                System.out.println("Initial balance must be equal to or higher than 1000. Please input again.");
            }
        }
        
    }

    // asking the user to type in the account number
    public static String inputAccountNumber() {
        Scanner input = new Scanner(System.in);
        String AccountNumber = ""; // using a string so that we can easily determine the length of the number
        while(true) {
            boolean correctNumber = true;
            System.out.println("Enter Account Number: ");
            try {
                AccountNumber = input.next();
                Integer.parseInt(AccountNumber); // checking if it can be converted to an integer
            } catch (Exception e) {
                correctNumber = false;
            }
            
            // checking the length of the number
            if(AccountNumber.length() != 7){
                correctNumber = false;
            }

            if(correctNumber){
                return AccountNumber;
            }else{
                System.out.println("Incorrect Account No. The Account number must be of seven digits. Please input again.");
            }
        }
    }

    // asking the user to type in the customer ID
    public static String inputCustomerID() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // used to determine if first character is a letter
        String CustomerID = "";
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Enter customer ID: ");
            try {
                CustomerID = input.next();
            } catch (Exception e) {
                System.out.println("Input failed");
            }
            boolean correctStart = false;
            boolean correctEnd = false;
            boolean correctLength = false;

            // check the length of the ID
            if (CustomerID.length() == 4) {
                correctLength = true;
            }

            // check if first character is a letter
            if(letters.contains(CustomerID.substring(0, 1))){
                correctStart = true;
            }

            // check if last 3 characters are digits
            try {
                Integer.parseInt(CustomerID.substring(CustomerID.length()-3, CustomerID.length()));
                correctEnd = true;
            } catch (Exception e) {
                System.out.println("Failed to convert last 3 characters to integers");
            }

            if(correctStart && correctEnd && correctLength){
                return CustomerID;
            }else{
                System.out.println("Incorrect Customer ID. The Customer ID must start with a letter followed by three digits. Please input again.");
            }
        }
    }
}
