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
            System.out.println("\nQual tela deseja utilizar?");
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

            if (count > 0) System.err.println("\n\t!!! usuário e/ou senha inválido(os) !!!\n");

            System.out.print("Digite seu usuario: ");
            usuario = Main.sc.nextLine();

            System.out.print("Digite sua senha: ");
            senha = Main.sc.nextLine();

            count++;

        } while( ( !(admin.getSenha().equals(senha)) || !(admin.getUsuario().equals(usuario)) ) && count < 5);

        if (count == 5) {
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
        while (op != 0) {
            switch (op) {
                case 1: gerenciarProdutos(); break;
                case 2: gerenciarCategorias(); break;
                case 3: gerenciarLoja(); break;
            }
            telaOpcoesAdmin();
            op = Main.sc.nextInt();
            Main.sc.nextLine();
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

    void gerenciarCategorias() {
        int id, op = 1;

        while (op!=0) {
            System.out.println("\nO que deseja fazer?\n\t(1) Adicionar Categoria (via Arquivo)\n\t(2) Adicionar Categoria (manualmente)\n\t(3) Remover Categoria\n\t(4) Listar Categorias\n\t(0) Voltar\n");
            System.out.print("OPERAÇÃO: ");
            op = Main.sc.nextInt();
            Main.sc.nextLine();

            switch (op) {
                case 0: break;
                case 1: adicionarCategoriaPorArquivo(); break;
                case 2: adicionarCategoriaManualmente(); break;
                case 3: System.out.print("Digite o ID: "); id = Main.sc.nextInt(); Main.sc.nextLine(); removerCategoria(id); break;
                case 4: imprimirCategorias(); break;
            }
        }
    }

    void gerenciarProdutos() {
        int id, op = 1;

        while (op!=0) {
            System.out.println("\nO que deseja fazer?\n\t(1) Adicionar Produto (via Arquivo)\n\t(2) Adicionar Produto (manualmente)\n\t(3) Remover Produto\n\t(4) Listar Produtos\n\t(0) Voltar\n");
            System.out.print("OPERAÇÃO: ");
            op = Main.sc.nextInt();
            Main.sc.nextLine();

            switch (op) {
                case 0: break;
                case 1: adicionarProdutoPorArquivo(); break;
                case 2: adicionarProdutoManualmente(); break;
                case 3:
                    System.out.print("Digite o ID: ");
                    id = Main.sc.nextInt();
                    Main.sc.nextLine();
                    removerProduto(id);
                    break;
                case 4: imprimirProdutos(); break;
            }
        }
    }

    void gerenciarLoja() {
        String aux; int op = 1;

        while (op!=0) {
            System.out.println("\nO que deseja fazer?\n\t(1) Alterar Nome\n\t(2) Alterar CNPJ\n\t(3) Alterar Endereço\n\t(4) Visualizar atributos da loja\n\t(0) Voltar\n");
            System.out.print("OPERAÇÃO: ");
            op = Main.sc.nextInt();
            Main.sc.nextLine();

            switch (op) {
                case 0: break;
                case 1: System.out.print("Digite o novo nome: "); aux = Main.sc.nextLine(); loja.setNome(aux); break;
                case 2: System.out.print("Digite o novo CNPJ: "); aux = Main.sc.nextLine(); loja.setCnpj(aux); break;
                case 3: System.out.print("Digite o novo endereço: "); aux = Main.sc.nextLine(); loja.setEndereco(aux); break;
                case 4: System.out.println("\n\tNome: " + loja.getNome() + "\n\tCNPJ: " + loja.getCnpj() + "\n\tEndereço: " + loja.getEndereco());
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
        System.out.println("\t(1) Gerenciar Produtos\n\t(2) Gerenciar Categorias\n\t(3) Gerenciar Loja\n\t(0) Sair");
        System.out.print("\nOPERAÇÃO: ");
    }

    private void adicionarCategoriaPorArquivo () {
        Scanner scanner;
        String path, linha;
        String [] campos;

        //System.out.print("Digite o caminho para o arquivo: ");
        //path = Main.sc.nextLine();

        File arquivo = new File("/home/brum/Documents/categoria.txt");

        try {
            scanner = new Scanner(arquivo);
        } catch (FileNotFoundException e) {
            Logger.getLogger(DisplayLoja.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("ERRO AO ABRIR ARQUIVO!!!");
            return;
        }

        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            campos = linha.split("#");

            adicionarCategoria( new Categoria(Integer.parseInt(campos[0]), campos[1], campos[2]) );
        }
    }

    private void adicionarCategoriaManualmente () {
        // campos
        int codigo;
        String nome, descricao;

        System.out.print("Codigo: ");
        codigo = Main.sc.nextInt();
        Main.sc.nextLine();

        System.out.print("Nome: ");
        nome = Main.sc.nextLine();

        System.out.print("Descrição: ");
        descricao = Main.sc.nextLine();

        adicionarCategoria(new Categoria(codigo, nome, descricao));
    }

    private void adicionarProdutoManualmente() {
        // campos
        char op;
        int id, quantidade, aux;
        double preco, coringa1; // coringa1 funciona para o peso em produtos físicos e para o tamanho em arquivos digitais
        String nome, descricao, marca, coringa2; //coring2 funciona para dimensoes e para formato
        Categoria categoria;
        boolean sucesso;

        System.out.print("ID: ");
        id = Main.sc.nextInt();
        Main.sc.nextLine();

        System.out.print("Nome: ");
        nome = Main.sc.nextLine();

        System.out.print("Preço: ");
        preco = Main.sc.nextDouble();
        Main.sc.nextLine();

        System.out.print("Descrição: ");
        descricao = Main.sc.nextLine();

        System.out.print("Marca: ");
        marca = Main.sc.nextLine();

        System.out.print("Categoria (ID): ");
        aux = Main.sc.nextInt();
        Main.sc.nextLine();
        categoria = buscarCategoria(aux);
        if (categoria == null) return;

        System.out.print("Quantidade: ");
        quantidade = Main.sc.nextInt();
        Main.sc.nextLine();

        do {
            System.out.println("Produto Físico ou Virtual? <F/V>");
            System.out.print("R: ");
            op = Main.sc.next().charAt(0);
        } while (op != 'F' && op != 'V');

        if (op == 'F') {

            System.out.print("Peso: ");
            coringa1 = Main.sc.nextDouble();
            Main.sc.nextLine();

            System.out.print("Dimensoes: ");
            coringa2 = Main.sc.nextLine();

            sucesso = adicionarProduto(new ProdutoFisico(id, nome, preco, descricao, marca, categoria, coringa1, coringa2));
        } else {

            System.out.print("Tamanho do arquivo (em GB): ");
            coringa1 = Main.sc.nextDouble();
                Main.sc.nextLine();

            System.out.print("Formato: ");
            coringa2 = Main.sc.nextLine();

            sucesso = adicionarProduto(new ProdutoVirtual(id, nome, preco, descricao, marca, categoria, coringa1, coringa2));
        }

        if (sucesso)
            System.out.println("Produto adicionado com sucesso!!");
        else
            System.out.println("ERRO AO ADICIONAR PRODUTO!!!");
    }

    private void adicionarProdutoPorArquivo() {
        File arquivo;
        Scanner scanner;
        String path, linha;
        String[] campos;
        boolean sucesso;

        System.out.print("\nDigite o caminho para o arquivo: ");
        path = Main.sc.nextLine();

        arquivo = new File(path);

        // confere se o arquivo foi aberto corretamente e consegue fazer uma leitura nele
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

                    sucesso = adicionarProduto(produtoVirtual);

                } else { // é um produto físico

                    ProdutoFisico produtoFisico = new ProdutoFisico(Integer.parseInt(campos[0]), campos[1], Double.parseDouble(campos[2]), campos[3], campos[4], categoria, Double.parseDouble(campos[6]), campos[7]);

                    sucesso = adicionarProduto(produtoFisico);
                }
                if (!sucesso) System.out.println("ERRO AO ADICIONAR PRODUTO DE ID: " + campos[0]);
            }

            System.out.println("\tProdutos adicionados com sucesso!!!");
        }
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


