package com.ctis487.w2w;

public class Movie extends Content{
    String duration;
    String director;

    public Movie(String itemName, String companyName, String type, int imgID,int compID,int year, String duration, String director) {
        super(itemName, companyName, type, imgID,compID,year);
        this.duration=duration;
        this.director=director;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
}
