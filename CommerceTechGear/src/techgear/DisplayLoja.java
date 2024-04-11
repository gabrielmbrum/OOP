package techgear;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisplayLoja extends Loja {
    // campos
    private Loja loja;
    private Admin admin;
    private Carrinho carrinho;

    // construtor
    public DisplayLoja (Loja loja, Admin admin, Carrinho carrinho) {
        this.loja = loja;
        this.admin = admin;
        this.carrinho = carrinho;
    }

    // getters and setters
    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Admin getAdmin () {return admin;}

    public Carrinho getCarrinho () {return carrinho;}

    public void setCarrinho (Carrinho carrinho) {this.carrinho = carrinho;}

    // métodos
    public void telaPrincipal() {
        int op = -1;

        System.out.println("BEM VINDO!!!");

        while (op != 0) {
            System.err.println("\nQual tela deseja utilizar?");
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
                case 3: visualizarCarrinho(); break;
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
        // (1) Gerenciar Produtos(2) Gerenciar Categorias(3) Gerenciar Loja(4) Listar Produtos(0) Sair");
        switch (op) {
            case 0: return;
            case 1:
                gerenciarProdutos(op);
                break;

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

    void adicionarAoCarrinho(Produto produto) {
        carrinho.getProdutos().add(produto);
    };

    void realizarCompra() {};

    void gerenciarCategorias() {};

    void gerenciarProdutos(int op) {
        while (op!=0) {
            System.out.println("\nO que deseja fazer?\n\t(1) Adicionar Produto (via Arquivo)\n\t(2) Adicionar Produto (manualmente)\n\t(3) Remover Produto\n\t(4) Listar Produtos\n\t(0) Voltar");
            System.out.print("OPERAÇÃO: ");
            op = Main.sc.nextInt();
            Main.sc.nextLine();

            switch (op) {
                case 1:
                    adicionarPorArquivo();
                    break;
                case 2:
                    adicionarManualmente();
                    break;
            }
        }
    }

    private void adicionarManualmente() {
        // campos
        char op;
        int id, quantidade;
        double preco;
        String nome, descricao, marca;
        Categoria categoria;

        System.out.print("ID: ");
        id = Main.sc.nextInt();

        System.out.print("Nome: ");
        nome = Main.sc.nextLine();

        System.out.print("Preço: ");
        preco = Main.sc.nextDouble();

        System.out.print("Descrição: ");
        descricao = Main.sc.nextLine();

        System.out.print("Marca: ");
        marca = Main.sc.nextLine();

        System.out.print("Categoria (ID): ");


        System.out.print("Quantidade: ");

        do {
            System.out.println("Produto Físico ou Virtual? <F/V>");
            System.out.print("R: ");
            op = Main.sc.next().charAt(0);
        } while (op != 'F' && op != 'V');

        if (op == 'F') {
            double peso;
            String dimensoes;

        }
    }

    private void adicionarPorArquivo() {
        File arquivo;
        Scanner scanner;
        String path, linha;
        String[] campos;

        System.out.print("\nDigite o caminho para o arquivo: ");
        path = Main.sc.nextLine();

        arquivo = new File(path);

        // confere se o arquivo foi aberto corretamente
        try {
            scanner = new Scanner(arquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DisplayLoja.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            campos = linha.split("#");
            Categoria categoria = buscarCategoria(Integer.parseInt(campos[5]));

            // confere se a categoria do produto é existente
            if (categoria == null) {
                System.out.println("Categoria do produto de ID " + campos[0] + " não encontrada!!!");
            } else {
                if (campos[6].contains("GB")) { // é um produto virtual

                    // retira o GB para implementação do atributo do produto
                    String[] parts = campos[6].split(" ");
                    campos[6] = parts[0];

                    ProdutoVirtual produtoVirtual = new ProdutoVirtual(Integer.parseInt(campos[0]), campos[1], Double.parseDouble(campos[2]), campos[3], campos[4], categoria, Double.parseDouble(campos[6]), campos[7]);

                    if (adicionarProduto(produtoVirtual))
                        System.out.println("Produto adicionado com sucesso!!");
                    else
                        System.out.println("Produto já existente!!!");

                } else { // é um produto físico

                    ProdutoFisico produtoFisico = new ProdutoFisico(Integer.parseInt(campos[0]), campos[1], Double.parseDouble(campos[2]), campos[3], campos[4], categoria, Double.parseDouble(campos[6]), campos[7]);

                    if (adicionarProduto(produtoFisico))
                        System.out.println("Produto adicionado com sucesso!!");
                    else
                        System.out.println("Produto já existente!!!");
                }
            }


        }
    }

    public void telaOpcoesUsuario () {
        System.out.println("\nDigite qual operação você deseja realizar:");
        System.out.println("\t(1) Buscar Produto\n\t(2) Adicionar Produto ao Carrinho\n\t(3) Visualizar Carrinho\n\t(4) Remover item do Carrinho\n\t(5) Realizar Compra\n\t(6) Listar Produtos\n\t(0) Sair");
        System.out.print("\nOPERAÇÃO: ");
    }

    public void telaOpcoesAdmin () {
        System.out.println("\nDigite qual operação você deseja realizar:");
        System.out.println("\t(1) Gerenciar Produtos\n\t(2) Gerenciar Categorias\n\t(3) Gerenciar Loja\n\t(4) Listar Produtos\n\t(0) Sair");
        System.out.print("\nOPERAÇÃO: ");
    }

    public void visualizarCarrinho () {
        carrinho.listarCarrinho();
    }

    public boolean adicionarProduto (ProdutoVirtual produtoVirtual) {
        return (loja.adicionarProduto(produtoVirtual));
    }

    public boolean adicionarProduto (ProdutoFisico produtoFisico) {
        return (loja.adicionarProduto(produtoFisico));
    }

    // métodos não utilizados
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

}


