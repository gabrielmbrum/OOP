package CommerceTechGear;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    // campos
    private List<Produto> produtos;

    // construtores
    public Carrinho () {
        this(new ArrayList<>());
    }
    public Carrinho (List<Produto> produtos) {
        this.produtos = produtos;
    }

    // getters and setters
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    // métodos
}
