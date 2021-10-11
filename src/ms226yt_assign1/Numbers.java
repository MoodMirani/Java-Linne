import javax.swing.JOptionPane;

// Author: Mahmoud Sherzad

public class Numbers {
    public static void main(String[] args) {
        // input
        String number = JOptionPane.showInputDialog("Enter a three digit number: ");
      
        // extract numbers as char and convert to int
        int first = Character.getNumericValue(number.charAt(0));
        int second = Character.getNumericValue(number.charAt(1));
        int third = Character.getNumericValue(number.charAt(2));
      
        // calculate and print sum & product
        System.out.println("Sum of the digits of the integer number is: " + (first+second+third));
        System.out.println("Product of the digits of the integer number is: " + (first*second*third));
    }
}
