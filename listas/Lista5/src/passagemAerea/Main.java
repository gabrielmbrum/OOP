package passagemAerea;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static SistemaReservas system = new SistemaReservas(new ArrayList<Passagem>());
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;

        do {
            System.out.println("\ndigite a ação que deseja realizar: ");
            System.out.println("\t(1) add passagem");
            System.out.println("\t(2) rm passagem");
            System.out.println("\t(3) listar passagens");
            System.out.println("\t(4) buscar passagem");
            System.out.println("\t(5) calcular preço final de passagem");
            System.out.println("\t(0) sair");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1: adicionarPassagem(); break;
                case 2: removerPassagem(); break;
                case 3: system.listarPassagens(); break;
                case 4: buscarPassagem(); break;
                case 5: calcularPrecoFinal();
            }
        } while (op != 0);
    }

    private static void adicionarPassagem() {
        LocalDateTime now = LocalDateTime.now();// without formatting
                                                //formatting
                                                //DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                                                //String formatDateTime = now.format(format);
        String codigo, origem, destino;
        double preco = 100;

        System.out.print("Código: ");
        codigo = sc.nextLine();

        System.out.print("Origem: ");
        origem = sc.nextLine();

        System.out.print("Destino: ");
        destino = sc.nextLine();

        System.out.print("Preço: ");
        preco = sc.nextDouble();

        boolean executiva = true;
        System.out.print("\né executiva?\nR: ");
        char bool = sc.next().charAt(0);
        if (bool == 'n') executiva = false;

        Passagem passagem;
        if (executiva)
            passagem = new PassagemExecutiva(codigo, origem, destino, preco, now);
        else
            passagem = new PassagemEconomica(codigo, origem, destino, preco, now);

        system.adicionarPassagem(passagem);
    }

    private static void removerPassagem() {
        System.out.print("Digite o código da passagem que deseja remover: ");
        String code = sc.nextLine();
        system.removerPassagem(code);
    }

    private static void buscarPassagem() {
        System.out.print("Digite o código da passagem que deseja remover: ");
        String code = sc.nextLine();

        Passagem passagem = system.buscarPassagem(code);
        if (passagem != null) {
            System.out.println("Passagem encontrada:");
            ((PassagemAbstrata) passagem).mostrarPassagem();
        }

    }

    private static void calcularPrecoFinal () {
        System.out.print("Digite o código da passagem que deseja remover: ");
        String code = sc.nextLine();
        double precoFinal = -1;

        try {
            precoFinal = system.calcularPrecoFinal(code);
        } catch (PassagemInexistenteException e) {
            e.printStackTrace();
        }

        System.out.print("Preço final: R$ ");
        System.out.format("%.2f", precoFinal);
    }

}
