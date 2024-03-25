package ex12;

public class Main {
    public static void main(String[] args) {
        Circulo a, b, c;
        Quadrado d, e, f;
        Triangulo g, h, i;

        a = new Circulo(3);
        b = new Circulo(5);

        d = new Quadrado(2);
        f = new Quadrado(10);

        g = new Triangulo(7);
        h = new Triangulo(3, 4);
        i = new Triangulo(20 , 16, 6);

        System.out.println("area de a: " + a.getArea());
        System.out.println("circunferencia de b: " + b.getCircunferencia());
        System.out.println("area de d: " + d.getArea());
        System.out.println("perimetro de f: " + f.getPerimetro());
        System.out.println("area de g: " + g.getArea());
        System.out.println("area de h: " + h.getArea());
        System.out.println("area de i: " + i.getArea());
        System.out.println("perimetro de i: " + i.getPerimetro());

        System.out.println("\n\nFIM :)\n");
    }
}
