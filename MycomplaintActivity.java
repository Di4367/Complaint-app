package com.example.final_project;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MycomplaintActivity extends AppCompatActivity {

    TextView textTitle, textLocation, textDescription, textCategory;
    ImageView imageComplaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycomplaint);

        textTitle = findViewById(R.id.textTitle);
        textLocation = findViewById(R.id.textLocation);
        textDescription = findViewById(R.id.textDescription);
        textCategory = findViewById(R.id.textCategory);
        imageComplaint = findViewById(R.id.imageComplaint);

        // Receive data from intent
        String title = getIntent().getStringExtra("title");
        String location = getIntent().getStringExtra("location");
        String description = getIntent().getStringExtra("description");
        String category = getIntent().getStringExtra("category");
        String imageUriStr = getIntent().getStringExtra("imageUri");

        Log.d("MyComplaintDebug", "Title: " + title + ", Location: " + location + ", Description: " + description + ", Category: " + category + ", ImageUri: " + imageUriStr);


        // Set data to UI
        textTitle.setText("Title: " + title);
        textLocation.setText("Location: " + location);
        textDescription.setText("Description: " + description);
        textCategory.setText("Category: " + category);

        if (imageUriStr != null && !imageUriStr.isEmpty()) {
            imageComplaint.setImageURI(Uri.parse(imageUriStr));
        }
    }
}
