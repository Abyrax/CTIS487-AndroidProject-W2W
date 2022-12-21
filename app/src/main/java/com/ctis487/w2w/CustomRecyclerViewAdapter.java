package com.ctis487.w2w;

import android.content.Context;
import android.media.Image;
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
            itemHolder.tvItemMovieCompanyName.setText(con.getItemName());
            itemHolder.tvItemMovieType.setText(con.getType());
            itemHolder.imgItemMovieImg.setImageResource(con.getImgID());

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
            itemHolder.tvItemSeriesCompanyName.setText(con.getItemName());
            itemHolder.tvItemSeriesType.setText(con.getType());
            itemHolder.imgItemSeriesImg.setImageResource(con.getImgID());

            //STEP8
            itemHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //((MainActivity)context).displayDialog(org);
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
        TextView tvItemMovieCompanyName, tvItemMovieType;
        ImageView imgItemMovieImg;
        ConstraintLayout parentLayout;

        public MovieItemHolder(@NonNull View itemView) {
            super(itemView);
            tvItemMovieCompanyName = itemView.findViewById(R.id.tvItemMovieCompanyName);
            tvItemMovieType=itemView.findViewById(R.id.tvItemMovieType);
            imgItemMovieImg= itemView.findViewById(R.id.tvItemMovieImg);
            parentLayout = itemView.findViewById(R.id.itemMovieConstraintLayout);
        }
    }

    //STEP2
    class SeriesItemHolder extends RecyclerView.ViewHolder{
        TextView tvItemSeriesCompanyName, tvItemSeriesType;
        ImageView imgItemSeriesImg;
        ConstraintLayout parentLayout;
        public SeriesItemHolder(@NonNull View itemView) {
            super(itemView);
            tvItemSeriesCompanyName = itemView.findViewById(R.id.tvItemSeriesCompanyName);
            tvItemSeriesType = itemView.findViewById(R.id.tvItemSeriesType);
            imgItemSeriesImg= itemView.findViewById(R.id.tvItemSeriesImg);
            parentLayout = itemView.findViewById(R.id.itemSeriesConstraintLayout);
        }
    }
}
