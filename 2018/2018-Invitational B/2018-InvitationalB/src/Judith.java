import java.util.*;
import java.io.*;
import java.math.BigDecimal;
public class Judith {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("Judith.dat"));
        ArrayList<BigDecimal> list = new ArrayList<BigDecimal>();
        while (scan.hasNext()) {
            BigDecimal a = scan.nextBigDecimal();
            list.add(a);
        }
        
        Collections.sort(list);
        for (BigDecimal a : list) {
            System.out.println(a);
        }
    }
}