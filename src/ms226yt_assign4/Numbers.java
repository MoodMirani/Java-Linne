package ms226yt_assign4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/** 
 * @version 09-10-2021
 * filename: Numbers.java
 * @author Mahmoud Sherzad
 * 
 * This class reads numbers from a file and computes the average and 
 * standard deviation of the numbers
 */
public class Numbers {
    public static void main(String[] args) {
        int arraySize = calculateSize();
        double[] numberArray = readNumbers(arraySize);
        double average = calculateAverage(arraySize, numberArray);
        System.out.println("Average: " + average);
        System.out.println("Standard Deviation: " + calculateStandardDeviation(average, numberArray));

    }

    public static double calculateStandardDeviation(double average, double[] array) {
        double standardDeviation = 0;
        double result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result + Math.pow(array[i] - average, 2);
        }
        standardDeviation = Math.sqrt(result/array.length);
        return standardDeviation;
    }

    public static double calculateAverage(int size, double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        double average = sum/size;
        return average;
    }

    public static int calculateSize() {
        File file = new File("src/ms226yt_assign4/numbers.txt");
        int size = 0;
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
            while(fileReader.hasNextLine()){
                fileReader.nextLine();
                size++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }

    public static double[] readNumbers(int size) {
        double[] array = new double[size];
        File file = new File("src/ms226yt_assign4/numbers.txt");
        Scanner fileReader = null;
        int index = 0;
        try {
            fileReader = new Scanner(file);
            index = 0;
            while(fileReader.hasNextLine()){
                array[index] = Double.parseDouble(fileReader.nextLine());
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

}
