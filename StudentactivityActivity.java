package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentactivityActivity extends AppCompatActivity {

    Button newComplaintBtn, myComplaintsBtn, viewDetailsBtn;
    ImageView notificationIcon, navHome, navComplaints, navNew, navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentactivity); // Make sure your XML file is named student.xml

        // Action Buttons
        newComplaintBtn = findViewById(R.id.newComplaintBtn);
        myComplaintsBtn = findViewById(R.id.myComplaintsBtn);
        viewDetailsBtn = findViewById(R.id.viewDetailsBtn);

        // Notification Icon
        notificationIcon = findViewById(R.id.notificationIcon);

        // Bottom Navigation Icons
        navHome = findViewById(R.id.nav_home);
        navComplaints = findViewById(R.id.nav_complaints);
        navNew = findViewById(R.id.nav_new);
        navProfile = findViewById(R.id.nav_profile);

        // Click Listeners

        viewDetailsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(StudentactivityActivity.this, DetailsActivity.class);
            startActivity(intent);
        });

        newComplaintBtn.setOnClickListener(v -> {
            // Start New Complaint Activity
            Intent intent = new Intent(StudentactivityActivity.this, NewComplaintActivity.class);
            startActivity(intent);
        });

        myComplaintsBtn.setOnClickListener(v -> {
            // Replace with your activity for My Complaints
            Intent intent = new Intent(StudentactivityActivity.this, MycomplaintActivity.class);
            startActivity(intent);
        });

        notificationIcon.setOnClickListener(v -> {
            // Replace with your Notification activity or logic
            Toast.makeText(StudentactivityActivity.this, "Notifications", Toast.LENGTH_SHORT).show();
        });

        navHome.setOnClickListener(v -> {
            Toast.makeText(StudentactivityActivity.this, "Home", Toast.LENGTH_SHORT).show();
            // Optional: Refresh or go to home screen
        });

        navComplaints.setOnClickListener(v -> {
            // Replace with Complaints activity
            Toast.makeText(StudentactivityActivity.this, "Complaints", Toast.LENGTH_SHORT).show();
        });

        navNew.setOnClickListener(v -> {
            // Redirect to New Complaint Activity
            Intent intent = new Intent(StudentactivityActivity.this, NewComplaintActivity.class);
            startActivity(intent);
        });

        navProfile.setOnClickListener(v -> {
            // Redirect to New Complaint Activity
            Intent intent = new Intent(StudentactivityActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}
