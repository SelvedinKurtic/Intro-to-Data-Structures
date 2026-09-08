/*
 * Title: Quiz Averages with Classes
 * Abstract: Collects a students name id, and 5 test scores from a file. Each student will get an average score using the top 4 scores provided. We will then print their name, id, and average score.
 * Author: Selvedin Kurtic
 * Email: skurtic@csumb.edu
 * Estimate: 2.5 hours
 * Date: 09/07/2026
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Student {
    private String studentId;
    private String name;
    private double[] scores;

    public Student (String n, String sid){
        studentId = sid;
        name = n;
        scores = new double[5];
    }

    public void setScore(double[] incomingScores){
        scores = incomingScores;
    }

    public double getAverage(){

        // lowest will remove the lowest scores since we only want the highest 4 scores.
        double lowest = scores[0];
        double sum = 0;

        for(int i = 0; i < scores.length; i++){
            sum += scores[i];

            if(scores[i] < lowest){
                lowest = scores[i];
            }
        }

        return (sum - lowest) / 4.0;
    }


    public String toString(){
        return name + " (" + studentId + ") : " + getAverage();
    }



    public static void main(String[] args) throws IOException {

        Scanner userInput = new Scanner(System.in);

        // Asking for a filename to collect information from and storing it in filename variable.
        System.out.print("Enter input filename: ");
        String filename = userInput.next();

        // Printing the horizontal line
        System.out.println("--------------------------------------------------");
        System.out.println("Course Report: Quiz Average");
        System.out.println("--------------------------------------------------");


        FileReader fr = new FileReader(filename);
        Scanner fs = new Scanner(fr);

//        String name = fs.next();
//        String studentId = fs.next();
//
//        double score1 = fs.nextDouble();
//        double score2 = fs.nextDouble();
//        double score3 = fs.nextDouble();
//        double score4 = fs.nextDouble();
//        double score5 = fs.nextDouble();
//        Student s1 = new Student(name, studentId, score1, score2, score3, score4, score5);

        while(fs.hasNext()){

            String endOfFile = fs.next();

            // Keeps going until we run into "STOP"
            if(endOfFile.equals("STOP")){
                break;
            }

            // Collects the studentId as a string, this makes sure it works incase the numbers start with 0 or it's too large.
            String studentId = fs.next();

            // Assigning the scores into the array scoreStorage
            double [] scoreStorage = new double[5];
            for(int i = 0; i < 5; i++){
                scoreStorage[i] = fs.nextDouble();
            }

            // Sent to Student.java
            Student currentStudent = new Student(endOfFile, studentId);

            currentStudent.setScore(scoreStorage);
            System.out.println(currentStudent);
        }

        System.out.println("--------------------------------------------------");

        fr.close();

//        System.out.println(s1);
//        System.out.println(s2);


    }
}
