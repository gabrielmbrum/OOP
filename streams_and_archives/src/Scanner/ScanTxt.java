package Scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScanTxt {
    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(
                    new FileReader("input.txt")
            ));

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            s.close();
        }
    }
}
