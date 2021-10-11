package ms226yt_assign3.task5;

public class AdminMain {
    public static void main(String[] args) {
        // create 3 objects of the Admin class
        Admin Legolas = new Admin("CMO", "Marketing", "CEO");
        Admin Gandalf = new Admin("CMO", "Marketing", "CEO");
        Admin Saruman = new Admin("CSO", "Sales", "CEO");

        System.out.println(Legolas);
        System.out.println(Gandalf);
        System.out.println(Saruman);

        // comparing the objects 
        if (Legolas.equals(Gandalf)){
            
        }
    }
}
