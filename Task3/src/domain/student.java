package domain;

public class student {
    protected String firstName;
    protected String lastName;
    protected String rollNumber;
    protected String grade;
    protected int age;
    
    public student(String firstName, String lastName, String rollNumber, String grade) throws noNulls{
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
        this.grade = grade;
        if(firstName.isEmpty() || lastName.isEmpty() || rollNumber.isEmpty() || grade.isEmpty()) throw new noNulls("Error: You haven't filled the mandatory information");
    }

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

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
