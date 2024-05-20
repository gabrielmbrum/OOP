package TesteLojaJogos;

public class JogoTabuleiro {
    private String nome;
    private int anoDeLancamento;
    private int qtdEstoque;

    // constructors
    public JogoTabuleiro () {
        this("NULL", 0, 0);
    }
    public JogoTabuleiro(String nome, int anoDeLancamento, int qtdEstoque) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.qtdEstoque = qtdEstoque;
    }

    // getters and setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    // methods
    public void addEstoque (int qtd) {
        this.qtdEstoque += qtd;
    }

    public void remEstoque (int qtd) {
        if (this.qtdEstoque - qtd < 0)
            System.out.println("ERROR!!! Remoção bloqueada! Estoque ficaria negativo");
        else
            this.qtdEstoque -= qtd;
    }

    public boolean disponivel () {
        if (this.qtdEstoque > 0)
            return true;
        else
            return false;
    }
}
