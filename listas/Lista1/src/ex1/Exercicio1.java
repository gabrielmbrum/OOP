package ex1;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        // Variables
        int a, b, c, bigger, smaller;
        Scanner sc = new Scanner(System.in);

        // Inputs
        System.out.print("\nDigite o valor de a: ");
        a = sc.nextInt();
        System.out.print("\nDigite o valor de b: ");
        b = sc.nextInt();
        System.out.print("\nDigite o valor de c: ");
        c = sc.nextInt();

        // Finding the bigger and smaller vars

        if (a >= b && a >= c) {
            bigger = a;
        } else bigger = Math.max(b, c);

        if (a <= b && a <= c) {
            smaller = a;
        } else smaller = Math.min(b, c);

        // Outputs

        System.out.println("\nThe sum is: " + (a+b+c));
        System.out.print("\nThe average is: ");
        System.out.format("%.3f", (((float)a+(float)b+(float)c)/3.0)); //it's to format the output with just 3 decimal
        System.out.println("\n\nThe product is: " + (a*b*c));
        System.out.println("\nThe bigger is: " + bigger);
        System.out.println("\nThe smaller is: " + smaller);
    }
}
