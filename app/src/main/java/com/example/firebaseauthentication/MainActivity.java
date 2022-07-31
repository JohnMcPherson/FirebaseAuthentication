package com.example.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaseauthentication.databinding.ActivityMainBinding;
import com.example.firebaseauthentication.databinding.ActivityUpdatePasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ValidateInput validateInput;

    private FirebaseAuth mAuth;

    ActivityMainBinding binding;

    String email, password;
    AlertDialog.Builder builder;

    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        validateInput = new ValidateInput(
                this,
                binding.signInEmail,
                binding.signInPassword);

        mAuth = FirebaseAuth.getInstance();

        binding.createAccountTxt.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);

        });

        binding.signInButton.setOnClickListener(view -> {
            signInAccount();
         });
    }

    public void signInAccount() {

        boolean emailVerified = validateInput.validateEmail();
        boolean passwordVerified = validateInput.validatePassword();

        if (emailVerified && passwordVerified) {
            loadingAnimation();
            email = binding.signInEmail.getText().toString().trim();
            password = binding.signInPassword.getText().toString().trim();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(MainActivity.this, "Fatal Error", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
        }
    }

    public void loadingAnimation() {
        LayoutInflater inflater = getLayoutInflater();
        builder = new AlertDialog.Builder(this);
        builder.setView(inflater.inflate(R.layout.loading, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }
}