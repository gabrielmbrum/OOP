package techgear;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    // campos
    private List<Produto> produtos;

    // construtores
    public Carrinho () {
        this(new ArrayList<>());
    }
    public Carrinho (List<Produto> produtos) {
        this.produtos = produtos;
    }

    // getters and setters
    public List<Produto> getProdutos() {
        return produtos;
    }

    // métodos
    public void removerProduto(Produto produto) {
       if (produtos.remove(produto))
           System.out.println("\nProduto removido do carrinho com sucesso!");
    }

    public void listarCarrinho () {
        if (produtos.isEmpty()) System.out.println("\nCarrinho Vazio!!!");
        else {
            System.out.println("\nCarrinho: ");
            for (Produto produto : produtos) {
                System.out.print("\t" + produto.getNome() + " | qtd.: " + produto.getQuantidade() + "x | valor: R$");
                System.out.format("%.2f\n", produto.getPreco());
            }
        }
    }

    public int quantidadeExistente(int id) {
        for (Produto produto : produtos)
            if (produto.getId() == id)
                return produto.getQuantidade();
        return 0;
    }
    public void aumentarQuantidade (int id, int qtd) {
        for (Produto produto : produtos)
            if (produto.getId() == id)
                produto.setQuantidade(produto.getQuantidade() + qtd);
    }

    public boolean contem (int id) {
        for (Produto produto : produtos)
            if (produto.getId() == id)
                return true;

        return false;
    }

    public double valor () {
        double val = 0;
        for (Produto produto : produtos)
            val += produto.getPreco() * produto.getQuantidade();
        return val;
    }
}
