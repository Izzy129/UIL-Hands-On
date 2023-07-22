import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Ultimate {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("ultimate.dat"));
        int cases = scan.nextInt();
        String[] arrKey = {"LEFT" ,"LEFT", "A", "RIGHT", "LEFT" ,"RIGHT" ,"DOWN" ,"A", "B" ,"RIGHT" ,"UP"};
        // System.out.println(Arrays.toString(arrKey));
        double tally = 0;
        scan.nextLine();
       /*  for(int i = 0; i < cases ; i++) {
            // scan.nextLine();
            String s = scan.nextLine();
            // System.out.println(s);
            ArrayList<String> tempArr = new ArrayList<>();

            Scanner currentScanner = new Scanner(s);

            while (currentScanner.hasNext()) {
                tempArr.add(currentScanner.next());
            }
            
            for(int j = 0; tempArr.size() == arrKey.length && j < arrKey.length; j++) {
                if(tempArr.get(j).equals(arrKey[j])) {
                    tally++;
                }
            }
            if(tempArr.size()> arrKey.length) {
                S;
                System.out.printf("%.2f\n" , tally/tempArr.size());
            } else {
                System.out.printf("%.2f\n" , tally / arrKey.length);
            }*/

            for(int i = 0; i < cases; i++)  {
                int j = 0; 
                int additionals = 0;
                tally = 0;
                Scanner sss = new Scanner(scan.nextLine());
                while(sss.hasNext() && j < arrKey.length) {
                    if(sss.next().equals(arrKey[j])) {
                        tally++; 
                    }
                    // System.out.println("loop");
                    j++;
                }
                if(sss.hasNext()) {
                    while(sss.hasNext()) {
                        additionals++;
                        sss.next();
                    }
                    System.out.printf("%.2f" , 100*tally/(additionals + arrKey.length));
                    System.out.println("%");

                }
                else { 
                    System.out.printf("%.2f" , 100*tally/(arrKey.length));
                    System.out.println("%");
                }
                
            }
        }


    }



