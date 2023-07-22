import java.util.*;
import java.io.*;

public class Store {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("store.dat"));

        int cases = scan.nextInt();

        for (int i = 0; i < cases; i++) {
            int itemsNeeded = scan.nextInt();

            int dollars = scan.nextInt();
            int quarters = scan.nextInt();
            int dimes = scan.nextInt();
            int nickels = scan.nextInt();
            int pennies = scan.nextInt();

            double money = (dollars * 1.0) + (quarters * 0.25) + (dimes * .10) + (nickels * .05) + (pennies * 0.01);
            double total = 0.0;

            ArrayList<Double> itemPrices = new ArrayList<>();


            for (int j = 0; j < itemsNeeded; j++) {
                scan.next();
                double currentPrice = scan.nextDouble();
                total += currentPrice;
                itemPrices.add(currentPrice);
            }
            
            for (int j = 0; j < itemsNeeded; j++) {
                total -= itemPrices.get(j);
                
            }

            

            if (total > money) {
                boolean comeAgain = true;
                for (Double d : itemPrices) {
                    if (money >= d.doubleValue()) {
                        System.out.println("Come again");
                        comeAgain = false;
                        break;
                    }
                }
                if (comeAgain) {
                    System.out.println("Mission failed");
                }
                
            } else if (money >= total) {
                System.out.println("Got all items");
            } else {
                System.out.println("Come again");
            }
            
        }
    }
}
