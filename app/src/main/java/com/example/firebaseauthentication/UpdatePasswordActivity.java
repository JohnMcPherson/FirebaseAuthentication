package com.example.firebaseauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.firebaseauthentication.databinding.ActivityHomeBinding;
import com.example.firebaseauthentication.databinding.ActivityUpdatePasswordBinding;

public class UpdatePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUpdatePasswordBinding binding = ActivityUpdatePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backArrow3.setOnClickListener(view -> {
            finish();
        });
    }
}