package Random;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) throws IOException {
        File fRand = new File("random.txt");
        RandomAccessFile raf = new RandomAccessFile(fRand, "rw");
        String words[] = {"poggers", "allan", "bruno", "bixo", "POO"};

        for (int i = 0; i < words.length; i++) {
            raf.writeUTF(words[i]);
        }

        raf.seek(0);
        raf.writeUTF("p0ggers");
        raf.seek(words.length);
        raf.writeUTF("new element");
        raf.seek(0);
        System.out.println("first element: " + raf.readUTF());
    }
}
