package ex12;

public class Quadrado {
    private static int qtd = 0;
    private double lado;

    // Constructors
    public Quadrado() {
        this(4);
    }
    public Quadrado(double lado) {
        this.lado = lado;
        qtd++;
    }

    // Getters
    public double getLado() {
        return lado;
    }

    // Setters
    public void setLado(double lado) {
        this.lado = lado;
    }

    // Methods
    public double getArea () {
        return (this.lado*this.lado);
    }

    public double getPerimetro () {
        return (this.lado*4);
    }
}
