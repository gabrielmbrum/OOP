package CommerceTechGear;

public class DisplayLoja {
    // fields
    private Loja loja;

    // constructor
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
    void adicionarAoCarrinho() {};
    void realizarCompra() {};
    void gerenciarCategorias() {};
    void gerenciarProdutos() {};
}
