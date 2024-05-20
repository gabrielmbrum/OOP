package TesteLojaJogos;

public class LojaJogos {
    private static final int max = 100;
    private JogoTabuleiro[] Jogos;
    private String nome;
    private int index;

    //constructors
    public LojaJogos() {
        this("NULL");
    }

    public LojaJogos(String nome) {
        this.nome = nome;
        this.Jogos = new JogoTabuleiro[max];
        this.index = 0;
    }

    public LojaJogos(JogoTabuleiro[] jogos, String nome) {
        if (jogos.length > max)
            System.out.println("ERRO! Estoque de jogos maior do que o permitido");
        else {
            Jogos = jogos;
            this.nome = nome;
            index = 0;
        }
    }

    // getters and setters
    public static int getMax() {
        return max;
    }

    public JogoTabuleiro[] getJogos() {
        return Jogos;
    }

    public void setJogos(JogoTabuleiro[] jogos) {
        Jogos = jogos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    // methods
    public void addJogo (JogoTabuleiro jogo) {
        Jogos[index] = jogo;
        Jogos[index++].setQtdEstoque(0);
    }

    public void addJogo (JogoTabuleiro jogo, int qtd) {
        Jogos[index] = jogo;
        Jogos[index++].setQtdEstoque(qtd);
    }

    public boolean buscaJogo (JogoTabuleiro jogo) {
        for (int i = 0; Jogos[i] != null; i++) {
            if (Jogos[i].getNome().equals(jogo.getNome()))
                return true;
        }
        return false;
    }

    public boolean buscaJogo (String nome) {
        for (int i = 0; Jogos[i] != null; i++) {
            if (Jogos[i].getNome().equals(nome))
                return true;
        }
        return false;
    }

    public void listarJogos () {
        for (int i = 0; Jogos[i] != null; i++) {
            System.out.println("\nJogo: " + Jogos[i].getNome());
            System.out.println("===========||============");
        }
    }

}
