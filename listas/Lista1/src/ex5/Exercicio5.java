package ex5;

import java.util.Scanner;

public class Exercicio5 {
    private static final int max = 5;

    public static void main(String[] args) {

        // Declaration and Initialization
        double[] array = new double[max];
        Scanner sc = new Scanner(System.in);

        // Inserting array
        for (int i = 0; i<max; i++)
        {
            System.out.print("\narray[" + i + "]: ");
            array[i] = sc.nextDouble();
        }

        // This method put the first qtd biggers in the first positions of the array
        biggersFirst(array, 2);

        // Printing the result
        System.out.println("\nThe bigger value is: " + array[0] + "\nThe second bigger is: " + array[1]);

    }

    // Method to put the first qtd biggers in the first postions of the array
    public static void biggersFirst (double[] array, int qtd) {
        int i = 0;

        while (i<qtd) {
            int biggerPos = i;

            for (int j = i+1; j < max; j++) {
                if (array[j] > array[biggerPos])
                    biggerPos = j;
            }

            double aux = array[i];
            array[i] = array[biggerPos];
            array[biggerPos] = aux;

            i++;
        }
    }


}
