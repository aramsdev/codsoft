package com.models;

public class Students {
    private String firstName;
    private String lastName;
    private String grade;
    private String rollNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }  
    
    public Students(String fn, String ln, String grade, String rn){
        this.firstName = fn;
        this.lastName = ln;
        this.rollNumber = rn;
        this.grade = grade;
    }
}
