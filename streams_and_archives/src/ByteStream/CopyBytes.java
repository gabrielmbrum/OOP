package ByteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\pastas\\java\\OOP-exercises\\streams\\src\\ByteStream\\input.txt");
            out = new FileOutputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\pastas\\java\\OOP-exercises\\streams\\src\\ByteStream\\output.txt");
            int c, count=0;

            while ((c = in.read()) != -1) {
                out.write(c);
                count++;
                System.out.println(c);
            }
            System.out.println("count: " + count);
            in.close();
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
