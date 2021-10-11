package ms226yt_assign3.task5;
import java.util.Scanner;


public class Admin extends SalariedEmployee{
    String title;
    String responsibility;
    String supervisor;

    public Admin(String titleVal, String responsibilityVal, String supervisorVal){
        // super(name);
        this.title = titleVal;
        this.responsibility = responsibilityVal;
        this.supervisor = supervisorVal;
    }

    public void readData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title: ");
        this.title = input.next();
        System.out.println("Enter the responsibility: ");
        this.responsibility = input.next();
        System.out.println("Enter the supervisor: ");
        this.supervisor = input.next();
        input.close();
    }

    public boolean equals(Admin o){
        boolean sameTitle = false;
        boolean sameResponsibility = false;
        boolean sameSupervisor = false;

        if(this.title == o.getTitle()){
            sameTitle = true;
        }

        if(this.title == o.getResponsibilty()){
            sameResponsibility = true;
        }

        if(this.title == o.getSupervisor()){
            sameSupervisor = true;
        }

        if(sameTitle && sameResponsibility && sameSupervisor){
            return true;
        }      
        return false;
    }

    public String toString() {
        return "Title: " + this.title + ", Responsibility: " + this.responsibility + ", Supervisor: " + this.supervisor;
    }


    public void setTitle(String titleVal) {
        this.title = titleVal;
    }

    public void setResponsibility(String responsibilityVal) {
        this.responsibility = responsibilityVal;
    }

    public void setSupervisor(String supervisorVal) {
        this.supervisor = supervisorVal;
    }

    public String getTitle() {
        return this.title;
    }

    public String getResponsibilty() {
        return this.responsibility;
    }

    public String getSupervisor() {
        return this.supervisor;
    }
}
