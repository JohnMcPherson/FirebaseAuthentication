package com.example.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.firebaseauthentication.databinding.ActivityMainBinding;
import com.example.firebaseauthentication.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    ValidateInput validateInput;
    private FirebaseAuth mAuth;

    String email, password;
    ActivitySignUpBinding binding;
    AlertDialog.Builder builder;

    AlertDialog dialog;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        builder = new AlertDialog.Builder(this);

        validateInput = new ValidateInput(
                this,
                binding.signUpEmail,
                binding.signUpPassword,
                binding.repeatPassword);

        binding.backArrow3.setOnClickListener(view -> {
            finish();
        });

        binding.signUpButton.setOnClickListener(view -> {
            signUpNewAccount();
        });

    }

    public void signUpNewAccount() {
        loadingAnimation();

        boolean emailVerified = validateInput.validateEmail();
        boolean passwordVerified = validateInput.validatePassword();
        boolean repeatPasswordVerified = validateInput.repeatPasswordValidation();

        if (emailVerified && passwordVerified && repeatPasswordVerified) {
            email = binding.signUpEmail.getText().toString().trim();
            password = binding.signUpPassword.getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Fatal error", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
        } else {
            dialog.dismiss();
        }
    }

    public void loadingAnimation() {
        LayoutInflater inflater = getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loading, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }
}


