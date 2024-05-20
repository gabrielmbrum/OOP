package TesteLojaJogos;

import java.util.Scanner;

public class TesteLojaJogos {
    public static void main(String[] args) {
        JogoTabuleiro a = new JogoTabuleiro("Jenga", 2016, 50);
        JogoTabuleiro b = new JogoTabuleiro("Torre Copos", 2014, 100);

        LojaJogos x = new LojaJogos("Rihappy");
        LojaJogos y = new LojaJogos("ManiaKids");

        // operations
        int op = 0;
        Scanner sc = new Scanner(System.in);
        char aux;
        while (op != -1) {
            System.out.println("\nOperações:\n\t1 - Adicionar Jogos\n\t2 - Buscar Jogos\n\t3 - Listar Jogos\n\t-1 - SAIR");
            System.out.print("op: ");
            op = sc.nextInt();
            sc.nextLine(); //clean buffer

            switch (op) {
                case 1:
                    System.out.print("loja: ");
                    aux = sc.next().charAt(0);
                    if (aux == 'x') {
                        x.addJogo(a);
                        x.addJogo(b);
                    }
                    else {
                        y.addJogo(a);
                        y.addJogo(b);
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome do jogo: ");
                    String busca = sc.nextLine();

                    if (x.buscaJogo(busca))
                        System.out.println("Loja " + x.getNome() + " possui!");
                    else if (y.buscaJogo(busca))
                        System.out.println("Loja " + y.getNome() + " possui!");
                    else
                        System.out.println("Nenhua loja possui :(");
                    break;

                case 3:
                    System.out.print("loja: ");
                    aux = sc.next().charAt(0);
                    if (aux == 'x')
                        x.listarJogos();
                    else
                        y.listarJogos();
                    break;

            }
        }
    }
}
