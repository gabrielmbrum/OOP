package passagemAerea;

import java.time.LocalDateTime;

public class PassagemEconomica extends PassagemAbstrata{

    public PassagemEconomica (String codigo, String origem , String destino, double preco, LocalDateTime time) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.preco = preco;
        this.dataHora = time;
    }
    @Override
    public double calcularPrecoFinal() {
        return preco;
    }
}
