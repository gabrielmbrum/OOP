package passagemAerea;

import java.time.LocalDateTime;

public abstract class PassagemAbstrata implements Passagem {
    String codigo = "abcd";
    double preco = 100;
    LocalDateTime dataHora;
    String origem = "x", destino = "y";

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(double newPreco) {
        preco = newPreco;
    }
    @Override
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    @Override
    public String getOrigem() {
        return origem;
    }
    @Override
    public String getDestino() {
        return destino;
    }

    abstract double calcularPrecoFinal();

    public void mostrarPassagem() {
        System.out.println("\nCódigo: " + codigo);
        System.out.println("Preço: " + preco);
        System.out.println("Origem : "  + origem + " | Destino: " + destino);
    }
}
