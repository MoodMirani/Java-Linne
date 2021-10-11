/**
 * This class class calls DisplayMessage
 */
public class DisplayMessageMain {
    public static void main(String[] args) {
        DisplayMessage dm = new DisplayMessage();
        dm.setDisplayMessage("Hello 1DV532!");
        dm.setDisplayCount(3);
        dm.display(); // ==> print-out
        dm.display("Goodbye 1DV532", 2); // ==> print-out
        System.out.println("Current Message: "+ dm.getDisplayMessage());
    }
}