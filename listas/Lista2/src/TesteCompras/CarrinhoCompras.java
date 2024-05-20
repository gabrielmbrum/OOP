package TesteCompras;

public class CarrinhoCompras {
    // fields
    private Produto[] produtos;
    private int[] qtdPorProduto;
    private int index;


    // constructor
    public CarrinhoCompras (int MAX) {
        produtos = new Produto[MAX];
        qtdPorProduto = new int[MAX];
        index = 0;
    }

    // methods
    public void addProduto (Produto p, int qtd) {
        produtos[index] = p;
        qtdPorProduto[index++] = qtd;
    }

    public void rmProduto (Produto p) {
        String name = p.getNome();
        for (int i = 0; i < index; i++) {
            if (name.equals(produtos[i].getNome())) {
                produtos[i] = null;

                // adjust the array
                for (; i<index-1; i++) {
                    produtos[i] = produtos[i+1];
                    qtdPorProduto[i] = qtdPorProduto[i+1];
                }
                index--; //update the index
                return;
            }
        }

        System.out.println("Produto não encontrado!!!");
    }

    public double valorCarrinho () {
        double total = 0;
        for (int i = 0; i<index; i++)
            total += produtos[i].getPreço() * qtdPorProduto[i];

        return total;
    }

    public void finalizarCompra () {
        for (int i = 0; i<index; i++) {
            produtos[i].setQuantidade(produtos[i].getQuantidade() - qtdPorProduto[i]);
        }
    }

    public void print () {
        for (int i = 0; i<index; i++) {
            System.out.println("\nProduto: " + i);
            System.out.println("\tNome: " + produtos[i].getNome());
            System.out.println("\tPreço: " + produtos[i].getPreço());
            System.out.println("\tQtd Carrinho: " + qtdPorProduto[i]);
            System.out.println("\n==============||================");
        }
    }

}
