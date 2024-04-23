package passagemAerea;

import java.time.LocalDateTime;

public abstract class PassagemAbstrata implements Passagem {
    String codigo;
    double preco;
    LocalDateTime dataHora;
    String origem, destino;

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public double getPreco() {
        return preco;
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
        System.out.println("Código: " + codigo);
        System.out.println("Preço: " + preco);
        System.out.println("Origem : "  + origem + " | Destino: " + destino);
    }
}
