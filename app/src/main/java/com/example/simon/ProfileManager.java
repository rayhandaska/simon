package com.example.simon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileManager extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    TextView textViewUsername, textViewUserEmail, textViewNomorTelpon, textViewNamaLengkap;
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
        setContentView(R.layout.activity_profile);

        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        textViewUserEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewNomorTelpon = (TextView) findViewById(R.id.textViewNomor);
        textViewNamaLengkap = (TextView) findViewById(R.id.textViewNama);


        textViewUserEmail.setText(SharedPrefManager.getInstance(this).getUserEmail());
        textViewUsername.setText(SharedPrefManager.getInstance(this).getUsername());
        textViewNomorTelpon.setText(SharedPrefManager.getInstance(this).getNomorTelp());
        textViewNamaLengkap.setText(SharedPrefManager.getInstance(this).getNamaLengkap());

        bottomNavigationView =findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.messagemanager:
                        Intent intent2 = new Intent(ProfileManager.this, Message.class);
                        startActivity(intent2);
                        return true;
                    case R.id.profilemanager:
                        Intent intent3 = new Intent(ProfileManager.this, ProfileManager.class);
                        startActivity(intent3);
                        return true;
                }
                return false;
            }

        });
    }

}