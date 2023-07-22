import java.util.*;
import java.io.*;

public class similar {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("similar.dat"));
        int cases = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < cases; i++) {
            int s1, s2, s3, s4, s5, s6 = 0;
            s1 = scan.nextInt();
            s2 = scan.nextInt();
            s3 = scan.nextInt();
            s4 = scan.nextInt();
            s5 = scan.nextInt();
            s6 = (s4*s3) / s1;
            System.out.println(s4+ " " + s5 + " " + s6);
        }
    }
}
