import java.util.*;
import java.io.*;

public class mean {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("mean.dat"));
        int cases = scan.nextInt();
        scan.nextLine();
        System.out.println("mean median mode");
        for (int i = 0; i < cases; i++) {
            int sum = 0;
            String s = scan.nextLine();
            
            Scanner currentScan = new Scanner(s);
            ArrayList<Integer> array = new ArrayList<>();
            int index = 0;
            while (currentScan.hasNext()) {
                array.add(currentScan.nextInt());
                sum+= array.get(index++);
            }
            currentScan.close();

            double mean = (double) sum/array.size();
            Collections.sort(array);
            
            double median = 0.0;
            if (array.size()%2 == 1) {
                median = array.get(array.size()/2);
            } else {
                median = ((array.get(array.size()/2) + array.get(array.size()/2-1))/2.0);
            }
            
            // Create a map to store the frequency of each element in the array list
            Map<Integer, Integer> frequencyMap = new HashMap<>();

            // Loop through the array list and increment the count for each element
            for (int num : array) {
                if (frequencyMap.containsKey(num)) {
                    frequencyMap.put(num, frequencyMap.get(num) + 1);
                } else {
                    frequencyMap.put(num, 1);
                }
            }

            // Loop through the frequency map and find the element(s) with the highest frequency
            double mode = 0.0;
            int maxFrequency = 0;
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() > maxFrequency) {
                    mode = entry.getKey();
                    maxFrequency = entry.getValue();
                }
            }
            // System.out.println(frequencyMap);


            System.out.printf("%4.1f ", mean); 
            System.out.printf("%6.1f ", median);
            System.out.printf("%4.1f", mode);
            System.out.println();
        }
    
    }
}
