import java.util.*;
import java.io.*;

public class Oddpocalypse {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("Oddpocalypse.dat"));
        while (scan.hasNext()) {
            int number = scan.nextInt();
            System.out.print(number % 2 != 0 ? number  + "\n": "");   
        }
    }
}
