import java.util.*;
import java.io.*;
public class Emily {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("Emily.dat"));
        while (scan.hasNext()) {
            int b1 = scan.nextInt();
            int b2 = scan.nextInt();
            int h = scan.nextInt();

            double area = ((b1 + b2)/2.0)*h;

            if (area % 1 == 0)
                System.out.printf("%.0f\n", area);
            else
                System.out.printf("%.1f\n", area);            
        }
    }
}