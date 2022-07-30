package com.example.firebaseauthentication;

import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

class ValidateInput {
    private Context context;
    private EditText email, password, repeatPassword;

    String emailInput, passwordInput, repeatPasswordInput;

    ValidateInput(Context myContext, EditText myEmail, EditText myPassword) {
        context = myContext;
        email = myEmail;
        password = myPassword;
    }

    ValidateInput(Context myContext, EditText myEmail, EditText myPassword, EditText myRepeatPassword) {
        context = myContext;
        email = myEmail;
        password = myPassword;
        repeatPassword = myRepeatPassword;
    }

    boolean validateEmail() {
        emailInput = email.getText().toString().trim();
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
        passwordInput = password.getText().toString().trim();
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

    boolean repeatPasswordValidation() {
        passwordInput = password.getText().toString().trim();
        repeatPasswordInput = repeatPassword.getText().toString().trim();

        if (repeatPasswordInput.isEmpty()) {
            Toast.makeText(context, "Fill out all fields", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!repeatPasswordInput.equals(passwordInput)) {
            Toast.makeText(context, "Passwords don't match", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}
