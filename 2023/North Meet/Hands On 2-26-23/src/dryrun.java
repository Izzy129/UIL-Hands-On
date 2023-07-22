import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class dryrun {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("test.dat"));
        
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            out.print(scan.next());
        }
    }
}