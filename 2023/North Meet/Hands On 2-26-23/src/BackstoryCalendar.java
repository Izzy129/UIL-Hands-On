import java.util.*;
import java.io.*;
public class BackstoryCalendar {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("backstory.dat"));

        int cases = scan.nextInt();
        
        for (int i = 0; i < cases; i++) {
            String relevantDateString = scan.next();
            relevantDateString = relevantDateString.replace("/", " ");

            Scanner relScanner = new Scanner(relevantDateString);
            int relevantMonth = relScanner.nextInt();
            int relevantDay = relScanner.nextInt();
            int relevantYear = relScanner.nextInt();
            relScanner.close();

            // make a new calandar date with relevantmonth, day, year
            Calendar relevantDate = new GregorianCalendar(relevantYear, relevantMonth, relevantDay);

            int numOfDates = scan.nextInt();

            ArrayList<Calendar> dates = new ArrayList<>();

            for (int j = 0; j < numOfDates; j++) {
                String currentDateString = scan.next();
                currentDateString = currentDateString.replace("/", " ");

                Scanner currentScanner = new Scanner(currentDateString);
                int month = currentScanner.nextInt();
                int day = currentScanner.nextInt();
                int year = currentScanner.nextInt();
                currentScanner.close();
                if (year == 12) {
                    year --;
                }
                // System.out.printf("%02d/%02d/%04d\n", month, day, year);
                Calendar currentDate = new GregorianCalendar(year, month, day);
                dates.add(currentDate);

            }
            
            Collections.sort(dates);
            
            for (int j = 0; j < dates.size(); j++) {
                if (!dates.get(j).before(relevantDate)) {
                    dates.remove(j--);
                }
            }
            
            for (Calendar c: dates) {
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                int year = c.get(Calendar.YEAR);

                if (month == 0) {
                    month = 12;
                }

                
                System.out.printf("%02d/%02d/%04d\n", month, day, year);
            }
            System.out.println();
        }
    }
}
