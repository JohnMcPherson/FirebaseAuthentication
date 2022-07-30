package com.example.firebaseauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.firebaseauthentication.databinding.ActivityUpdateEmailBinding;

public class UpdateEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUpdateEmailBinding binding = ActivityUpdateEmailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.backArrow2.setOnClickListener(view -> {
            finish();
        });
    }
}