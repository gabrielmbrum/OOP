package br.com.alura.models;

import br.com.alura.controllers.Classificable;

public class Series extends Title implements Classificable {
    private int seasons;
    private int episodesBySeason;
    private boolean active;
    private int minPerEpisode;

    public Series(String name, int releaseYear, boolean includedOnPlan, double sumOfRates, int totalOfRates, String durationInMin, int seasons, int episodesBySeason, boolean active, int minPerEpisode) {
        super(name, releaseYear, includedOnPlan, sumOfRates, totalOfRates, durationInMin);
        this.seasons = seasons;
        this.episodesBySeason = episodesBySeason;
        this.active = active;
        this.minPerEpisode = minPerEpisode;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodesBySeason() {
        return episodesBySeason;
    }

    public void setEpisodesBySeason(int episodesBySeason) {
        this.episodesBySeason = episodesBySeason;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getMinPerEpisode() {
        return minPerEpisode;
    }

    public void setMinPerEpisode(int minPerEpisode) {
        this.minPerEpisode = minPerEpisode;
    }

    @Override
    public String getDurationInMin () {
        return String.valueOf(seasons * episodesBySeason * minPerEpisode);
    }

    @Override
    public int getClassificacao() {
        return (int) average()/2;
    }
}
