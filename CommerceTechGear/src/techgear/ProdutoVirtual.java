package techgear;

public class ProdutoVirtual extends Produto {
    // campos
    private double tamanhoArquivo;
    private String formato;

    // construtores
    public ProdutoVirtual(int id, String nome, double preco, String descricao, String marca, Categoria categoria, double tamanhoArquivo, String formato) {
        super(id, nome, preco, descricao, marca, categoria, 10);
        this.tamanhoArquivo = tamanhoArquivo;
        this.formato = formato;
    }

    public ProdutoVirtual(int id, String nome, double preco, String descricao, String marca, Categoria categoria, int quantidade, double tamanhoArquivo, String formato) {
        super(id, nome, preco, descricao, marca, categoria, quantidade);
        this.tamanhoArquivo = tamanhoArquivo;
        this.formato = formato;
    }

    // métodos
    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void realizarDownload() {
        System.out.println("\nArquivo '" + getNome() + "' Instalado!!\nFormato: " + getFormato() + " | Tamanho: " + getTamanhoArquivo() + " GB");
    }
}
