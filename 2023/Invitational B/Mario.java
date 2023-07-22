import java.util.*;
import java.io.*;
public class Mario {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new File("mario.dat"));

        int testCases = scan.nextInt();
    
    
        for(int i = 0; i < testCases; i++ ) {
            int num = scan.nextInt();
            String n = scan.next();

            if (num > n.length()) {
                System.out.println("error");
            } else if(num > n.length()/2) {
                System.out.println(reverse(n));   
            } else {
                String lastLetters = n.substring(0, num);
                lastLetters = reverse(lastLetters);

                String firstLetters = n.substring(n.length()-num);
                firstLetters = reverse(firstLetters);

                String result = firstLetters + n.substring(num, n.length()-num) + lastLetters;
                System.out.println(result);                
            }
        }
        scan.close();
    }
   public static String reverse(String n ) {
        String s ="";
        for(int i = n.length()-1; i >= 0; i--) {
            s += n.charAt(i);
        }
        return s;
   } 
}
