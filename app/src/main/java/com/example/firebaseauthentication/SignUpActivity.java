package com.example.firebaseauthentication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.firebaseauthentication.databinding.ActivityMainBinding;
import com.example.firebaseauthentication.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ValidateInput validateInput;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySignUpBinding binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        validateInput = new ValidateInput(
                this,
                binding.signUpEmail,
                binding.signUpPassword,
                binding.repeatPassword);

        binding.backArrow3.setOnClickListener(view -> {
            finish();
        });

        binding.signUpButton.setOnClickListener(view -> {
            boolean emailVerified = validateInput.validateEmail();
            boolean passwordVerified = validateInput.validatePassword();
            boolean repeatPasswordVerified = validateInput.repeatPasswordValidation();

            if (emailVerified && passwordVerified && repeatPasswordVerified) {
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}