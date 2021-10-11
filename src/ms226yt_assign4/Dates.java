package ms226yt_assign4;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/** 
 * @version 10-10-2021
 * filename: Dates.java
 * @author Mahmoud Sherzad
 * 
 * This class makes sure you input a valid date
 */
public class Dates {
    static String day;
    static String month;
    static String year;
    public static void main(String[] args) {
        inputDate();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMuuuu");
        try {
            System.out.println(formatter.parse(day+month+year));
       } catch (Exception e) {
           System.out.println(" is not a correct number (unvalid date)");
       }
    }
    
    public static void inputDate() {
        Scanner input = new Scanner(System.in);
        String[] date = new String[3];
        try {
            date = input.next().split("/");
        } catch (Exception e) {
            //TODO: handle exception
        }
        // saving unchecked values
        day = date[0];
        month = date[1];
        year = date[2];
    }

    public static boolean checkDate() {
        return false;
        
    }


}
