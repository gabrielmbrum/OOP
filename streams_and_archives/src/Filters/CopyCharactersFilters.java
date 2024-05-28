package Filters;

import java.io.*;

public class CopyCharactersFilters {
    public static void main(String[] args) {
        FileInputStream in = null;
        InputStreamReader filterIn = null;
        FileOutputStream out = null;
        OutputStreamWriter filterOut = null;

        try {
            in = new FileInputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\pastas\\java\\OOP-exercises\\streams\\src\\Filters\\input.txt");
            filterIn = new InputStreamReader(in);
            out = new FileOutputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\pastas\\java\\OOP-exercises\\streams\\src\\Filters\\output.txt");
            filterOut = new OutputStreamWriter(out);
            int c, count=0;

            while ((c = filterIn.read()) != -1) {
                filterOut.write(c);
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
