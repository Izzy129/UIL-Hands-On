import java.util.*;
import java.io.*;

public class Diem {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("diem.dat"));

        int cases = scan.nextInt();

        for (int i = 0; i < cases; i++) {
            int one = scan.nextInt();
            int two = scan.nextInt();

            System.out.println(one + two);
        }
    }
}
