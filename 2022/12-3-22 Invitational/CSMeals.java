import java.util.*;
import java.io.*;

public class CSMeals {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("csmeals.dat"));
        int cases = scan.nextInt();
        scan.nextLine();
        
        for (int i = 0; i < cases; i++) { // each case
            int shoppingLists = scan.nextInt();
            scan.nextLine();
            ArrayList<String> shoppingList = new ArrayList<>();
            
            for (int j = 0; j < shoppingLists; j++) { // loop to add shopping list items to shopping list array            
                String current = scan.nextLine();
                Scanner currentScan = new Scanner(current);
                
                while (currentScan.hasNext()) { 
                        shoppingList.add(currentScan.next());
                }
            }

            ArrayList<String> boughtItems = new ArrayList<>();
            for (int l = 0; l < shoppingLists; l++) { // loop to add bought items to bought items array
                String current = scan.nextLine();
                Scanner currentScan = new Scanner(current);
                
                while (currentScan.hasNext()) { 
                        boughtItems.add(currentScan.next());
                }
            }

            ArrayList<String> putBack = new ArrayList<>();

            for (String item: boughtItems) { // loop to go through and check if bought item is in shopping list
                if (shoppingList.contains(item)) {
                    shoppingList.remove(item); // removing for printing later
                } else { 
                    putBack.add(item); // extra item
                }
            }
            
            if (shoppingList.isEmpty()) { // all items in shopping list were bought
                if (!putBack.isEmpty()) { // extra items detected
                    System.out.print("PUT BACK "); 
                    printArray(putBack);
                } else { // no extra items
                    System.out.println("OK");
                }
            } else { // not all items in shopping list were bought
                System.out.print("BUY MORE ");
                printArray(shoppingList);
            }  
        }
    }
    public static void printArray(ArrayList<String> list) {
        for (String s: list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}