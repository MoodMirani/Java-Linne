package ms226yt_assign4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class RandomFaculty{
    public static void main(String[] args) {
        writeDataToFile();
        ArrayList<Person> associates = new ArrayList<Person>(50); 
        Person[] facultyMembers = new Person[1000];
        facultyMembers = readData();

        for (Person p : facultyMembers) {
            if(p.rank.equals("associate")){
                associates.add(p);
            }
        }
        Collections.sort(associates);

        for (Person p : associates) {
            System.out.println(p.firstName + " " + p.lastName + " " + p.salary);
        }
    }

    

    public static void writeDataToFile() {
        PrintWriter writer = null;
		FileOutputStream fileOS;

        try {
			fileOS = new FileOutputStream("faculty.txt");
			writer = new PrintWriter(fileOS);
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file");
			System.exit(0);
		}

        System.out.println("Started writing");
        for (int i = 0; i < 1000; i++) {
            writer.println(new Person(i));
        }
        writer.close();
		System.out.println("Finished writing");

    }

    public static Person[] readData() {
        File file = new File("faculty.txt");
        Scanner fileReader = null;
        Person[] facultyMembers = new Person[1000];
        int index = 0;
        String[] row = new String[4];
        try {
            fileReader = new Scanner(file);
            index = 0;
            while(fileReader.hasNextLine()){
                row = fileReader.nextLine().split(" ");
                facultyMembers[index] = new Person(row[0], row[1], row[2], Integer.parseInt(row[3]));
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facultyMembers;
    }
}

class Person  implements Comparable<Person>{
    public String firstName;
    public String lastName;
    public String rank;
    public int salary;

    public Person(int index){
        this.firstName = "FirstName"+index;
        this.lastName = "LastName"+index;
        this.rank = generateRank();
        this.salary = generateSalary();
    }
    public Person(String firstNameVal, String lastNameVal, String rankVal, int salaryVal){
        this.firstName = firstNameVal;
        this.lastName = lastNameVal;
        this.rank = rankVal;
        this.salary = salaryVal;
    }

    public int compareTo(Person p){  
        if(this.salary==p.salary)  
           return 0;  
        else if(this.salary>p.salary)  
           return -1;  
        else  
           return 1;  
     }

    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.rank + " " + this.salary;
    }

    public String generateRank() {
        Random rand = new Random();
        String[] rankChoices = new String[3];
        rankChoices[0] = "assistant";
        rankChoices[1] = "associate";
        rankChoices[2] = "full";
        int choice = rand.nextInt(3);
        String rank = rankChoices[choice];
        return rank;
        
    }
    public int generateSalary() {
        Random rand = new Random();
        int salary = 0;
        if (this.rank == "assistant") {
            salary = rand.nextInt(30000) + 50000; // random salary between 50000-80000
        } 
        if (this.rank == "associate") {
            salary = rand.nextInt(50000) + 60000; // random salary between 60000-110000
        } 
        if (this.rank == "full") {
            salary = rand.nextInt(55000) + 75000; // random salary between 75000-130000
        } 
        
        return salary;
        
    }


}
