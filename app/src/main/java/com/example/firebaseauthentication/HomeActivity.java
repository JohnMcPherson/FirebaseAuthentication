package com.example.firebaseauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.firebaseauthentication.databinding.ActivityHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        if(mUser != null) {
            binding.emailAddressTxt.setText(mUser.getEmail());
            binding.idTxt.setText(mUser.getUid());
        }

        binding.updateEmailBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, UpdateEmailActivity.class);
            startActivity(intent);
        });

        binding.updatePasswordBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, UpdatePasswordActivity.class);
            startActivity(intent);
        });
    }
}