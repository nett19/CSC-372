package mod6;


public class User {
    int rollno;
    String name;
    String joined;

    public User(int rollno, String name, String joined) {
        this.rollno = rollno;
        this.name = name;
        this.joined = joined;
    }

    @Override
    public String toString() {
        return "RollNo: " + rollno + " | Name: " + name + " | Date: " + joined;
    }
}