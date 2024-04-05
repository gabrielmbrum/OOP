package ex1;

public class MainTempo {
    public static void main(String[] args) {
        Tempo a, b, c;

        a = new Tempo();
        b = new Tempo(11, 44, 35);
        c = new Tempo(2, 25, 10);


        a = a.SomaSobre(b, c);
        System.out.print("\nPrintando A:");
        a.Print();

        System.out.print("\nPrintando C:");
        c.Print();

        c.Soma(b);
        System.out.print("\nPrintando C (somado):");
        c.Print();
    }
}
