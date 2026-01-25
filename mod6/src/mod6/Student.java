package mod6;

public class Student {
    int rollno;
    String name;
    String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "RollNo: " + rollno + " | Name: " + name + " | Address: " + address;
    }
}