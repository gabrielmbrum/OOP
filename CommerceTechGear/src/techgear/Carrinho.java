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

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    // métodos
    public void removerProduto(Produto produto) {
       if (produtos.remove(produto))
           System.out.println("Produto removido com sucesso!");
       else
           System.out.println("ERRO! Produto não encontrado!");
    }

    public void listarCarrinho () {
        if (produtos == null) System.out.println("Carrinho Vazio!!!");
        else {
            for (Produto produto : produtos) {
                System.out.print("\t" + produto.getNome() + " | valor: R$");
                System.out.format("%.2f\n", produto.getPreco());
            }
        }
    }
}
