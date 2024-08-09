import br.com.alura.controllers.RecomentadionFilter;
import br.com.alura.controllers.TimeCalculator;
import br.com.alura.models.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Movie meuFilme = new Movie("O poderoso chefão", 1970, true, 0, 0,"180", "Chefão");
        System.out.println("Duração do filme: " + meuFilme.getDurationInMin());

        meuFilme.displayInfo();
        meuFilme.rate(8);
        meuFilme.rate(5);
        meuFilme.rate(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalOfRates());
        System.out.println(meuFilme.average());
        //meuFilme.somaDasAvaliacoes = 10;
        //meuFilme.totalDeAvaliacoes = 1;
        //System.out.println(meuFilme.pegaMedia());

        Series lost = new Series("Lost", 2000, true, 0, 0, "0", 10, 10, true, 50);
        System.out.println("Duração para maratonar Lost: " + lost.getDurationInMin());

        Movie outroFilme = new Movie("Avatar", 2023, true, 0, 0, "200", "Avatão");

        TimeCalculator calculadora = new TimeCalculator();
        calculadora.include(meuFilme);
        calculadora.include(outroFilme);
        calculadora.include(lost);
        System.out.println(calculadora.getTotalTime());

        RecomentadionFilter filtro = new RecomentadionFilter();
        filtro.filter(meuFilme);

        Episode episodio = new Episode();
        episodio.setNumber(1);
        episodio.setSeries(lost);
        episodio.setTotalOfViews(300);
        filtro.filter(episodio);

        var filmeDoPaulo = new Movie("Dogville", 2003, true, 0, 0, "200", "Paulo");
        filmeDoPaulo.rate(10);

        ArrayList<Movie> listaDeFilme = new ArrayList<>();
        listaDeFilme.add(filmeDoPaulo);
        listaDeFilme.add(meuFilme);
        listaDeFilme.add(outroFilme);
        System.out.println("Tamanho da lista: " + listaDeFilme.size());
        System.out.println("Primeiro filme:\n" + listaDeFilme.get(0).toString() + "\n");

        ArrayList<Title> titulosAssistidos = new ArrayList<>();
        titulosAssistidos.add(filmeDoPaulo);
        titulosAssistidos.add(lost);
        System.out.println("Filmes assistidos:");
        titulosAssistidos.forEach(titulo -> System.out.println(titulo.toString()));

        System.out.println("\nFilmes assistidos c/  classificacao:");
        for (Title tituloAssistido : titulosAssistidos) {
            System.out.println("\t" + tituloAssistido.toString());
            if (tituloAssistido instanceof Movie m) {
                System.out.println("\t-> classificação " + m.getClassificacao());
            }
        }

        Collections.sort(titulosAssistidos);

        System.out.println("\nFilmes assistidos c/  ordenação:");
        titulosAssistidos.forEach(titulo -> System.out.println(titulo.toString()));
    }
}