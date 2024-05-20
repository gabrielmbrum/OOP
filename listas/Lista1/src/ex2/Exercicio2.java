package ex2;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o raio: ");
        int raio = sc.nextInt();

        System.out.println("\nO diâmetro é: " + (raio*2));
        System.out.println("\nA área é: ");
        System.out.format("%.3f\n", ((double)3*(double)raio*(double)raio*3.14));
        System.out.println("\nA circunferência é: " + (3.14*(double)raio*2.0));
    }
}
