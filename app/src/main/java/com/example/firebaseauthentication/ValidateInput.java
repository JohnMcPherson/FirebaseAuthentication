package com.example.firebaseauthentication;

import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

class ValidateInput {
    private Context context;
    private EditText email, password;

    ValidateInput(Context myContext, EditText myEmail, EditText myPassword) {
        context = myContext;
        email = myEmail;
        password = myPassword;
    }

    boolean validateEmail() {
        String emailInput = email.getText().toString().trim();
        if (emailInput.isEmpty()) {
            Toast.makeText(context, "Please enter your email address", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Toast.makeText(context, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    boolean validatePassword() {
        String passwordInput = password.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            Toast.makeText(context, "Please enter your password", Toast.LENGTH_SHORT).show();
            return false;
        } else if (passwordInput.length() < 8) {
            Toast.makeText(context, "Please enter a valid password", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}
