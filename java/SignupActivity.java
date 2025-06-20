package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    EditText collegeId, password;
    Button loginBtn;
    TextView signUpText;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

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

                if(user.isEmpty())
                {
                    collegeId.setError("Email cannot be empty");
                }
                if(pass.isEmpty())
                {
                    password.setError("Password cannot be empty");
                }
                else {
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {

                                Toast.makeText(SignupActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignupActivity.this, LoginactivityActivity.class));
                            }
                            else
                            {
                                Toast.makeText(SignupActivity.this, "Login Falied" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginactivityActivity.class));
            }
        });
    }
}
