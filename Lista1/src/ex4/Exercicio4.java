package ex4;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char a;

        System.out.print("Digite um caracter: ");
        a = sc.next().charAt(0);

        System.out.println("\nNa tabela ASCII, esse caracter é o número: " + (int)a);
    }
}
