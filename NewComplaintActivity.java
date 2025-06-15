package com.example.final_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class NewComplaintActivity extends AppCompatActivity {

    // UI Elements
    private EditText editTitle, editLocation, editDescription;
    private Spinner spinnerCategory;
    private Button btnSubmitComplaint, btnChooseImage;
    private TextView selectedImageText;
    private Uri selectedImageUri;

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final String TAG = "NewComplaintActivity";

    // Firebase Reference
    private DatabaseReference complaintsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_complaint);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true); // Optional: keep data offline
        complaintsRef = database.getReference("complaints");

        // Link UI elements
        editTitle = findViewById(R.id.editTitle);
        editLocation = findViewById(R.id.editLocation);
        editDescription = findViewById(R.id.editDescription);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        btnSubmitComplaint = findViewById(R.id.btnSubmitComplaint);
        btnChooseImage = findViewById(R.id.btnChooseImage);
        selectedImageText = findViewById(R.id.selectedImageText);

        // Spinner category options
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Electrical");
        categories.add("Water Supply");
        categories.add("Mess Food");
        categories.add("Cleanliness");
        categories.add("Hostel Rules");
        categories.add("Others");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        // Image picker
        btnChooseImage.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
        });

        // Submit button click
        btnSubmitComplaint.setOnClickListener(view -> submitComplaintToFirebase());
    }

    private void submitComplaintToFirebase() {
        String title = editTitle.getText().toString().trim();
        String location = editLocation.getText().toString().trim();
        String description = editDescription.getText().toString().trim();
        String category = spinnerCategory.getSelectedItem().toString();

        // Validate input
        if (title.isEmpty() || location.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String complaintId = complaintsRef.push().getKey();

        if (complaintId == null) {
            Toast.makeText(this, "Error generating complaint ID", Toast.LENGTH_SHORT).show();
            return;
        }

        // Data map
        HashMap<String, Object> complaint = new HashMap<>();
        complaint.put("title", title);
        complaint.put("location", location);
        complaint.put("description", description);
        complaint.put("category", category);
        complaint.put("imageUri", selectedImageUri != null ? selectedImageUri.toString() : "");
        complaint.put("timestamp", System.currentTimeMillis());
        complaint.put("status", "Pending");
        complaint.put("userId", "user123"); // Replace with actual user ID if available

        // Submit to Firebase
        complaintsRef.child(complaintId).setValue(complaint)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Complaint Submitted Successfully", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Complaint submitted with ID: " + complaintId);

                        // Navigate to SentActivity
                        Intent intent = new Intent(NewComplaintActivity.this, SentActivity.class);
                        startActivity(intent);
                        finish(); // Optional: finish current activity
                    } else {
                        Toast.makeText(this, "Failed to Submit Complaint", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "Firebase Error: ", task.getException());
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedImageUri = data.getData();
            String fileName = selectedImageUri.getLastPathSegment();
            selectedImageText.setText("Image selected: " + (fileName != null ? fileName.substring(fileName.lastIndexOf('/') + 1) : "unknown"));
        }
    }
}
