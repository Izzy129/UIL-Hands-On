import java.util.*;
import java.io.*;

public class Sunny {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("sunny.txt"));

        ArrayList<String> classes = new ArrayList<>();
        while (scan.hasNext()) {
            String current = scan.nextLine();
            Scanner currentScan = new Scanner(current);
            String courseNum = currentScan.next();
            String courseName = "";

            while (currentScan.hasNext()) { // scans all remaining words in line (course name size is variable)
                courseName+= currentScan.next() + " "; 
            }

            String result = courseName + "(" + courseNum + ")"; // build proper string

            classes.add(result);
            currentScan.close(); // closes mem leak
        }
        Collections.sort(classes); // sort alphabetically

        for (String s: classes) { // printing
            System.out.println(s);
        }
    }
}