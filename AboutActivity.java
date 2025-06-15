package com.example.final_project;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        // Optional: Set the title in the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("About Unmute");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enables back button
        }
    }

    // Handle back button in action bar
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
