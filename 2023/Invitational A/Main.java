// Israel Cantu
// 1-11-2023
// This program represents a set of dice, complete with random rolling using Math.random()
// It tallies all the rolls into an ArrayList, and has functions to remove all specifed numbers,
// find the mode in the ArrayList, and sort the ArrayList.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;

        ArrayList < Integer > results = new ArrayList < Integer > ();

        getData(results, 10); // create randomized ArrayList 1-6
        System.out.println("Roll Results: ");
        ShowData(results); // prints results
        System.out.println();

        // next few lines sort list and print it
        selectionSort(results);
        System.out.println("Sorted Results: ");        
        ShowData(results) ;
        System.out.println();
       
        // next few lines find the mode and print it
        System.out.println("The mode: " + findTheMode(results));
        System.out.println();

        // next few lines tally and remove a number
        System.out.println("Which number would you like to tally and remove?");
        int target = scan.nextInt();
        System.out.println(target + "'s rolled: " + tallyNum(results, target));
        removeNums(results, target);
        System.out.println("Roll Results without " + target + "'s: ");
        ShowData(results);
        System.out.println();
    }
    //-----------------------------------------------------------------------------------
    // Generate data 1-6
    public static void getData(ArrayList < Integer > results, int rolls) {
        for (int i = 0; i < rolls; i++) {
            results.add((int) (Math.random() * 6) + 1); // 1-6
        }
    }
    //_______________________________________________________
    // Show data
    public static void ShowData(ArrayList < Integer > results) {
        int c = 1;
        for (int i: results) {
            System.out.println("Roll " + c++ + " was " + i); // print and increment in one line
        }
    }
    //-----------------------------------------------------------------------------------

    // Count how many 5's were rolled
    public static int tallyNum(ArrayList < Integer > results, int num) {
        int count = 0;
        for (int i: results) { // iterates through ArrayList 
            if (i == num) { // conditional check
                count++;
            }
        }
        return count;
    }
    //-----------------------------------------------------------------------------------

    // Calculate the Mode
    public static int findTheMode(ArrayList < Integer > results) {
        // find the mode of the results arraylist
        int mode = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < results.size(); i++) { // iterate through each number
            for (int j = 0; j < results.size(); j++) { // nested loop to check if number is better than all numbers (in terms of mode)
                if (results.get(i) == results.get(j)) { // found repeated number
                    count++;
                }
            }
            if (count > max) { // update mode if better num found
                max = count;
                mode = results.get(i);
            }
            count = 0; // reset counter, since new mode was found
        }
        return mode;
    }
    //_______________________________________________________________
    // Remove the 5's from the ArrayList
    public static void removeNums(ArrayList < Integer > results , int num) {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i) == num) { // conditional check
                results.remove(i);
            }
        }
    }
    //-----------------------------------------------------------------------------------
    // Sort the data
    public static void selectionSort(ArrayList < Integer > results) {
        Collections.sort(results); // merge sort used internally
    }
}
