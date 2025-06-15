package com.example.final_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class upload extends AppCompatActivity {
    ImageView uploadImage;
    Button saveButton;
    EditText uploadTopic, uploadDesc, uploadLang;
    String imageURL;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        uploadImage = findViewById(R.id.uploadimage);
        uploadDesc = findViewById(R.id.uploaddesc);
        uploadTopic = findViewById(R.id.uploadtopic);
        uploadLang = findViewById(R.id.uploadlang);
        saveButton = findViewById(R.id.savebutton);
    }
}