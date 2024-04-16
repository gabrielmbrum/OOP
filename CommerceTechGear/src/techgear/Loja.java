package techgear;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    // campos
    private String nome;
    private String cnpj;
    private String endereco;
    private List<Categoria> categorias;

    // construtores
    public Loja(String nome) {
        this(nome, "null", "null", new ArrayList<Categoria>());
    }
    public Loja(String nome, String cnpj, String endereco, List<Categoria> categorias) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.categorias = categorias;
    }

    // getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Categoria> getcategorias() {
        return categorias;
    }

    public void setcategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    // métodos
    public void adicionarCategoria(Categoria categoria) {
        if (buscarCategoria(categoria.getNome()) == null)
            categorias.add(categoria);
        else System.out.println("ERRO!! Categoria já existente!!");
    }

    public boolean adicionarProduto(Produto produto) {
        return produto.getCategoria().adicionarProduto(produto);
    }

    public Categoria buscarCategoria(int codigo) {
        // percorre o array de categorias até encontrar um nome igual, assim o retornando
        for (Categoria categoria : categorias) {
            if (categoria.getCodigo() == codigo)
                return categoria;
        }

        // no caso de não existir a categoria
        System.out.println("ERRO! CATEGORIA NÃO ENCONTRADA!");
        return null;
    }

    public Categoria buscarCategoria(String nome) {
        // percorre o array de categorias até encontrar um nome igual, assim o retornando
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equals(nome))
                return categoria;
        }

        // no caso de não existir a categoria
        return null;
    }

    public Produto buscarProduto(int id) {
        // busca dentro de cada categoria, passando por seu respectivo array de produtos, até encontrar o produto desejado e o remover
        for (Categoria categoria : categorias) {
            Produto produto = categoria.buscarProduto(id);
            if (produto != null) return produto;
        }

        // no caso de não existir a categoria, retorna nulo
        System.out.println("ERRO! PRODUTO NÃO ENCONTRADO!");
        return null;
    }

    public Produto buscarProduto (String nome) {
        // busca dentro de cada array de produtos dentro de cada posição do array de categorias, até encontrar o produto e o retorna
        Produto produto;

        for (Categoria categoria : categorias) {
            produto = categoria.buscarProduto(nome);
            if (produto != null) return produto;
        }

        // caso de não encontrar o produto
        System.out.println("ERRO! PRODUTO NÃO ENCONTRADO!!");
        return null;
    }

    public void removerProduto(int id) {
        // busca dentro de cada array de produtos dentro de cada posição do array de categorias, então o remove
        for (Categoria categoria : categorias) {
            for (Produto produto : categoria.getProdutos()) {
                if (produto.getId() == id) {
                    categoria.getProdutos().remove(produto);
                    return;
                }
            }
        }

        // caso não encontre o produto
        System.out.println("ERRO!! PRODUTO NÃO EXISTENTE!!");
    }

    public void removerCategoria(int id) {
        categorias.removeIf(categoria -> categoria.getCodigo() == id);
    }

    public void venderProdutos(List<Produto> carrinho) {
        for (Produto produto : carrinho) {
            vender(produto);
        }
    }

    public void vender(Produto produto) {
        // dar baixa no estoque
        for (Categoria categoria : categorias)
            if (categoria.getCodigo() == produto.getCategoria().getCodigo())
                categoria.vender(produto);
    }

    public void imprimirCategorias() {
        if (categorias.isEmpty()) {
            System.out.println("Não há categorias cadastradas!!");
            return;
        }
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getCodigo() + " " + categoria.getNome() + " " + categoria.getDescricao());
        }
    }

    public void imprimirProdutos() {
        if (categorias.isEmpty()) {
            System.out.println("Não existe produtos cadastrados!!");
            return;
        }
        System.out.println("Produtos da " + getNome());
        for (Categoria categoria : categorias) {
            System.out.println("\nCategoria " + categoria.getNome());
            categoria.imprimirProdutos();
        }
    }
}
