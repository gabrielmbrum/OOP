package CommerceTechGear;

import CommerceTechGear.Categoria;
import CommerceTechGear.DisplayLoja;

import java.util.ArrayList;
import java.util.List;

public class Loja{
    // fields
    private String nome;
    private String cnpj;
    private String endereco;
    private List<Categoria> categorias;

    // constructor
    public Loja(String nome) {
        this(nome, "null", "null", new ArrayList<>());
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

    // required methods

    public void adicionarCategoria(Categoria categoria) {
        categorias.add(categoria);
    };

    public void adicionarProduto(Produto produto) {
        // verifica se o produto ja existe
        for (Categoria categoria : categorias) {
            if (categoria.produtoJaExiste(produto)) {
                System.out.println("Produto já existente!");
                return;
            }
        }

        // procura por meio da comparação do id da categoria do produto e adiciona na categoria correta
        for (Categoria categoria : categorias) {
            if (produto.getCategoria().getCodigo() == categoria.getCodigo()) {
                categoria.adicionarProduto(produto);
                return;
            }
        }

        System.out.println("Produto possue categoria inválida!!");
    };

    public Categoria buscarCategoria(String nome) {
        // percorre o array de categorias até encontrar um nome igual, assim o retornando
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equals(nome))
                return categoria;
        }

        // no caso de não existir a categoria
        System.out.println("ERRO! CATEGORIA NÃO ENCONTRADA!");
        return null;
    };

    public Produto buscarProduto(int id) {
        // busca dentro de cada categoria, passando por seu respectivo array de produtos, até encontrar o produto desejado e o remover
        for (Categoria categoria : categorias) {
            for (Produto produto : categoria.getProdutos()) {
                if (produto.getId() == id) {
                    return produto;
                }
            }
        }

        // no caso de não existir a categoria
        System.out.println("ERRO! PRODUTO NÃO ENCONTRADO!");
        return null;
    };

    public Produto buscarProduto (String nome) {
        // busca dentro de cada array de produtos dentro de cada posição do array de categorias, até encontrar o produto e o retorna
        for (Categoria categoria : categorias) {
            for (Produto produto : categoria.getProdutos()) {
                if (produto.getNome().equals(nome)) {
                    return produto;
                }
            }
        }

        // caso de não encontrar o produto
        System.out.println("ERRO! PRODUTO NÃO ENCONTRADO!!");
        return null;
    };

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
    };

    // extra methods
    public void imprimirCategorias() {
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getCodigo() + " " + categoria.getNome() + " " + categoria.getDescricao());
        }
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
    };

    public void imprimirProdutos() {
        for (Categoria categoria : categorias) {
            System.out.println("Categoria: " + categoria.getCodigo());
            for (Produto produto : categoria.getProdutos()) {
                System.out.println("\t" + produto.getId() + " " + produto.getNome());
            }
        }
    }
}
