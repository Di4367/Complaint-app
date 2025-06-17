package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    Button logoutBtn, aboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        logoutBtn = findViewById(R.id.btn_logout);
        aboutBtn = findViewById(R.id.btn_about); // Make sure this ID matches your XML

        // Logout Functionality
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Clear user session here if needed (like SharedPreferences, tokens, etc.)

                // Navigate to LoginActivity
                Intent intent = new Intent(SettingsActivity.this, LoginactivityActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear backstack
                startActivity(intent);
                finish(); // Finish SettingsActivity
            }
        });

        // About Button Functionality
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(SettingsActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
            }
        });
    }
}
