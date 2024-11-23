package hust.soict.globalict.garbage;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTestFile {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("test.exe")) {
            for (int i = 0; i < 1000000; i++) {
                fos.write(("Line " + i + "\n").getBytes());
            }
            System.out.println("File created: test.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

