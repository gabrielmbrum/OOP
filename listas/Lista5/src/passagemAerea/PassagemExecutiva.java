package passagemAerea;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PassagemExecutiva extends PassagemAbstrata{
    public PassagemExecutiva (String codigo, String origem , String destino, double preco, LocalDateTime time) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.preco = preco;
        this.dataHora = time;
    }
    @Override
    public double calcularPrecoFinal() {
        return preco*1.5;
    }
}
