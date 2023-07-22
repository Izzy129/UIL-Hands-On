import java.util.*;
import java.io.*;

public class Vigenere {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("vigenere.dat"));

        int cases = scan.nextInt();


        char[] characters = null;
        for (int i = 0; i < cases; i++) {
            String s = scan.next();

            characters = s.toCharArray();
            Arrays.sort(characters);

            for (char c: characters) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
