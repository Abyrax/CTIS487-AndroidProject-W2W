package com.ctis487.w2w;

public class Serie extends Content{
    int season;
    int episode;

    public Serie(String itemName, String companyName, String type, int imgID,int compID,int year,int season,int episode) {
        super(itemName, companyName, type, imgID,compID,year);
        this.season=season;
        this.episode=episode;
    }

    public int getEpisode() {
        return episode;
    }
    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public int getSeason() {
        return season;
    }
    public void setSeason(int season) {
        this.season = season;
    }
}
