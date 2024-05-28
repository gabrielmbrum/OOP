package Objects;

import java.io.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream("out.dat"));
            BigDecimal num1 = new BigDecimal(1000);
            BigDecimal num2 = new BigDecimal(20000);
            out.writeObject(num1);
            out.writeObject(num2);
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BigDecimal num3, num4;
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(new FileInputStream("out.dat"));
            num3 = (BigDecimal) in.readObject();
            num4 = (BigDecimal) in.readObject();
            System.out.format("Num1 = %d. Num2 = %d", num3.intValue(), num4.intValue() );
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
