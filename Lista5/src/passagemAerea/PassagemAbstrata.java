package passagemAerea;

import java.time.LocalDateTime;

public abstract class PassagemAbstrata implements Passagem {
    String codigo = "teste";
    double preco = 100;
    LocalDateTime dataHora = LocalDateTime.of(2012, 6, 30, 12, 0);
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
        System.out.println("Código: " + codigo);
        System.out.println("Preço: " + preco);
        System.out.println("Origem : "  + origem + " | Destino: " + destino);
    }
}
