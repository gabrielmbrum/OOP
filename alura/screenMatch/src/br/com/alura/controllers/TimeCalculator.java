package br.com.alura.controllers;

import br.com.alura.models.Title;

public class TimeCalculator {
    private int totalTime = 0;

    public int getTotalTime() {
        return totalTime;
    }

    public void include (Title t) {
        totalTime += t.getDurationInMin();
    }
}
