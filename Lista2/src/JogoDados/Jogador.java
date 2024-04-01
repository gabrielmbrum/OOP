package JogoDados;

public class Jogador {
    private String nome;
    private int pontuacao;
    private Dados dado;

    // constructors
    public Jogador () {
        Dados dado = new Dados();
        setDado(dado);
        this.nome = "NULL";
        this.pontuacao = 0;
    }

    public Jogador (String nome) {
        Dados dado = new Dados();
        setDado(dado);
        this.nome = nome;
        this.pontuacao = 0;
    }
    public Jogador(String nome, int pontuacao, Dados dado) {
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.dado = dado;
    }

    // getters and setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Dados getDado() {
        return dado;
    }

    public void setDado(Dados dado) {
        this.dado = dado;
    }

    // methods
    public void addPoint () {
        this.pontuacao++;
    }
}
