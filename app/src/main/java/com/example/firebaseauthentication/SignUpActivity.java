package com.example.firebaseauthentication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.firebaseauthentication.databinding.ActivityMainBinding;
import com.example.firebaseauthentication.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySignUpBinding binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backArrow3.setOnClickListener(view -> {
            finish();
        });
    }
}