package models;

public abstract class Audio {
    private String title;
    private int duration;
    private int totalOfViews = 0;
    private int totalOfLikes = 0;
    private int classification;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTotalOfViews() {
        return totalOfViews;
    }

    public void setTotalOfViews(int totalOfViews) {
        this.totalOfViews = totalOfViews;
    }

    public int getTotalOfLikes() {
        return totalOfLikes;
    }

    public void setTotalOfLikes(int likes) {
        totalOfLikes = likes;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    void reproduce () {
        totalOfViews += 1;
    }

    void like () {
        totalOfLikes += 1;
    }
}
