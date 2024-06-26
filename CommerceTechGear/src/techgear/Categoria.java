package techgear;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    // campos
    private int codigo;
    private String nome;
    private String descricao;
    private List<Produto> produtos;

    // construtores
    public Categoria () {
        this(0, "null", "null", new ArrayList<>());
    }

    public Categoria (int codigo, String nome, String descricao) {
        this(codigo, nome, descricao, new ArrayList<Produto>());
    }

    public Categoria(int codigo, String nome, String descricao, List<Produto> produtos) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.produtos = produtos;
    }

    // getters and setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    // métodos
    public boolean adicionarProduto (Produto produto) {
        if (produtoJaExiste(produto)) {
            System.out.println("Produto já existente!");
            return false;
        }
        produtos.add(produto);
        return true;
    }

    public void removerProduto (int id, boolean admin) {
        // percorre a array de produtos e quando encontra o id correspondente, remove o produto e encerra
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                if (admin) System.out.println("Produto removido com sucesso!");
                return;
            }
        }

        // caso o produto já exista
        System.out.println("ERRO!! PRODUTO NÃO EXISTENTE!!");
    }

    public Produto buscarProduto (int id) {
        // percorre o array buscando correspondencia pelo id, entao o retorna
        for (Produto produto : produtos) {
            if (produto.getId() == id)
                return produto;
        }

        // produto não existe
        return null;
    }

    public Produto buscarProduto (String nome) {
        // percorre o array buscando correspondencia pelo id, entao o retorna
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome))
                return produto;
        }

        // produto não existe
        return null;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public boolean produtoJaExiste(Produto produto) {
        // loop para checar todos os produtos do array e retornar true caso o produto com aquele id ja existir
        for (Produto value : produtos) {
            if (produto.getId() == value.getId())
                return true;
        }
        return false;
    }

    public void vender (Produto produto) {
        /*
        essa função faz a 'venda' dos produtos e realiza a atualização do estoque dos produtos,
        se acaso todas as unidades de determinado produto foram compradas, ele adiciona o id ao array 'ids'
        esse que guardará todos os produtos que estão zerados e os removerá do estoque da loja
         */
        List<Integer> ids = new ArrayList<Integer>();

        for (Produto prod : produtos) {
            if (prod.getId() == produto.getId()) {
                prod.atualizarEstoque(prod.getQuantidade() - produto.getQuantidade());
                if (prod.getQuantidade() == 0) ids.add(prod.getId());
                if (prod instanceof ProdutoVirtual)
                    ((ProdutoVirtual) prod).realizarDownload();
            }
        }

        for (Integer aux : ids) // remove os elementos zerados
            removerProduto(aux, false);
    }
}
