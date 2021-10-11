package ms226yt_assign3.task4;

public class Person {
    String name;
    String adress;
    String phoneNumber;
    String email;
    
    // constructor
    public Person(String nameVal, String adressVal, String phoneNumberval, String emailVal){
    name = nameVal;
    adress = adressVal;
    phoneNumber = phoneNumberval;
    email = emailVal;
    }

    // empty constructor, removed the error when calling Super(); in subclass 
    public Person(){
    }

    @Override
	public String toString() {
		return  "name: " + this.name + ", adress: " + this.adress + ", phonenumber: " + this.phoneNumber + ", email: " + this.email;
	}


}
