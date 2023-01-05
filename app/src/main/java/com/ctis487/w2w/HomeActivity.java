package com.ctis487.w2w;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ctis487.w2w.databinding.ActivityHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements CustomRecyclerViewAdapter.ContentRecyclerAdapterInterface {

    ActivityHomeBinding binding;
    CustomRecyclerViewAdapter adapter;
    Dialog dialog,newdialog;

    private RecyclerView recyclerView;
    private NewsAdapter adapter2;
    private List<NewsItem> newsItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.batman);

        mediaPlayer.start();

        ContentSys.prepareData();
        adapter = new CustomRecyclerViewAdapter(this, ContentSys.getContentArrayList());
        binding.recyclerCon.setAdapter(adapter);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        binding.recyclerCon.setLayoutManager(staggeredGridLayoutManager);

        recyclerView = findViewById(R.id.newsCon);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        newsItemList = new ArrayList<>();

        try {
            // Read the JSON file and parse it into a list of NewsItem objects
            JSONArray jsonArray = new JSONArray(readJSONFromAsset());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String title = jsonObject.getString("title");
                String description = jsonObject.getString("description");
                String datePublished = jsonObject.getString("date_published");
                String source = jsonObject.getString("source");
                newsItemList.add(new NewsItem(title, description, datePublished, source));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter2 = new NewsAdapter(this, newsItemList);
        recyclerView.setAdapter(adapter2);
    }

    public void displayDialog(Content con){
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        TextView tvDialogName = dialog.findViewById(R.id.tvDialogName);
        Button btnDialogClose = dialog.findViewById(R.id.btnDialogClose);
        ImageView compImg = dialog.findViewById(R.id.compImg);
        compImg.setImageResource(con.getImgID());
        tvDialogName.setText(con.getCompanyName());
        btnDialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void displayItem(Content con) {
        displayDialog(con);
    }

    public void displayNew(NewsItem news) {
        displayNewDialog(news);
    }

    public void displayNewDialog(NewsItem news){
        newdialog = new Dialog(this);
        newdialog.setContentView(R.layout.newdialog);
        TextView tvDialogName = newdialog.findViewById(R.id.tvDialogName);
        TextView tvDialogText = newdialog.findViewById(R.id.tvDialogText);
        Button btnDialogClose = newdialog.findViewById(R.id.btnDialogClose);
        tvDialogName.setText(news.getTitle());
        tvDialogText.setText(news.getDescription());
        btnDialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("news.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
