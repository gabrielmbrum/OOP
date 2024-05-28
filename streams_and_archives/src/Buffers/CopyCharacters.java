package Buffers;

import java.io.*;

public class CopyCharacters {
    public static void main(String[] args) {
        FileReader in = null;
        BufferedReader buffIn = null;
        FileWriter out = null;
        BufferedWriter buffOut = null;

        try {
            in = new FileReader("input.txt");
            buffIn = new BufferedReader(in);
            out = new FileWriter("output.txt");
            buffOut = new BufferedWriter(out);
            int count=0;
            String c;
            while ((c = buffIn.readLine()) != null) {
                buffOut.write(c);
                buffOut.newLine();
                count++;
                System.out.println(c);
            }
            System.out.println("count: " + count);
            buffOut.close();
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
