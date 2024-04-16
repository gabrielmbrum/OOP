package techgear;

public class ProdutoFisico extends Produto {
    // campos
    private double peso;
    private String dimensoes;

    // construtores
    public ProdutoFisico(int id, String nome, double preco, String descricao, String marca, Categoria categoria, double peso, String dimensoes) {
        this(id, nome, preco, descricao, marca, categoria, 0, peso, dimensoes);
    }

    public ProdutoFisico(int id, String nome, double preco, String descricao, String marca, Categoria categoria, int estoque, double peso, String dimensoes) {
        super(id, nome, preco, descricao, marca, categoria, estoque);
        this.peso = peso;
        this.dimensoes = dimensoes;
    }

    // getters and setters
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    // métodos
    public double calcularFrete () {
        // se é mais peso que 20kg usa a formula, caso contrario é o valor padrão de entrega
        if (peso > 20)
            return (peso*0.5);
        else
            return 10;
    }
}
