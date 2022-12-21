package com.ctis487.w2w;

public class Content {
    private String itemName;
    private String companyName;
    private int imgID;
    private String type;
    private int year;
    private int compID;

    public Content(String itemName, String companyName, String type, int imgID,int compID, int year) {
        this.itemName=itemName;
        this.companyName=companyName;
        this.type=type;
        this.imgID=imgID;
        this.compID=compID;
        this.year=year;
    }

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getImgID() {
        return imgID;
    }
    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public int getCompID() {return compID;}
    public void setCompID(int compID) {this.compID = compID;}

    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}
}

