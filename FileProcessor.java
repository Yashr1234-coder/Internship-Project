package Scanner;

import java.io.*;

public class FileProcessor {
    public static void main(String[] args) {
        String inputFile = "input.txt"; // Input file name
        String outputFile = "output.txt"; // Output file name

        try {
            // Read and process the input file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            int lineCount = 0;
            int wordCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                wordCount += line.split("\\s+").length;
            }
            reader.close();

            // Write the processed data to the output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write("Line Count: " + lineCount + "\n");
            writer.write("Word Count: " + wordCount + "\n");
            writer.close();

            System.out.println("Processing complete. Results written to " + outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
        } catch (IOException e) {
            System.out.println("Error: An IO exception occurred.");
        }
    }
}
