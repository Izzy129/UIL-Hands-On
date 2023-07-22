import java.util.*;
import java.io.*;
public class Lucy {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("Lucy.dat"));
        int D = scanner.nextInt(); // Number of drawings

        for (int i = 0; i < D; i++) {
            int N = scanner.nextInt(); // Number of lines in the drawing
            scanner.nextLine(); // Consume the remaining newline after reading the integer

            StringBuilder encodedDrawing = new StringBuilder();

            // Process each line of the drawing
            for (int j = 0; j < N; j++) {
                String line = scanner.nextLine();
                encodedDrawing.append(runLengthEncode(line)).append("\n");
            }

            // Print the encoded drawing for the current dataset
            System.out.println(encodedDrawing.toString() + "=====");
        }

        scanner.close();
    }

    // Function to perform run-length encoding for a given line
    private static String runLengthEncode(String line) {
        StringBuilder encodedLine = new StringBuilder();
        int count = 1;

        for (int i = 1; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            char previousChar = line.charAt(i - 1);

            if (currentChar == previousChar) {
                count++;
            } else {
                encodedLine.append(previousChar).append(count);
                count = 1;
            }
        }

        // Append the last character and its count
        encodedLine.append(line.charAt(line.length() - 1)).append(count);
        return encodedLine.toString();
    }
}