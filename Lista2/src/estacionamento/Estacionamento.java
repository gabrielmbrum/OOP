package estacionamento;

public class Estacionamento {
    public static void main(String[] args) {
        Carro a, b;

        a = new Carro("AAA1A11", "Jeep Renegade", 12, 14);
        b = new Carro("BBB1B11", "Uno", 13, 14);

        a.print();
        System.out.print("\n=================||===============\n\n");
        b.print();
    }
}
