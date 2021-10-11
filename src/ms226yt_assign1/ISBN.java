import java.util.Scanner;

// Author: Mahmoud Sherzad

public class ISBN {
    public static void main(String[] args) {
        
        // read input as int
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        // converting the input to a string, because strings are indexable
        String numberS = Integer.toString(number);

        // as an int, java automatically removes zeros in the beginning, i am adding them back
        while(numberS.length()<9){
            numberS = 0 + numberS;
        }

        // calculating the checksum
        int result = 0;
        for (int i = 0; i < 9; i++) {
            result = result + Character.getNumericValue(numberS.charAt(i))*(i+1);
        }
        int checksum = result % 11;

        // displaying the ISBN
        if (checksum==10){
            System.out.println("The ISBN-10 number is: " + numberS + "X");
        }
        else{
            System.out.println("The ISBN-10 number is: " + numberS + checksum);
        }
        scan.close();
    }
}
