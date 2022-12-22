package com.ctis487.w2w;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    ImageView miniLogo;
    Button nextBut, backBut;
    TextInputLayout nameSignLayout,usernameSignLayout,psw1Layout,psw2Layout;
    TextInputEditText nameSignText,usernameSignText,psw1Text,psw2Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign);

        dbHelper = new DatabaseHelper(this);
        Log.d("DATABASE", "OK");

        nameSignLayout = (TextInputLayout) findViewById(R.id.nameSignLayout);
        nameSignText = (TextInputEditText) findViewById(R.id.nameSignText);
        usernameSignLayout = (TextInputLayout) findViewById(R.id.nameSignLayout);
        usernameSignText = (TextInputEditText) findViewById(R.id.usernameSignText);
        psw1Layout = (TextInputLayout) findViewById(R.id.psw1Layout);
        psw1Text = (TextInputEditText) findViewById(R.id.psw1Text);
        psw2Layout = (TextInputLayout) findViewById(R.id.psw2Layout);
        psw2Text = (TextInputEditText) findViewById(R.id.psw2Text);

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

                String Name = nameSignText.getText().toString();
                String Username = usernameSignText.getText().toString();
                String psw = psw1Text.getText().toString();
                String psw2 = psw2Text.getText().toString();
                if(psw.equals(psw2)) {
                    String Password= psw;
                    boolean resinser = UserTable.insertUser(dbHelper, Name, Username, Password);
                    if (resinser) {
                        intent = new Intent(SignActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(SignActivity.this, "psw's not matching.", Toast.LENGTH_SHORT).show();
                }
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