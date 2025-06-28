package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class  Task2 {
    public static void main(String[] args) {
        String filePath = " "; // File path.
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
