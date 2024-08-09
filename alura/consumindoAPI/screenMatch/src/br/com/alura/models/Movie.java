package br.com.alura.models;

import br.com.alura.controllers.Classificable;

public class Movie extends Title implements Classificable {
    private String director;

    public Movie(String name, int releaseYear, boolean includedOnPlan, double sumOfRates, int totalOfRates, String durationInMin, String director) {
        super(name, releaseYear, includedOnPlan, sumOfRates, totalOfRates, durationInMin);
        this.director = director;
    }

    public Movie(OMBDbTitle ombDbTitle) {
        super(ombDbTitle);
        this.director = "NULL";
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassificacao() {
        return (int) average()/2;
    }
}
