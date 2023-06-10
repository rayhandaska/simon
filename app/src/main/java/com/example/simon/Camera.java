package com.example.simon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Camera extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    androidx.constraintlayout.widget.ConstraintLayout btn,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        btn = findViewById(R.id.constraintLayout1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera.this, Searching1.class);
                startActivity(intent);
            }
        });
        btn2 = findViewById(R.id.constraintLayout2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera.this, Searching2.class);
                startActivity(intent);
            }
        });
        btn3 = findViewById(R.id.constraintLayout3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera.this, Searching3.class);
                startActivity(intent);
            }
        });
        btn4 = findViewById(R.id.constraintLayout4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera.this, Searching4.class);
                startActivity(intent);
            }
        });
        btn5 = findViewById(R.id.constraintLayout5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera.this, Searching5.class);
                startActivity(intent);
            }
        });
        btn6 = findViewById(R.id.constraintLayout6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera.this, Searching6.class);
                startActivity(intent);
            }
        });
        btn7 = findViewById(R.id.constraintLayout7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera.this, Searching7.class);
                startActivity(intent);
            }
        });
        btn8 = findViewById(R.id.constraintLayout8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera.this, Searching8.class);
                startActivity(intent);
            }
        });
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        bottomNavigationView =findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home :
                        Intent intent = new Intent(Camera.this, MainActivity2.class);
                        startActivity(intent);
                        return true;
                    case R.id.message :
                        Intent intent2 = new Intent(Camera.this, Message.class);
                        startActivity(intent2);
                        return true;
                    case R.id.profile:
                        Intent intent3 = new Intent(Camera.this, Profile.class);
                        startActivity(intent3);
                        return true;
                }
                return false;
            }

        });
    }

}