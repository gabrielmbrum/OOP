package br.com.alura.models;

import br.com.alura.controllers.Classificable;

public class Episode implements Classificable {
    private int number;
    private String name;
    private Series series;
    private int totalOfViews;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public int getTotalOfViews() {
        return totalOfViews;
    }

    public void setTotalOfViews(int totalOfViews) {
        this.totalOfViews = totalOfViews;
    }

    @Override
    public int getClassificacao() {
        return (totalOfViews > 100 ? 4 : 2);
    }
}
