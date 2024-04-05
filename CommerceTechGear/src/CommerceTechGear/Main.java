package CommerceTechGear;

import java.io.File; // import of File class
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // fields
        Scanner sc = null;
        File arquivo = new File("/home/brum/Documents/categoria.txt");
        Loja loja = new Loja("LojaTeste");

        // conferindo se o arquivo foi aberto corretamente
        try {
            sc = new Scanner(arquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        // lendo e criando as categorias
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] campos = linha.split("#");

            loja.adicionarCategoria(new Categoria(Integer.parseInt(campos[0]), campos[1], campos[2]));
        }

        System.out.println("\nIMPRINDO CATEGORIAS\n");

        loja.imprimirCategorias();

        System.out.println("\n==========||==============||============");

        arquivo = new File("/home/brum/Documents/produtoFisico.txt");

        // conferindo se o arquivo foi aberto corretamente
        try {
            sc = new Scanner(arquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //lendo e criando produtos físicos
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] campos = linha.split("#");

            Categoria categoria = new Categoria();
            categoria = loja.buscarCategoria(Integer.parseInt(campos[5]));

            //System.out.println("teste: " + categoria.getNome());

            ProdutoFisico produtoFisico = new ProdutoFisico(Integer.parseInt(campos[0]), campos[1], Double.parseDouble(campos[2]), campos[3], campos[4], categoria, Double.parseDouble(campos[6]), campos[7]);

            loja.adicionarProduto(produtoFisico);
        }

        arquivo = new File("/home/brum/Documents/produtoVirtual.txt");

        // conferindo se o arquivo foi aberto corretamente
        try {
            sc = new Scanner(arquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //lendo e criando produtos virtuais
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] campos = linha.split("#");

            String[] parts = campos[6].split(" ");
            campos[6] = parts[0];

            Categoria categoria = new Categoria();
            categoria = loja.buscarCategoria(Integer.parseInt(campos[5]));

            ProdutoVirtual produtoVirtual = new ProdutoVirtual(Integer.parseInt(campos[0]), campos[1], Double.parseDouble(campos[2]), campos[3], campos[4], categoria, Double.parseDouble(campos[6]), campos[7]);

            loja.adicionarProduto(produtoVirtual);
        }
        System.out.println("\nIMPRINDO PRODUTOS\n");

        loja.imprimirProdutos();

        System.out.println("\n==========||==============||============");
    }
}