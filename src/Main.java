import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] mat;
        int m, n;

        System.out.println("Hello!! Please complete the matrix!");
        System.out.println("lines: ");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        System.out.println("columns: ");
        n = sc.nextInt();

        mat = new int[m][n];

        for (int i = 0; i<m; i++)
        {
            for (int j = 0; j<n; j++)
            {
                System.out.println("mat[" + i + "][" + j + "]: ");
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nA matriz resultante eh:\n");

        for (int i = 0; i<m; i++)
        {
            for (int j = 0; j<n; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("\nA matriz resultante transposta eh:\n");

        for (int i = 0; i<m; i++)
        {
            for (int j = 0; j<n; j++)
            {
                System.out.print(mat[j][i] + " ");
            }
            System.out.print("\n");
        }
    }
}