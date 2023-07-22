import java.util.*;
import java.io.*;
public class pr11 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr11.dat"));
        int cases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < cases; i++) {
            double gallons = scan.nextDouble();
            double todayPrice = scan.nextDouble();
            double yesterdayPrice = scan.nextDouble();
            
            if (todayPrice == yesterdayPrice) {
                System.out.println("PAID THE SAME");
            } else if (todayPrice > yesterdayPrice) {
                System.out.printf("PAID MORE: $%.2f\n",(gallons*todayPrice) - (gallons*yesterdayPrice));
            } else {
                System.out.printf("SAVED: $%.2f\n",(gallons*yesterdayPrice) - (gallons*todayPrice));
            }
        }
    }
}