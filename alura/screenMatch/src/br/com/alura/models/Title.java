package br.com.alura.models;

public abstract class Title implements Comparable<Title> {
    private String name;
    private int releaseYear;
    private boolean includedOnPlan;
    private double sumOfRates;
    private int totalOfRates = 0;
    private int durationInMin;

    public Title(String name, int releaseYear, boolean includedOnPlan, double sumOfRates, int totalOfRates, int durationInMin) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.includedOnPlan = includedOnPlan;
        this.sumOfRates = sumOfRates;
        this.totalOfRates = totalOfRates;
        this.durationInMin = durationInMin;
    }

    public int getTotalOfRates() {
        return totalOfRates;
    }

    public int getDurationInMin() {
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
