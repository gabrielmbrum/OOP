package br.com.alura.models;

public abstract class Title {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isIncludedOnPlan() {
        return includedOnPlan;
    }

    public void setIncludedOnPlan(boolean includedOnPlan) {
        this.includedOnPlan = includedOnPlan;
    }

    public double getSumOfRates() {
        return sumOfRates;
    }

    public void setSumOfRates(double sumOfRates) {
        this.sumOfRates = sumOfRates;
    }

    public int getTotalOfRates() {
        return totalOfRates;
    }

    public void setTotalOfRates(int totalOfRates) {
        this.totalOfRates = totalOfRates;
    }

    public int getDurationInMin() {
        return durationInMin;
    }

    public void setDurationInMin(int durationInMin) {
        this.durationInMin = durationInMin;
    }

    /**
     * Display the principal infos about a title
     */
    public void displayInfo() {
        System.out.println(name);
        System.out.println(releaseYear);
        System.out.println(durationInMin);
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
            System.out.println("The average of " + name + " is " + sumOfRates / totalOfRates);
            return (sumOfRates/totalOfRates);
        } else {
            System.out.println("There is no average of " + name);
            return 0;
        }
    }
}
