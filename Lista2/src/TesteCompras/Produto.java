package TesteCompras;

public class Produto {
    // fields
    private String nome;
    private double preço;
    private int quantidade;

    // constructor
    public Produto () {
        this("null", 0, 0);
    }
    public Produto(String nome, double preço, int quantidade) {
        this.nome = nome;
        this.preço = preço;
        this.quantidade = quantidade;
    }

    // getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // methods
    public void addQuantidade (int quantidade) {
        this.quantidade += quantidade;
    }

    public void remQuantidade (int quantidade) {
        this.quantidade = (this.quantidade - quantidade < 0) ? 0 : (this.quantidade - quantidade);
    }

    public double valorEstoque () {
        return quantidade*preço;
    }

    public void print () {
        System.out.println("\nNome produto: " + nome);
        System.out.println("Preço: " + preço);
        System.out.println("Estoque: " + quantidade);
    }
}
