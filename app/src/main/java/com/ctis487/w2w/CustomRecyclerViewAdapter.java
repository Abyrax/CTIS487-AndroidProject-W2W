package com.ctis487.w2w;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder > implements ContentType{
    Context context;
    private ArrayList<Content> recyclerItemValues;

    interface ContentRecyclerAdapterInterface {
        //STEP2: Which actions has to be implemented in activities, define corresponding methods for each
        void displayItem(Content con);
    }

    //STEP3: Create a reference from interface type
    ContentRecyclerAdapterInterface conAdapterInterface;

    public CustomRecyclerViewAdapter(Context context, ArrayList<Content> values){
        this.context = context;
        this.recyclerItemValues = values;
        conAdapterInterface = (ContentRecyclerAdapterInterface)context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView;
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());
        //STEP4
        if(viewType == TYPE_MOVIE) {
            //STEP5
            itemView = inflator.inflate(R.layout.recycler_movie_item, viewGroup, false);
            MovieItemHolder mViewHolder = new MovieItemHolder(itemView);
            return mViewHolder;
        }
        else {
            //STEP5
            itemView = inflator.inflate(R.layout.recycler_serie_item, viewGroup, false);
            SeriesItemHolder mViewHolder = new SeriesItemHolder(itemView);
            return mViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewItemHolder, int position) {
        final Content con = recyclerItemValues.get(position);
        //STEP6
        if(getItemViewType(position) == TYPE_MOVIE){
            //STEP7
            MovieItemHolder itemHolder= (MovieItemHolder) viewItemHolder;
            itemHolder.movieName.setText(con.getItemName());
            itemHolder.movieType.setText(con.getType());
            itemHolder.movieYear.setText(String.valueOf(con.getYear()));
            itemHolder.movieIMG.setImageResource(con.getImgID());
            itemHolder.compIMG.setImageResource(con.getCompID());

            //STEP8
            itemHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    conAdapterInterface.displayItem(con);
                    //((MainActivity)context).displayDialog(org);
                }
            });
        }
        else {
            //STEP7

            SeriesItemHolder itemHolder = (SeriesItemHolder)viewItemHolder;
            itemHolder.movieName.setText(con.getItemName());
            itemHolder.movieType.setText(con.getType());
            itemHolder.movieYear.setText(String.valueOf(con.getYear()));
            itemHolder.movieIMG.setImageResource(con.getImgID());
            itemHolder.compIMG.setImageResource(con.getCompID());

            //STEP8
            itemHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    conAdapterInterface.displayItem(con);
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return recyclerItemValues.size();
    }

    //STEP1:
    @Override
    public int getItemViewType(int position) {
        Content con = recyclerItemValues.get(position);
        if(con instanceof Movie)
            return TYPE_MOVIE;
        else
            return TYPE_SERIES;
    }


    //STEP2
    class MovieItemHolder extends RecyclerView.ViewHolder{
        TextView movieName, movieType, movieYear;
        ImageView movieIMG, compIMG;
        ConstraintLayout parentLayout;

        public MovieItemHolder(@NonNull View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movieName);
            movieType=itemView.findViewById(R.id.movieType);
            movieYear=itemView.findViewById(R.id.movieYear);
            movieIMG=itemView.findViewById(R.id.movieIMG);
            compIMG=itemView.findViewById(R.id.compIMG);
            parentLayout = itemView.findViewById(R.id.itemMovieConstraintLayout);
        }
    }

    //STEP2
    class SeriesItemHolder extends RecyclerView.ViewHolder{
        TextView movieName, movieType, movieYear;
        ImageView movieIMG, compIMG;
        ConstraintLayout parentLayout;
        public SeriesItemHolder(@NonNull View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movieName);
            movieType=itemView.findViewById(R.id.movieType);
            movieYear=itemView.findViewById(R.id.movieYear);
            movieIMG=itemView.findViewById(R.id.movieIMG);
            compIMG=itemView.findViewById(R.id.compIMG);
            parentLayout = itemView.findViewById(R.id.itemMovieConstraintLayout);
        }
    }
}
