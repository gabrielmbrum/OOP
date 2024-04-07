package CommerceTechGear;

import java.util.Scanner;

public class DisplayLoja extends Loja {
    // campos
    private Loja loja;
    private Admin admin;

    // construtores
    public DisplayLoja (Loja loja, Admin admin) {
        this.loja = loja;
        this.admin = admin;
    }

    // getter and setter
    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    // métodos
    public void telaPrincipal() {
        int op = -1;

        System.out.println("BEM VINDO!!!");

        while (op != 0) {
            System.out.println("Qual tela deseja utilizar?");
            System.out.println("\t(1) Tela Usuario\n\t(2) Tela Administrador\n\t(0) Encerrar programa :(");
            System.out.print("R: ");
            op = Main.sc.nextInt();
            Main.sc.nextLine();

            if (op == 1)
                telaUsuario();
            else if (op == 2)
                telaAdmin();
        }

        System.out.println("\nOBRIGADO! VOLTE SEMPRE!!");

    }

    public void telaUsuario() {
        int op = 1;

        System.out.println("\n====================||===========||=================\n");
        System.out.println("\t\tSeja Bem-Vind@ ao Commerce TechGear!!");


        while (op != 0) {
            telaOpcoesUsuario();
            op = Main.sc.nextInt();
            Main.sc.nextLine();

            switch (op) {
                case 0: return;
                case 1: buscarProdutos(); break;
                case 2: break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\tOperação Inválida!!");
            }
        }

        //(1) Buscar Produto\n\t(2) Visualizar Carrinho\n\t(3) Remover item do Carrinho\n\t(4) Realizar Compra\n\t(5) Listar Produtos(0) Sair");

    }
    public void telaAdmin() {
        // campos
        String senha, usuario;
        int count = 0, op;

        System.out.println("\t\tBem vindo a tela de Administrador!");

        // verificação de credenciais
        do {

            System.out.print("Digite seu usuario: ");
            usuario = Main.sc.nextLine();

            System.out.print("Digite sua senha: ");
            senha = Main.sc.nextLine();

            count++;

        } while( ( !(admin.getSenha().equals(senha)) || !(admin.getUsuario().equals(usuario)) ) && count < 5);

        if (count > 5) {
            System.out.println("Limite de tentativas de login atingido!!!");
            return;
        }

        telaOpcoesAdmin();
        op = Main.sc.nextInt();
        Main.sc.nextLine();

        while (op < 0 || op > 4) {
            System.out.println("Operação Inválida!!!");
            System.out.print("Digite novamente a operação: ");
            op = Main.sc.nextInt();
            Main.sc.nextLine();
        }

        switch (op) {
            case 0: return;
            case 1:
            case 2:
            case 3:
            case 4:
        }
    }

    void buscarProdutos() {
        int op = 1;
        Produto produto;

        System.out.println("\n====================||===========||=================\n");

        while (op != 0) {
            System.out.println("\nDeseja buscar produto pelo:\n\t(1) Nome\n\t(2) ID\n\t(0) Sair");
            System.out.println("OPERAÇÃO: ");
            op = Main.sc.nextInt();
            Main.sc.nextLine();
            switch (op) {
                case 1:
                    System.out.print("\nDigite o nome: ");
                    String nome = Main.sc.nextLine();
                    produto = buscarProduto(nome);
                    verificaProduto(produto);
                    break;

                case 2:
                    System.out.print("Digite o id: ");
                    int id = Main.sc.nextInt();
                    Main.sc.nextLine();

                    produto = buscarProduto(id);

                    verificaProduto(produto);
                    break;
                case 0: return;
            }
        }

    }

    private void verificaProduto(Produto produto) {
        if (produto != null) {
            char c = 'c';

            System.out.print("Produto encontrado: " + produto.getNome() + " | Preço: ");
            System.out.format(" %.2f\n", produto.getPreco());

            while (c != 'S' && c != 's' && c != 'N' && c != 'n') {
                System.out.println("Adicionar ao carrinho? <S/N>");
                System.out.print("R: ");
                c = Main.sc.next().charAt(0);
            }

            if (c == 'S' || c == 's')
                adicionarAoCarrinho(produto);
        } else
            System.out.println("Produto não encontrado! :(");
    }

    void adicionarAoCarrinho(Produto produto) {};

    void realizarCompra() {};

    void gerenciarCategorias() {};

    void gerenciarProdutos() {};

    public Admin criarAdmin () {
        String cpf, usuario, senha, senhaConfirmacao;

        System.out.print("Digite seu CPF: ");
        cpf = Main.sc.nextLine();

        System.out.print("Digite seu usuário: ");
        usuario = Main.sc.nextLine();

        do {
            System.out.print("Digite sua senha: ");
            senha = Main.sc.nextLine();

            System.out.print("Confirme sua senha: ");
            senhaConfirmacao = Main.sc.nextLine();

        } while (!(senha.equals(senhaConfirmacao))); //this is a loop to prevent errors

        return (new Admin(cpf, usuario, senha)); //constrói o Administrador com as informações recebidas e o retorna
    }

    public void telaOpcoesUsuario () {
        System.out.println("Digite qual operação você deseja realizar:");
        System.out.println("\t(1) Buscar Produto\n\t(2) Adicionar Produto ao Carrinho\n\t(3) Visualizar Carrinho\n\t(4) Remover item do Carrinho\n\t(5) Realizar Compra\n\t(6) Listar Produtos\n\t(0) Sair");
        System.out.print("\nOPERAÇÃO: ");
    }

    public void telaOpcoesAdmin () {
        System.out.println("Digite qual operação você deseja realizar:");
        System.out.println("\t(1) Gerenciar Produtos\n\t(2) Gerenciar Categorias\n\t(3) Gerenciar Loja\n\t(4) Listar Produtos\n\t(0) Sair");
        System.out.print("\nOPERAÇÃO: ");
    }
}
