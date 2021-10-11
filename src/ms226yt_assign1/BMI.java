// Author: Mahmoud Sherzad
import javax.swing.JOptionPane;

public class BMI {
   public static void main(String[] args) {
      // constanst:
      double pound = 0.45359237;
      double inch = 0.0254;

      // input
      double weight = Double.parseDouble(JOptionPane.showInputDialog("Enter weight in pounds: "));
      double height = Double.parseDouble(JOptionPane.showInputDialog("Enter height in inches: "));

      // convert to kilograms and meters
      weight = weight*pound;
      height = height*inch;

      // display BMI
      JOptionPane.showMessageDialog(null,"BMI is "+weight/Math.pow(height, 2));
   }
}
