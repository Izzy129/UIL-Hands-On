import java.util.*;
import java.io.*;

public class Backstory {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new File("backstory.dat"));

        int cases = scan.nextInt();

        for (int i = 0; i < cases; i++) {
            String relevantDate = scan.next();
            // System.out.println(relevantDate);  
            relevantDate = relevantDate.replace("/", " ");
            // System.out.println(relevantDate); 
            Scanner relevantScanner = new Scanner(relevantDate);
            int relevantMonth = relevantScanner.nextInt();
            int relevantDay = relevantScanner.nextInt();
            int relevantYear = relevantScanner.nextInt();
            relevantScanner.close();


            Date plotRelevant = new Date(relevantYear, relevantMonth, relevantDay);

            int dates = scan.nextInt();

            ArrayList<Date> dateList = new ArrayList<>();
            for (int j = 0; j < dates; j++) {
                String currentDateString = scan.next();
                currentDateString = currentDateString.replace("/", " ");
                Scanner currentDateScanner = new Scanner(currentDateString);

                
                int month = currentDateScanner.nextInt();
                int day = currentDateScanner.nextInt();
                int year = currentDateScanner.nextInt();
                currentDateScanner.close();
                dateList.add(new Date(year, month, day));
            }

            Collections.sort(dateList);
            for (int j = 0; j < dateList.size(); j++) {
                if (!dateList.get(j).before(plotRelevant)) {
                    dateList.remove(j--);
                }
            }
            
            for (Date d: dateList) {
                // System.out.println(d.getDate());
                // System.out.println(d.getMonth() + "/" + d.getDate() + "/" + d.getYear());
                int month = d.getMonth();
                int date = d.getDate();
                int year = d.getYear();
                // if (month == 0) {
                //     month = 12;
                // }
                // if (year == 2013) {
                //     year = 2012;
                // }
                System.out.printf("%02d/%02d/%04d\n", month, date, year);
            }
            System.out.println();
            
        }
    }
}