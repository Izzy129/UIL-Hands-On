import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class BackstoryLocalTime {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new File("backstory.dat"));

        int cases = scan.nextInt();

        for (int i = 0; i < cases; i++) {
            // relevant date of case
            String relevantDateString = scan.next();
            // a lot better than making a whole new scanner lol
            String relevantMonth = relevantDateString.substring(0,2);
            String relevantDay = relevantDateString.substring(3,5);
            String relevantYear = relevantDateString.substring(6);

            // makes a new localdate with relevantmonth, day, year
            LocalDate relevantDate = LocalDate.of(Integer.parseInt(relevantYear), Integer.parseInt(relevantMonth), Integer.parseInt(relevantDay));
            
            int numOfDates = scan.nextInt();
            ArrayList<LocalDate> dates = new ArrayList<>();
            
            for (int j = 0; j < numOfDates; j++) {
                String currentDateString = scan.next();
                String currentMonth = currentDateString.substring(0,2);
                String currentDay = currentDateString.substring(3,5);
                String currentYear = currentDateString.substring(6);

                LocalDate currentDate = LocalDate.of(Integer.parseInt(currentYear), Integer.parseInt(currentMonth), Integer.parseInt(currentDay));
                dates.add(currentDate);
            }
            
            for (int j = 0; j < dates.size(); j++) {
                if (!dates.get(j).isBefore(relevantDate)) {
                    dates.remove(j--); // remove the date and decrement j
                }
            }

            // dates must be sorted chronologically
            Collections.sort(dates);


            for (LocalDate d : dates) {
                int month = d.getMonthValue();
                int day = d.getDayOfMonth();
                int year = d.getYear();

                System.out.printf("%02d/%02d/%04d\n", month, day, year); 
            }
            System.out.println();
        }
    }
}