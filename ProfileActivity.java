package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView nameText, emailText, deptText, myComplaints, settings, about, helpSupport;
    Button editProfileBtn, logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile); // Make sure this matches your XML filename

        // Initialize views
        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        deptText = findViewById(R.id.deptText);
        myComplaints = findViewById(R.id.mycomplaints);
        settings = findViewById(R.id.settings);
        about = findViewById(R.id.about);
        helpSupport = findViewById(R.id.helpSupport);
        editProfileBtn = findViewById(R.id.editprofileBtn);
        logoutBtn = findViewById(R.id.logoutBtn);

        // Set dummy user data (you can fetch from SharedPreferences or DB here)
        nameText.setText("Disha");
        emailText.setText("sharmadishaujjain@gmail.com");
        deptText.setText("Information Technology · 70012200101");

        // Edit Profile Button
        editProfileBtn.setOnClickListener(view ->
                Toast.makeText(this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show());

        // Logout Button
        logoutBtn.setOnClickListener(view -> {
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
            // Add actual logout logic here (e.g., clearing session)
            finish(); // or navigate to login screen
        });

        // Navigate to SettingsActivity
        settings.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        // My Complaints
        myComplaints.setOnClickListener(view ->
                Toast.makeText(this, "My Complaints", Toast.LENGTH_SHORT).show());

        // About
        about.setOnClickListener(view ->
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show());

        // Help & Support
        helpSupport.setOnClickListener(view ->
                Toast.makeText(this, "Help & Support", Toast.LENGTH_SHORT).show());
    }
}
