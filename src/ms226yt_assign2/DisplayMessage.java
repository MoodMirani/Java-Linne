/**
 * The class lets you display a message a given number of times
 * @author Mahmoud Sherzad
 * @version 23-08-2021
 */
public class DisplayMessage {
    String message;
    int count;

    /**
     * sets the message
     * @param inputMessage
     */
    public void setDisplayMessage(String inputMessage) {
        message = inputMessage;
    }

    /**
     * sets the count, which determines how many times the message repeats
     * @param number
     */
    public void setDisplayCount(int number) {
        count = number;
    }

    /**
     * displays the message count times
     */
    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(getDisplayMessage());
        }
    }

    /**
     * extracts the message
     * @return message
     */
    public String getDisplayMessage() {
        return message;
    }

    /**
     * lets you display a custom message
     * @param inputMessage
     * @param number
     */
    public void display(String inputMessage, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(inputMessage);
        }
    }

    
}
