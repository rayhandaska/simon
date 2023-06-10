package com.example.simon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    androidx.constraintlayout.widget.ConstraintLayout btn,btn2,btn3;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_main2);
        btn = findViewById(R.id.constraintLayout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, Camera.class);
                startActivity(intent);
            }
        });
        btn2 = findViewById(R.id.constraintLayout2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, Recording.class);
                startActivity(intent);
            }
        });
        btn3 = findViewById(R.id.constraintLayout3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, Setting.class);
                startActivity(intent);
            }
        });
        bottomNavigationView =findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home :
                        Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                        startActivity(intent);
                        return true;
                    case R.id.message :
                        Intent intent2 = new Intent(MainActivity2.this, Message.class);
                        startActivity(intent2);
                        return true;
                    case R.id.profile:
                        Intent intent3 = new Intent(MainActivity2.this, Profile.class);
                        startActivity(intent3);
                        return true;
                }
                return false;
            }

        });
    }

}