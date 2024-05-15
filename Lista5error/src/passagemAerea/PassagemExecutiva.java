package passagemAerea;

public class PassagemExecutiva extends PassagemAbstrata{
    @Override
    public double calcularPrecoFinal() {
        return preco*1.5;
    }
}
