package domain;

public class student {
    protected String name;
    protected String roll_number;
    protected String grade;
    protected String classroom;
    
    public student(String name, String roll_number, String grade, String classroom){
        this.name = name;
        this.roll_number = roll_number;
        this.grade = grade;
        this.classroom = classroom;
    }
}
