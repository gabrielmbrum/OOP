package ex3;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {

        // Variables
        Scanner sc = new Scanner(System.in);
        int a, b;

        // Inputs
        System.out.print("\nA é múltiplo de B?\n\nDigite o número A: ");
        a = sc.nextInt();
        System.out.print("Digite o número B: ");
        b = sc.nextInt();

        // Checking if a or b is a zero
        if (a == 0 || b == 0)
        {
            System.out.println("\nWhy so serius? HAHAHAHAHAHAHAH");
            return;
        }

        // Checking if is it a multiple of b
        if (a % b == 0)
            System.out.println("\nÉ multiplo!!!");
        else
            System.out.println("\nNão é multiplo!!!");
    }
}
