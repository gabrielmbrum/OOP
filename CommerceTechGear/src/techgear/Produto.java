package techgear;

public abstract class Produto {
    // fields
    private int id;
    private String nome;
    private double preco;
    private String descricao;
    private String marca;
    private Categoria categoria;
    private int quantidade;

    // constructor
    public Produto () {
        this(0, "null", 0, "null", "null", new Categoria(), 0);
    }

    public Produto(int id, String nome, double preco, String descricao, String marca, Categoria categoria, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        atualizaPreco(preco);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // required methods

    public void atualizarEstoque (int quantidade) {
        setQuantidade(quantidade);
    }

    public void atualizaPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    // extra methods
}
