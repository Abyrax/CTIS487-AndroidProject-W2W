package com.ctis487.w2w;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class SignActivity extends AppCompatActivity {

    ImageView miniLogo;
    Button nextBut, backBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign);

        miniLogo=findViewById(R.id.miniLogo);
        rotate(miniLogo);

        backBut=findViewById(R.id.backBut);
        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(SignActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        nextBut=findViewById(R.id.nextBut);
        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(SignActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void rotate(ImageView name) {
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(50000);
        rotate.setInterpolator(new LinearInterpolator());

        name.startAnimation(rotate);
    }
}