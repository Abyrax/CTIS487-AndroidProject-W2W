package com.ctis487.w2w;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements TouchType {

    private GestureDetectorCompat gestureDetector;
    ImageView logo;
    Button signBut,loginBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        logo=findViewById(R.id.Logo);
        animate(logo);

        signBut=findViewById(R.id.signBut);
        signBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(MainActivity.this, SignActivity.class);
                startActivity(intent);
            }
        });

        loginBut=findViewById(R.id.loginBut);
        signBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        gestureDetector = new GestureDetectorCompat(this, new CustomGestureListener());
    }
    public void animate(ImageView name) {
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                name,
                PropertyValuesHolder.ofFloat("scaleX", 1.1f),
                PropertyValuesHolder.ofFloat("scaleY", 1.1f));
        scaleDown.setDuration(1000);

        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);

        scaleDown.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {
        Bundle bundle = new Bundle();

        public boolean onDoubleTap(MotionEvent event) {
            Intent intent = new Intent(MainActivity.this, QuickActivity.class);
            bundle.putInt("key", TYPE_GESTUREDOUBLE);
            intent.putExtras(bundle);
            startActivity(intent);
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            Intent intent = new Intent(MainActivity.this, CreditsActivity.class);
            bundle.putInt("key", TYPE_GESTURELONG);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}