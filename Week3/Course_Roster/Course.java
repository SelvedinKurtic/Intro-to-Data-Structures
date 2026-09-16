/*
 * Title: Course Roster -- Course.java
 * Abstract: This is a program that acts as a course roster, it gets the max capacity (30 students) and adds students to the roster if there is space. it also removes students and decremenets how many students are in the class for the count.
 * Author: Selvedin Kurtic
 * Email: skurtic@csumb.edu
 * Estimate: 3 hours
 * Date: 09/015/2026
 */

public class Course {

    private String title;
    private int number;
    private String instructorName;
    private Student [] roster = new Student[30];
    private int rosterCount;


    // Constructor to get the title, number, and instructorName
    public Course(String t, int num, String n){
        title = t;
        number = num;
        instructorName = n;
    }

    // Method to get the title
    public String getTitle(){
        return title;
    }

    // Method to get the Instructors Name
    public String getInstructorName(){
        return instructorName;
    }

    // Methhod to get the number
    public int getNumber(){
        return number;
    }

    // Method to get the EnrollmentCount which is just rosterCount;
    public int getEnrollmentCount(){
        return rosterCount;
    }

    // toString to return the Course Title, Course Number, Instructor Name, and current count of students in the course.
    public String toString(){
        return "Course Title: " + title + "\nCourse Number: " + number + "\nInstructor: " + instructorName + "\nEnrollment: " + rosterCount;
    }

    // Checking if the title is the same and if the student id is the same
    public Boolean equals(Course c){
        if(this.title.equals(c.getTitle()) && this.number == c.getNumber()){
            return true;
        }
        return false;
    }

    // Adding students to the course, but first we check if the course is already full, if not then we check if the student is already enrolled in the course.
    public Boolean add(Student s){
        if(rosterCount >= 30){
            return false;
        }

        for(int i = 0; i < rosterCount; i++){
            if(roster[i].equals(s)){
                return false;
            }
        }
        roster[rosterCount] = s;
        rosterCount++;
        return true;
    }

    // Removes students to the course (only if they're already enrolled), and then shifts the array to the left.
    public Boolean remove(Student s){

        for(int i = 0; i < rosterCount; i++) {
            if (roster[i].equals(s)) {

                for (int j = i; j < rosterCount - 1; j++) {
                    roster[j] = roster[j + 1];
                }

                rosterCount--;
                return true;
            }
        }
        return false;
    }

    // Printing out the course info, then all the students in the course.
    public void print(){
        System.out.println(this.toString());
        for(int i = 0; i < rosterCount; i++){
            System.out.println("    " + roster[i].toString());
        }
    }
    
    public static void main(String[] args) {

        Course c1 = new Course("Intro to Everything", 123, "Dr. Islam");
        Student s1 = new Student("Jane", 1234);
        Student s2 = new Student("Phillipe", 1235);
        Student s3 = new Student("Lu", 1236);
        Student s4 = new Student("Enrique", 1237);
        c1.add(s1);
        c1.add(s2);
        c1.add(s3);
        c1.add(s4);
        c1.print();
        c1.remove(s2);
        c1.print();
        
    }
}
