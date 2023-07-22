import java.util.*;
import java.io.*;
public class Barb {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("Barb.dat"));
        while (scan.hasNext()) {
            String s = scan.next();
            // reverse s
            String rev = reverse(s).toUpperCase();
            String third = "";
            if (s.length() % 2 != 0)
                third = s.substring(0, s.length()/2 +1);
            else 
                third = s.substring(0, s.length()/2);

            third = reverse(third);
            String forth = s.substring(s.length()/2).toUpperCase();
            
            System.out.println(s + " " + rev.toUpperCase()  + " " + third + " " + forth);
        }
    }
    public static String reverse(String s) {
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }
}