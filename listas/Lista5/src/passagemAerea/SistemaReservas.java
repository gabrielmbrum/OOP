package passagemAerea;

import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {
    // fields
    List<Passagem> passagens;
    //constructor
    public SistemaReservas (List<Passagem> passagens) {
        this.passagens = passagens;
    }

    // methods
    public void adicionarPassagem (Passagem passagem) {
        passagens.add(passagem);
        System.out.println("passagem adicionada com sucesso!!");
    }

    public void removerPassagem (String codigo) {
        int size = passagens.size();
        passagens.removeIf(passagem -> (passagem.getCodigo().equals(codigo)));
        if (passagens.size() != size)
            System.out.println("passagem removida com sucesso!!");
        else
            System.out.println("ERROR! passagem não encontrada!!!");
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

        System.out.println("ERROR! passagem não encontrada!! :(");
        return null;
    }

    public double calcularPrecoFinal(String codigo) throws PassagemInexistenteException {
        Passagem passagem = buscarPassagem(codigo);
        if (passagem == null) throw new PassagemInexistenteException("NÃO EXISTE PASSAGEM COM O CÓDIGO APRESENTADO");

        PassagemAbstrata passagemAbstrata = (PassagemAbstrata) passagem;
        return passagemAbstrata.calcularPrecoFinal();
    }
}
