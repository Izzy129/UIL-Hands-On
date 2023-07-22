import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Shivani {
   
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("shivani.dat"));
        int cases = scan.nextInt();

        for (int i = 0; i < cases; i++) {
            int n = scan.nextInt();
            BigInteger bigSum = BigInteger.valueOf(0);
            long layers = 0;

            for (int j = 1; j<=n; j++) {
                layers = layers + j;
                // sum += layers;
                bigSum = bigSum.add(BigInteger.valueOf((layers)));
            }
            
            System.out.println(bigSum);
        }
    }
}
