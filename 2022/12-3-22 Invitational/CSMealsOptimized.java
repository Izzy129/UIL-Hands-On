import java.util.*;
import java.io.*;

public class CSMealsOptimized {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("csmeals.dat"));
        int cases = scan.nextInt();
        scan.nextLine();
        
        for (int i = 0; i < cases; i++) { // each case
            int shoppingLists = scan.nextInt();
            scan.nextLine();
            Set<String> shoppingList = new HashSet<>();
            Set<String> boughtItems = new HashSet<>();

            for (int j = 0; j < shoppingLists; j++) { // loop to add shopping list items to shopping list array            
                String current = scan.nextLine();
                Scanner currentScan = new Scanner(current);
                
                while (currentScan.hasNext()) { 
                        shoppingList.add(currentScan.next());
                }
            }

            for (int l = 0; l < shoppingLists; l++) { // loop to add bought items to bought items array
                String current = scan.nextLine();
                Scanner currentScan = new Scanner(current);
                
                while (currentScan.hasNext()) { 
                        boughtItems.add(currentScan.next());
                }
            }

            Set<String> putBack = new HashSet<>();
            putBack.addAll(boughtItems);
            putBack.removeAll(shoppingList); // extra items

            if (shoppingList.isEmpty()) { // all items in shopping list were bought
                if (!putBack.isEmpty()) { // extra items detected
                    System.out.print("PUT BACK "); 
                    printSet(putBack);
                } else { // no extra items
                    System.out.println("OK");
                }
            } else { // not all items in shopping list were bought
                System.out.print("BUY MORE ");
                printSet(shoppingList);
            }  
        }
    }
    public static void printSet(Set<String> set) {
        for (String s: set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}