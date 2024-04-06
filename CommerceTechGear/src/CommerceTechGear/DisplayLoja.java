package CommerceTechGear;

public class DisplayLoja extends Loja {
    // fields
    private Loja loja;

    // constructor
    public DisplayLoja () {
        this(new Loja());
    }
    public DisplayLoja (Loja loja) {
        this.loja = loja;
    }

    // getter and setter
    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    // required methods

    public void telaUsuario() {
        System.out.println("Tela Usuário");
    }
    void buscarProdutos() {};
    void adicionarAoCarrinho(Produto produto) {};
    void realizarCompra() {};
    void gerenciarCategorias() {};
    void gerenciarProdutos() {};
}
