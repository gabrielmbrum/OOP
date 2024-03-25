package ex12;

public class Circulo {
    private static int qtd = 0;
    private double raio;

    // Constructor
    public Circulo(double raio) {
        this.raio = raio;
    }

    // Getters and Setters
    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    // Methods
    public double getArea () {
        return (3.14*raio*raio);
    }

    public double getCircunferencia () {
        return (2*3.14*raio);
    }
}
