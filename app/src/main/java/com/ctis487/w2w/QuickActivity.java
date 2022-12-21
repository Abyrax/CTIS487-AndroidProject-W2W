package com.ctis487.w2w;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ctis487.w2w.databinding.ActivityQuickBinding;

public class QuickActivity extends AppCompatActivity implements CustomRecyclerViewAdapter.ContentRecyclerAdapterInterface {

    ActivityQuickBinding binding;
    CustomRecyclerViewAdapter adapter;
    Button backBut;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityQuickBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        backBut=findViewById(R.id.backBut);
        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(QuickActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ContentSys.prepareData();
        adapter = new CustomRecyclerViewAdapter(this, ContentSys.getContentArrayList());
        binding.recyclerCon.setAdapter(adapter);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        binding.recyclerCon.setLayoutManager(staggeredGridLayoutManager);
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
}