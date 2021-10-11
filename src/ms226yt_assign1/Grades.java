// Author: Mahmoud Sherzad
import javax.swing.JOptionPane;

public class Grades {
    public static void main(String[] args) {
        // input
        float totalMarks = Float.parseFloat(JOptionPane.showInputDialog("Please enter total marks: "));
        float marksObtained = Float.parseFloat(JOptionPane.showInputDialog("Please enter marks obtained: "));

        // calculate percentage 
        int percentage = Math.round(marksObtained/totalMarks*100);
        System.out.println(percentage);

        // Check grade and display
        if(percentage>=90){
            JOptionPane.showMessageDialog(null,"Congratulations, you have passed the course with grade A");
        }
        else if(percentage<=89 && percentage>=80){
            JOptionPane.showMessageDialog(null,"Congratulations, you have passed the course with grade B");
        }
        else if(percentage<=79 && percentage>=75){
            JOptionPane.showMessageDialog(null,"Congratulations, you have passed the course with grade C");
        }
        else if(percentage<=74 && percentage>=70){
            JOptionPane.showMessageDialog(null,"Congratulations, you have passed the course with grade D");
        }
        else if(percentage<=69 && percentage>=60){
            JOptionPane.showMessageDialog(null,"Congratulations, you have passed the course with grade E");
        }
        else if(percentage<60){
            JOptionPane.showMessageDialog(null,"You could not pass this time :(, please try again! Your grade is F");
        }
            
    }
}
