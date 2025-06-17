package com.example.final_project;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SentActivity extends AppCompatActivity {

    private ImageView blueTickImageView;
    private TextView successMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sent);

        // Initialize UI components
        blueTickImageView = findViewById(R.id.blue_tick);
        successMessageTextView = findViewById(R.id.success_message);

        // Optionally, you can update the message dynamically
        successMessageTextView.setText("Complaint Submitted Successfully");
    }
}

