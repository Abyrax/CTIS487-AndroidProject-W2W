package com.ctis487.w2w;

import java.util.ArrayList;
import java.util.Collections;

public class ContentSys {
    private static ArrayList<Content> contentArrayList;

    public static void prepareData(){
        contentArrayList = new ArrayList<>();

        Collections.addAll(contentArrayList,
                new Movie("Extraction","Netflix","Adventure",R.drawable.extr,R.drawable.netf,2022,"2hrs" ,"James Cameron"),
                new Serie("WandaVision","Marvel","Comicbook",R.drawable.wanda,R.drawable.disney,2021,1 ,8),
                new Serie("The Last of Us","HBO Max","VideoGame",R.drawable.tlou,R.drawable.hbo,2023,1 ,12),
                new Movie("Batman v Superman","DC","Comicbook",R.drawable.boys,R.drawable.hbo,2022,"3hrs" ,"Jack Snyder"),
                new Serie("See","Apple","Sci-Fi",R.drawable.see,R.drawable.apptv,2021,1 ,8),
                new Movie("Oppenheimer","Netflix","History",R.drawable.opp,R.drawable.netf,2023,"2hrs" ,"Nolan"),
                new Serie("Moon Knight","Marvel","Superhero",R.drawable.moon,R.drawable.disney,2022,1 ,8)
        );
    }

    public static ArrayList<Content> getContentArrayList() {
        return contentArrayList;
    }
}
