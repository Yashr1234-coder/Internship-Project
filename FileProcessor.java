package Scanner;



import java.io.*;

public class FileProcessor {

    public static void main(String[] args) {
        // Input and output file paths
        String inputFilePath = "C:\\Users\\yashr\\eclipse-workspace all programs\\Codeveda\\src\\Scanner\\input";
        String outputFilePath = "C:\\Users\\yashr\\eclipse-workspace all programs\\Codeveda\\src\\Scanner\\output";

        try {
            // Read the input file and process the content
            File inputFile = new File(inputFilePath);
            if (!inputFile.exists()) {
                throw new FileNotFoundException("Input file does not exist.");
            }

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            int wordCount = 0;
            int lineCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                wordCount += line.split("\\s+").length; // Split by whitespace to count words
            }
            reader.close();

            // Write the processed data to the output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            writer.write("Line Count: " + lineCount + "\n");
            writer.write("Word Count: " + wordCount + "\n");
            writer.close();

            System.out.println("Processing complete. Output written to " + outputFilePath);
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An IO error occurred: " + e.getMessage());
        }
    }
}
