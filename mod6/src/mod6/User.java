package mod6;


public class User {
    int rollno;
    String name;
    String joined;
    int clicks; 

    public User(int rollno, String name, String joined) {
        this.rollno = rollno;
        this.name = name;
        this.joined = joined;
        this.clicks = 0; 
    }
    
    public void addClick() {
    	this.clicks++;
    }

    @Override
    public String toString() {
        return "Entries" + clicks + " | RollNo: " + rollno + " | Name: " + name + " | Date: " + joined;
    }
}