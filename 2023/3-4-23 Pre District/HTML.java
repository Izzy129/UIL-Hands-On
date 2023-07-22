import java.io.*;
import java.util.*;

public class HTML {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("html.dat"));
        int cases = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < cases; i++) {
            String site1 = scan.nextLine();
            String site2 = scan.nextLine();
            
            
            // next 4 lines remove everything but the tags, e.g. div in <div>
            site1 = site1.replaceAll(">(.*?)<", " ");
            site1 = site1.replaceAll("<", "");
            site1 = site1.replaceAll(">", "");
            site1 = site1.replaceAll("/", "");

            // next 4 lines remove everything but the tags, e.g. div in <div>
            site2 = site2.replaceAll(">(.*?)<", " ");
            site2 = site2.replaceAll("<", "");
            site2 = site2.replaceAll(">", "");
            site2 = site2.replaceAll("/", "");

            System.out.println(site1.equals(site2) ? "same" : "different");
        }
    }
}