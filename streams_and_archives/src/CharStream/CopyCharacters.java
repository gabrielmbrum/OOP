package CharStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) {
        FileReader inp = null;
        FileWriter out = null;

        try {
            inp = new FileReader("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\pastas\\java\\OOP-exercises\\streams\\src\\CharStream\\input.txt");
            out = new FileWriter("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\pastas\\java\\OOP-exercises\\streams\\src\\CharStream\\output.txt");
            int c, count=0;
            while ((c = inp.read()) != -1) {
                out.write(c);
                count++;
            }
            System.out.println(count);
            inp.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
