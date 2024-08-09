import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        InitialScreen();
    }

    private static void InitialScreen() {

        System.out.println("\t\tBem vindo ao Banco Alura!!!");
        System.out.println("Insira seus dados abaixo!");
        System.out.print("Nome: ");
        String nome = Main.sc.nextLine();
        System.out.print("CPF: ");
        String cpf = Main.sc.nextLine();
        System.out.print("Saldo Inicial: ");
        Double saldo = Main.sc.nextDouble();

        Account account = new Account(nome, cpf, saldo);

        MainScreen(account);
    }

    private static void MainScreen(Account ac) {
        System.out.println("*****************************************");
        System.out.println("Bem vindo " + ac.getName() + "!!!");
        System.out.format("Saldo: %.2f\n", ac.getBalance());
        System.out.println("*****************************************");

        OptionsMenu();
        int op = Main.sc.nextInt();

        switch (op) {
            case 1:
                System.out.println("Digite o valor que deseja receber");
                System.out.print("R: ");
                double valor = Main.sc.nextDouble();
                if (valor > 0)
                    ac.setBalance(ac.getBalance() + valor);
                else
                    System.out.println("VALOR INVÁLIDO!!!");
                break;

            case 2:
                System.out.println("Digite o valor que deseja transferir");
                System.out.print("R: ");
                double valorTrasnferencia = Main.sc.nextDouble();
                if (valorTrasnferencia > ac.getBalance())
                    System.out.println("VALOR INVÁLIDO");
                else
                    ac.setBalance(ac.getBalance() - valorTrasnferencia);
                break;

            case 3:
                System.out.println("Opção inválida!!");
                return;
        }

        MainScreen(ac);
    }

    private static void OptionsMenu() {
        System.out.println("Qual ação deseja realizar?");
        System.out.println("\t1 - Receber Valor");
        System.out.println("\t2 - Transferir Valor");
        System.out.println("\t3 - Sair");
        System.out.print("\nR: ");
    }
}