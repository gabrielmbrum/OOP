package passagemAerea;

import java.time.LocalDateTime;

public class PassagemEconomica extends PassagemAbstrata{
    @Override
    public double calcularPrecoFinal() {
        return preco;
    }
}
