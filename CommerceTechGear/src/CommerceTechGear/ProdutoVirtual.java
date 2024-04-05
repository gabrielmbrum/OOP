package CommerceTechGear;

import CommerceTechGear.Categoria;
import CommerceTechGear.Produto;

public class ProdutoVirtual extends Produto {
    // fields
    private double tamanhoArquivo;
    private String formato;

    // constructor

    public ProdutoVirtual(int id, String nome, double preco, String descricao, String marca, Categoria categoria, double tamanhoArquivo, String formato) {
        super(id, nome, preco, descricao, marca, categoria, 0);
        this.tamanhoArquivo = tamanhoArquivo;
        this.formato = formato;
    }

    // getters and setters

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

    // required method
    public void realizarDownload() {
        // procedimento de instalação...

        System.out.println("\nproduto instalado!");
    }
}
