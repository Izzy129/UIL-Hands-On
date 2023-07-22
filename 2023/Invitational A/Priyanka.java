import java.util.*;
import java.io.*;

public class Priyanka {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("priyanka.dat"));
        
        int cases = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < cases; i++) {
            String current = scan.nextLine();
            boolean isWoo = true;

            for (int j = 0; j < current.length(); j++) {
                String currentChar = "" + current.charAt(j);
                String nextChar = "" + current.charAt(j + 1);
                
                // print whether or not currentChar is a vowel
                System.out.println(currentChar.matches("[AEIOU]"));
                
                
                // if (currentChar.matches("[^AEIOU]")) {
                //     if (nextChar.matches("[^AEIOU]")) {
                //         isWoo = false;
                //         break;
                //     }
                // }

            }
            System.out.println(isWoo);
        }

    }
}