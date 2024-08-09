package br.com.alura.models;

import com.google.gson.annotations.SerializedName;

public abstract class Title implements Comparable<Title> {
    @SerializedName("Title")
    private String name;

    @SerializedName("Year")
    private int releaseYear;

    private boolean includedOnPlan;
    private double sumOfRates;
    private int totalOfRates = 0;

    @SerializedName("Runtime")
    private String durationInMin;

    public Title(String name, int releaseYear, boolean includedOnPlan, double sumOfRates, int totalOfRates, String durationInMin) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.includedOnPlan = includedOnPlan;
        this.sumOfRates = sumOfRates;
        this.totalOfRates = totalOfRates;
        this.durationInMin = durationInMin;
    }

    public Title (OMBDbTitle ombDbTitle) {
        this.name = ombDbTitle.title();
        this.releaseYear = Integer.parseInt(ombDbTitle.year());
        this.durationInMin = ombDbTitle.runtime().substring(0, ombDbTitle.runtime().length() - 4); //-4 because it's to remove the " min" chars
    }

    public int getTotalOfRates() {
        return totalOfRates;
    }

    public String getDurationInMin() {
        return durationInMin;
    }


    /**
     * Display the principal infos about a title
     */
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Release year: " + releaseYear);
        System.out.println("Duration in min.: " + durationInMin);
    }

    /**
     * Add a new rate to the title
     * @param grade of the rate
     */
    public void rate (double grade) {
        sumOfRates += grade;
        totalOfRates += 1;
    }

    /**
     * Prints the average (if it exists)
     */
    public double average () {
        if (totalOfRates > 0) {
            //System.out.println("The average of " + name + " is " + sumOfRates / totalOfRates);
            return (sumOfRates/totalOfRates);
        } else {
            //System.out.println("There is no average of " + name);
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Title [name=" + name + ", releaseYear=" + releaseYear + ", includedOnPlan=" + (includedOnPlan ? "YES" : "NO") + "]";
    }

    @Override
    public int compareTo(Title o) {
        return (this.name.compareTo(o.name));
    }
}
