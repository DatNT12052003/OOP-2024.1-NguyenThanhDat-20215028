package hust.soict.globalict.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        try {
            String filename = "test.exe"; // Use a large file for testing
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

            long startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b; // String concatenation with +
            }
            long endTime = System.currentTimeMillis();

            System.out.println("File size: " + inputBytes.length + " bytes");
            System.out.println("Time taken with String concatenation: " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
