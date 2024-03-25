package ex12;

public class Triangulo {
    private static int qtd = 0;
    private double base;
    private double lado1;
    private double lado2;


    // Constructors
    public Triangulo (double lado) { // equilateral triangle constructor
        this(lado, lado, lado);
    }

    public Triangulo (double base, double lados) { // constructor of isosceles triangle
        this(base, lados, lados);
    }

    public Triangulo (double base, double lado1, double lado2) {
        this.base = base;
        this.lado1 = lado1;
        this.lado2 = lado2;
        qtd++;
    }

    // Getters and Setters
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    // Methods
    public double getArea () {

        if (base == lado1 && base == lado2) {
            // equilateral triangle
            return (lado1*lado1*Math.sqrt(3)/4);
        } else if (lado1 == lado2) {
            // isosceles triangle
            double altura = Math.sqrt(lado1*lado1 - (base/2)*(base/2));
            return base*altura;
        } else {
            // scalene triangle
            double p = getPerimetro()/2;
            return (Math.sqrt(p*(p-base)*(p-lado1)*(p-lado2)));
        }
    }

    public double getPerimetro () {
        return (this.base + this.lado1 + this.lado2);
    }
}
