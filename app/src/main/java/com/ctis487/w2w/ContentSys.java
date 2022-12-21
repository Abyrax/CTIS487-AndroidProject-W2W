package com.ctis487.w2w;

import java.util.ArrayList;
import java.util.Collections;

public class ContentSys {
    private static ArrayList<Content> contentArrayList;

    public static void prepareData(){
        contentArrayList = new ArrayList<>();

        Collections.addAll(contentArrayList,
                new Movie("Bullet Train","Netflix","Adventure",R.drawable.w2w,2022,"2hrs" ,"James Cameron"),
                new Serie("WandaVision","Marvel","Comicbook",R.drawable.w2w,2021,1 ,8),
                new Movie("Batman v Superman","DC","Comicbook",R.drawable.w2w,2022,"3hrs" ,"Jack Snyder"),
                new Serie("The Last of Us","HBO Max","VideoGame",R.drawable.w2w,2023,1 ,12)
        );
    }

    public static ArrayList<Content> getContentArrayList() {
        return contentArrayList;
    }
}
