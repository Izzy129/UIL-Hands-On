import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Candy {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("Candy.dat"));
        int cases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < cases; i++) {
            int amountOfNums = scan.nextInt();

            ArrayList<BigInteger> nums = new ArrayList<>();

            for (int j = 0; j < amountOfNums; j++) {
                nums.add(new BigInteger("" + scan.nextInt()));
            }

            
            
            if (nums.size() == 2) {
                BigInteger theGcdBigInteger = nums.get(0).gcd(nums.get(1));
                int result =  (nums.get(0).intValue() * nums.get(1).intValue()) / theGcdBigInteger.intValue();
                System.out.println(result);
            } else {
                
                for (int j = 0; j < nums.size()-1; j++) {

                }
            }

            
        }
    }
}