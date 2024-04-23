package passagemAerea;

import java.util.List;

public class SistemaReservas {
    // fields
    List<Passagem> passagens;
    //constructor
    public SistemaReservas(List<Passagem> passagens) {
        this.passagens = passagens;
    }

    // methods
    public void adicionarPassagem(Passagem passagem) {
        passagens.add(passagem);
        System.out.println("passagem adicionada com sucesso!!");
    }

    public void removerPassagem(String codigo) {
        passagens.removeIf(passagem -> (passagem.getCodigo().equals(codigo)));
        System.out.println("passagem removida com sucesso!!");
    }

    public void listarPassagens () {
        for (Passagem passagem : passagens) {
            ((PassagemAbstrata) passagem).mostrarPassagem();
        }
    }

    public Passagem buscarPassagem(String codigo) {
        for (Passagem passagem : passagens) {
            if (codigo.equals(((PassagemAbstrata) passagem).getCodigo()))
                return passagem;
        }

        System.out.println("passagem não encontrada!! :(");
        return null;
    }

    public double calcularPrecoFinal(String codigo) {
        Passagem passagem = buscarPassagem(codigo);
        if (passagem == null) return 0;

        PassagemAbstrata passagemAbstrata = (PassagemAbstrata) passagem;
        return passagemAbstrata.calcularPrecoFinal();
    }
}
