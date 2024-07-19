import br.com.alura.controllers.RecomentadionFilter;
import br.com.alura.controllers.TimeCalculator;
import br.com.alura.models.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie meuFilme = new Movie();
        meuFilme.setName("O poderoso chefão");
        meuFilme.setReleaseYear(1970);
        meuFilme.setDurationInMin(180);
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

        Series lost = new Series();
        lost.setName("Lost");
        lost.setReleaseYear(2000);
        lost.displayInfo();
        lost.setSeasons(10);
        lost.setEpisodesBySeason(10);
        lost.setMinPerEpisode(50);
        System.out.println("Duração para maratonar Lost: " + lost.getDurationInMin());

        Movie outroFilme = new Movie();
        outroFilme.setName("Avatar");
        outroFilme.setReleaseYear(2023);
        outroFilme.setDurationInMin(200);

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

        var filmeDoPaulo = new Movie("Dogville", 2003, true, 0, 0, 200, "Paulo");
        filmeDoPaulo.rate(10);

        ArrayList<Movie> listaDeFilme = new ArrayList<>();
        listaDeFilme.add(filmeDoPaulo);
        listaDeFilme.add(meuFilme);
        listaDeFilme.add(outroFilme);
        System.out.println("Tamanho da lista: " + listaDeFilme.size());
        System.out.println("Primeiro filme: " + listaDeFilme.get(0).getName());

    }
}