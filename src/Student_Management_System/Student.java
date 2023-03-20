package Student_Management_System;

public class Student {

    String name = null;
    String email = null;
    long number = 0;
    Address address = null;

    public Student(String name, String email, long number, Address address) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.address = address;
    }

    public Student() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return number;
    }

    public void setMobile(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
