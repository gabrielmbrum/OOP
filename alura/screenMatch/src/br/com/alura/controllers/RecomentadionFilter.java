package br.com.alura.controllers;

public class RecomentadionFilter {
    private String recomendation;

    public void filter (Classificable classificable) {
        if (classificable.getClassificacao() >= 4) {
            System.out.println("Está entre os favoritos do momento");
        } else if (classificable.getClassificacao() >= 2) {
            System.out.println("Está muito bem classificado");
        } else {
            System.out.println("Coloque na sua lista para assistir mais tarde");
        }
    }
}
