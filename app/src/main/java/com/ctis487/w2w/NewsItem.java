package com.ctis487.w2w;

public class NewsItem {

    private String title;
    private String description;
    private String datePublished;
    private String source;

    public NewsItem(String title, String description, String datePublished, String source) {
        this.title = title;
        this.description = description;
        this.datePublished = datePublished;
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public String getSource() {
        return source;
    }
}

