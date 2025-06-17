package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginactivityActivity extends AppCompatActivity {

    private EditText collegeId, password;
    private Button loginBtn;
    private TextView signUpText;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        auth = FirebaseAuth.getInstance();
        collegeId = findViewById(R.id.collegeId);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        signUpText = findViewById(R.id.signUpText);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = collegeId.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (!user.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(user).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(user, pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(LoginactivityActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        // Redirect to StudentActivity instead of WelcomePageActivity
                                        startActivity(new Intent(LoginactivityActivity.this, StudentactivityActivity.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(LoginactivityActivity.this, "Login failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        password.setError("Password cannot be empty");
                    }
                } else if (user.isEmpty()) {
                    collegeId.setError("Email cannot be empty");
                } else {
                    collegeId.setError("Please enter a valid email");
                }
            }
        });

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginactivityActivity.this, SignupActivity.class));
            }
        });
    }
}
