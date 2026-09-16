/*
 * Title: Course Roster -- Student.java
 * Abstract: This is a program that acts as a course roster, it gets the max capacity (30 students) and adds students to the roster if there is space. it also removes students and decremenets how many students are in the class for the count.
 * Author: Selvedin Kurtic
 * Email: skurtic@csumb.edu
 * Estimate: 3 hours
 * Date: 09/015/2026
 */

public class Student {

    private String name;
    private int id;

    public Student (String name, int id){
        this.name = name;
        this.id = id;
    }

    // Get Name Method
    public String getName(){
        return name;
    }

    // Set Name Method
    public void setName(String n){
        name = n;
    }

    // Get ID Method
    public int getId(){
        return id;
    }

    public String toString(){
        return "Name: " + name + " - ID: " + id;
    }

    public Boolean idCheck(Student s){
        return this.id == s.getId();
    }



}
