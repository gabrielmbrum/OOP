// package is a way to hold code together, a lot of times is 'com.main'
package matrix;

import java.util.Scanner;

public class Matrix {
    public static void main (String[] args) {
        // Declaration
        double[][] a, b;
        int line1, line2, column1, column2;
        Scanner sc = new Scanner(System.in);

        // Dimensions inputs
        System.out.print("CREATING THE FIRST MATRIX\n\nDigit the line quantify: ");
        line1 = sc.nextInt();
        System.out.print("Digit the column quantify: ");
        column1 = sc.nextInt();

        System.out.print("\nCREATING THE SECOND MATRIX\n\nDigit the line quantify: ");
        line2 = sc.nextInt();
        System.out.print("Digit the column quantify: ");
        column2 = sc.nextInt();

        // Checking if is it possible to multiply
        if (column1 != line2) {
            System.out.println("ERROR!!! Invalid matrix!");
            return;
        }

        // Initialization
        a = new double[line1][column1];
        b = new double[line2][column2];
        double[][] c = new double[line1][column2];

        // Value Inputs
        System.out.println("\nInserting matrix A\n");
        for (int i = 0; i<line1; i++) {
            for (int j = 0; j<column1; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                a[i][j] = sc.nextDouble();
            }
        }
        System.out.println("\nInserting matrix B\n");
        for (int i = 0; i<line2; i++) {
            for (int j = 0; j<column2; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                b[i][j] = sc.nextDouble();
            }
        }

        // Operations
        for(int i = 0; i < line1; i++) {
            for (int j = 0; j < column2; j++) {
                for (int k = 0; k < column1; k++) {
                    // I was just debugging :)
                    //System.out.println("\n" + a[i][k] + " " + b[k][j]);
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        // Showing result
        System.out.println("\nShowing the resultant matrix!!! :)\n");
        for (int i = 0; i<line1; i++) {
            for (int j = 0; j<column2; j++) {
                System.out.print("\tC[" + i + "][" + j + "]: " + c[i][j]);
            }
            System.out.println();
        }
    }
}
