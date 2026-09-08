/*
 * Title: HW01a_Distinct.java
 * Abstract: This program scans numbers from a provided file and stores them in an array. It checks for repeat numbers and counts how many times certain numbers appear.
 * Author: Selvedin Kurtic
 * Email: skurtic@csumb.edu
 * Estimate: 2 hours
 * Date: 09/03/2026
 */

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class HW01a_Distinct {
    public static void main(String[] args) throws IOException {

        Scanner UserInput = new Scanner(System.in);
        System.out.print("Enter input file name: ");
        // Collect the file name from the user
        String fileName = UserInput.next();
        System.out.println();

        // Create a file reader so we can identify the file
        FileReader fr = new FileReader(fileName);
        // Create a scanner to scan the contents in the file provided using the previous file reader.
        Scanner fs = new Scanner(fr);


        // Creating an array and collecting the nextInt (first possible number) to assign the size to the array.
        int size = fs.nextInt();
        int [] numRange  = new int[size];
        // Printing out the length of the array to double-check if it is working
        // System.out.println("Number Range: " + numRange.length);


        // Assigning values and printing out the numbers.
        for(int i = 0; i < numRange.length; i++){
            numRange[i] = fs.nextInt();
            // System.out.println(numRange[i]);
        }
        // Just a test to see if all array positions were filled
        // System.out.println("Finished printing the array numbers. This is just to confirm the numbers were properly assigned to the array.");

        // Method to find the smallest number
        minNum(numRange);

        System.out.println();
        System.out.println("Number  Count");

        for(int i = 0; i < numRange.length; i++) {

            if(isDistinct(numRange, i)){
                int current = numRange[i];
                int count = 0;


                for(int j = 0; j < numRange.length; j++){
                    if(numRange[j] == current){
                        count++;
                    }
                }

                // Formatting to make sure everything is spaced correctly
                if(current >= 0 && current <= 9){
                    System.out.println(current + "       " + count);

                } else if (current >= 10 || (current <= -1 && current >= -9)){
                    System.out.println(current + "      " + count);

                } else {
                    System.out.println(current + "     " + count);
                }

            }
        }
    }

    // Selvedin_Kurtic

    // Similar to what we did in class and for the lab.
    public static boolean isDistinct(int [] numRange, int current){

        for(int i = 0; i < current; i++){
            if(numRange[i] == numRange[current]){
                return false;
            }
        }
        return true;
    }

    public static void minNum(int [] numRange){

        // Setting minimum to 99 because it will be the largest possible value, so anything smaller gets assigned to minimum.
        int minimum = 99;
        for(int i = 0; i < numRange.length; i++){
            if(minimum > numRange[i]){
                minimum = numRange[i];
            }
        }
        System.out.println("Min Number: " + minimum);
    }

    // End of the Main Class
}
